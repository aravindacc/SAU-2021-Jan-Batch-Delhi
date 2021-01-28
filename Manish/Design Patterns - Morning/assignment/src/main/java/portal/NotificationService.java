package portal;

import model.Notification;

public class NotificationService {

    private static final NotificationService instance = new NotificationService();

    private NotificationService() {}

    public static NotificationService getInstance() {
        return instance;
    }

    public boolean sendNotification(Notification notification) {
        // sending the notification
        System.out.println(notification);
        return true;
    }

}
