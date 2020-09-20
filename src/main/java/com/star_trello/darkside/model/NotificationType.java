package com.star_trello.darkside.model;

import lombok.Getter;

@Getter
public enum NotificationType {
    CALLED_IN_COMMENT(1, " упомянул Вас в комментарии к задаче "),
    TASK_PRIORITY_UPDATED(2, " изменил приоритет задачи "),
    TASK_STATUS_UPDATED(3, " изменил статус задачи "),
    TASK_DESCRIPTION_UPDATED(4, " изменил описание задачи "),
    ASSIGNED_TO_TASK(5, " назначил Вас исполнителем на задачу "),
    TASK_TITLE_UPDATED(6, " изменил название задачи "),
    ADDED_TO_OBSERVERS(7, " добавил Вас в наблюдатели к задаче "),
    ADDED_COMMENT_IN_TASK(8, " оставил новый комментарий к задаче ");

    private int dbCode;
    @Getter
    private String NotificationTemplateText;

    NotificationType(int dbCode, String notificationTemplateText) {
        this.dbCode = dbCode;
        this.NotificationTemplateText = notificationTemplateText;
    }

    public static NotificationType getById(int id) {
        for (NotificationType type : values()) {
            if (type.dbCode == id) {
                return type;
            }
        }

        return NotificationType.CALLED_IN_COMMENT;
    }
}
