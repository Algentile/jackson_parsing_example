package messages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestJacksonMapping {

    //Static variables for first and second support messages
    private static final String SUPPORT_MESSAGE_ONE = "Item one requires support!";
    private static final String SUPPORT_MESSAGE_TWO = "Item two requires support!";
    private static final String CONTACT_ONE = "a_person";
    private static final String CONTACT_TWO = "b_person";
    private static final String FIRST_ASSIGNMENT = "a_assigned";
    private static final String SECOND_ASSIGNMENT = "b_assigned";

    //Static variables for first and second system messages
    private static final String SYSTEM_MESSAGE_ONE = "container is up and healthy";
    private static final String SYSTEM_MESSAGE_TWO = "container is unhealthy, please retry";

    private ObjectMapper mapper;
    private MessageHandler handler;
    private SupportTicket supportMessage;
    private SupportTicket secondSupportMessage;
    private SystemMessage systemMessage;
    private SystemMessage secondSystemMessage;

    @Before
    public void setUp() {
        mapper = new ObjectMapper();

        supportMessage = new SupportTicket(SUPPORT_MESSAGE_ONE, CONTACT_ONE, FIRST_ASSIGNMENT);
        secondSupportMessage = new SupportTicket(SUPPORT_MESSAGE_TWO, CONTACT_TWO, SECOND_ASSIGNMENT);

        systemMessage = new SystemMessage(SYSTEM_MESSAGE_ONE, SystemState.HEALTHY);
        secondSystemMessage = new SystemMessage(SYSTEM_MESSAGE_TWO, SystemState.CRITICAL);

        List<Message> messageList = new ArrayList<>();
        messageList.add(supportMessage);
        messageList.add(systemMessage);
        messageList.add(secondSupportMessage);
        messageList.add(secondSystemMessage);

        handler = new MessageHandler();
        handler.setMessages(messageList);
    }

    @After
    public void tearDown() {
        supportMessage = null;
        secondSupportMessage = null;
        systemMessage = null;
        secondSystemMessage = null;
        handler = null;
        mapper = null;
    }

    @Test
    public void testJsonMapping() {
        String jsonString = null;
        String subObject = null;
        try {
            jsonString = mapper.writeValueAsString(handler);
            subObject = mapper.writeValueAsString(handler.getMessages().get(0));

        } catch (JsonProcessingException e) {
            //Do nothing here
        }
        System.out.println(jsonString);
        System.out.println(subObject);
    }
}
