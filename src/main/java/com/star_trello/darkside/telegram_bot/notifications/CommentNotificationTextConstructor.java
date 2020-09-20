package com.star_trello.darkside.telegram_bot.notifications;

import com.star_trello.darkside.model.Notification;
import com.star_trello.darkside.model.NotificationType;

public abstract class CommentNotificationTextConstructor extends NotificationTextConstructorImpl {
    @Override
    public String getNotificationText(Notification notification, String commentText) {
        return super.getNotificationText(notification, commentText) +
                 "\nТекст комментария: " + commentText;
    }
    @Override
    public abstract NotificationType getNotificationType();
}
