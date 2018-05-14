package messages;

import java.util.ArrayList;
import java.util.List;

/**
 * A super dumb message handler class
 */
public class MessageHandler {

    private List<Message> messages;

    public MessageHandler() {
        this.messages = new ArrayList<Message>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
