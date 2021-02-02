package portal;

import model.Notification;
import model.NotificationType;

import java.time.LocalDateTime;

public class NotificationBuilder {

    public void buildNotification() {

    }

    public Notification createNotification(NotificationType type, String message) {
        Notification notification = new Notification();
        notification.setType(type);
        notification.setMessage(message);
        notification.setTime(LocalDateTime.now());
        return notification;
    }

}
