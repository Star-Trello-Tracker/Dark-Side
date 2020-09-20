package com.star_trello.darkside.telegram_bot.notifications;

import com.star_trello.darkside.model.NotificationType;
import org.springframework.stereotype.Component;

@Component
public class NewCommentInTaskNotificationTextConstructor extends CommentNotificationTextConstructor {
    @Override
    public NotificationType getNotificationType() {
        return NotificationType.ADDED_COMMENT_IN_TASK;
    }
}
