package com.star_trello.darkside.telegram_bot.notifications;

import com.star_trello.darkside.model.NotificationType;
import org.springframework.stereotype.Component;

@Component
public class AddedToObserversNotificationTextConstructor extends NotificationTextConstructorImpl {
    @Override
    public NotificationType getNotificationType() {
        return NotificationType.ADDED_TO_OBSERVERS;
    }
}
