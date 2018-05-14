package messages;

/**
 * Support message class to be used in a Ticketing Service
 */
public class SupportTicket extends Message {

    //Name of contact that created SupportTicket
    private String contact;

    //Name of the person the ticket is assignedTo
    private String assignedTo;

    public SupportTicket(String content, String contact, String assignedTo) {
        super(content);
        this.contact = contact;
        this.assignedTo = assignedTo;
    }

    public void publishMessage() {
        //Do Nothing for now
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}
