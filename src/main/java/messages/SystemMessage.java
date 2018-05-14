package messages;

import java.sql.Time;

/**
 * System Message classe to be used in System container
 * service.
 */
public class SystemMessage extends Message {

    private Time systemTime;

    private SystemState state;

    protected SystemMessage(String content) {
        super(content);
        systemTime = new Time(System.currentTimeMillis());
        state = SystemState.HEALTHY;
    }

    public void publishMessage() {

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

    private enum SystemState {
        CRITICAL,
        WARNING,
        HEALTHY
    }
}
