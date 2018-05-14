package messages;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonSubTypes.*;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.*;

@JsonTypeInfo(use = Id.CLASS,
        include = As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = SupportTicket.class),
        @Type(value = SystemMessage.class)
})
public abstract class Message {

    private UUID id;

    private String content;

    protected Message(String content) {
        this.id = UUID.randomUUID();
        this.content = content;
    }

    public abstract void publishMessage();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
