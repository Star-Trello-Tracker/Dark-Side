package com.star_trello.darkside.telegram_bot.notifications;

import com.star_trello.darkside.model.Notification;
import com.star_trello.darkside.model.NotificationType;
import org.springframework.stereotype.Component;

@Component
public class TitleChangeNotificationTextConstructor extends NotificationTextConstructorImpl {
    @Override
    public NotificationType getNotificationType() {
        return NotificationType.TASK_TITLE_UPDATED;
    }
}
