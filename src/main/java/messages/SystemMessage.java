package messages;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.sql.Time;

/**
 * System Message classes to be used in System container
 * service.
 */
public class SystemMessage extends Message {

    private Time systemTime;

    private SystemState state;

    protected SystemMessage(String content, SystemState state) {
        super(content);
        this.systemTime = new Time(System.currentTimeMillis());
        this.state = state;
    }

    public void publishMessage() {
        //Do Nothing for now
    }

    public Time getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(Time systemTime) {
        this.systemTime = systemTime;
    }

    public SystemState getState() {
        return state;
    }

    public void setState(SystemState state) {
        this.state = state;
    }


}
