package model;

import org.w3c.dom.Node;

import java.time.LocalDateTime;

public class Notification {

    private NotificationType type;
    private String message;
    private LocalDateTime time;

    public Notification() {}

    public Notification(NotificationType type, String message, LocalDateTime time) {
        this.type = type;
        this.message = message;
        this.time = time;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "type=" + type +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}
