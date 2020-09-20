package com.star_trello.darkside.telegram_bot.notifications;

import com.star_trello.darkside.model.Notification;
import com.star_trello.darkside.model.NotificationType;
import com.star_trello.darkside.telegram_bot.utils.TextUtils;

public abstract class NotificationTextConstructorImpl implements NotificationTextConstructor{
    @Override
    public String getNotificationText(Notification notification, String commentText) {
        return "Пользователь " + TextUtils.fullUsername(notification.getInitiator()) +
                getNotificationType().getNotificationTemplateText() +
                TextUtils.fullTaskTitle(notification.getTask());
    }
    @Override
    public abstract NotificationType getNotificationType();
}
