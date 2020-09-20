package com.star_trello.darkside.telegram_bot.notifications;

import com.star_trello.darkside.model.NotificationType;
import org.springframework.stereotype.Component;

@Component
public class AssignedNotificationTextConstructor extends NotificationTextConstructorImpl {
    @Override
    public NotificationType getNotificationType() {
        return NotificationType.ASSIGNED_TO_TASK;
    }
}
