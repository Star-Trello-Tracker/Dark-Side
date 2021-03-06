package com.star_trello.darkside.model;

import lombok.Getter;

@Getter
public enum NotificationType {
    CALLED_IN_COMMENT(1),
    TASK_PRIORITY_UPDATED(2),
    TASK_STATUS_UPDATED(3),
    TASK_DESCRIPTION_UPDATED(4),
    ASSIGNED_TO_TASK(5),
    TASK_TITLE_UPDATED(6),
    ADDED_TO_OBSERVERS(7),
    ADDED_COMMENT_IN_TASK(8);

    private int dbCode;

    NotificationType(int dbCode) {
        this.dbCode = dbCode;
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
