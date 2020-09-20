package com.star_trello.darkside.telegram_bot.notifications;

import com.star_trello.darkside.model.Notification;
import com.star_trello.darkside.model.NotificationType;
import org.springframework.stereotype.Component;

@Component
public class DescriptionChangeNotificationTextConstructor extends ChangeNotificationTextConstructor {
    @Override
    protected String getChangedValue(Notification notification) {
        return notification.getTask().getDescription();
    }

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.TASK_DESCRIPTION_UPDATED;
    }
}
