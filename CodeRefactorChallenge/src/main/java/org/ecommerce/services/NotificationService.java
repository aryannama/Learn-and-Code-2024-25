package org.ecommerce.services;

import static org.ecommerce.constants.Errors.ADMIN_NOTIFICATION_FAILED;
import static org.ecommerce.constants.Errors.CUSTOMER_NOTIFICATION_FAILED;
import static org.ecommerce.constants.Messages.ADMIN_NOTIFICATION;
import static org.ecommerce.constants.Messages.SENDING_EMAIL_TO;

public class NotificationService {
    public static void sendCustomerNotification(String email, String message) {
        try {
            System.out.println(String.format(SENDING_EMAIL_TO, email, message));
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(CUSTOMER_NOTIFICATION_FAILED);
        }
    }

    public static void sendAdminNotification(String message) {
        try {
            System.out.println(String.format(ADMIN_NOTIFICATION, message));
            Thread.sleep(50);
        } catch (Exception e) {
            System.out.println(ADMIN_NOTIFICATION_FAILED);
        }
    }
}
