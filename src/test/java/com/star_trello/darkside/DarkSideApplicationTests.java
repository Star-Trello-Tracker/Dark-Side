package com.star_trello.darkside;

import com.star_trello.darkside.controller.*;
import com.star_trello.darkside.dto.CommentCreationDto;
import com.star_trello.darkside.dto.QueueCreationDto;
import com.star_trello.darkside.dto.TaskCreationDto;
import com.star_trello.darkside.dto.UserCredentialsDto;
import com.star_trello.darkside.model.*;
import com.star_trello.darkside.repo.QueueRepo;
import com.star_trello.darkside.repo.UserRepo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static com.star_trello.darkside.constants.UserTestConstants.*;
import static com.star_trello.darkside.constants.UtilsConstants.*;

@SpringBootTest
class DarkSideApplicationTests {


    @Autowired
    UserController userController;

    @Autowired
    AuthController authController;

    @Autowired
    TaskController taskController;

    @Autowired
    QueueController queueController;

    @Autowired
    CommentController commentController;

    @Autowired
    UserRepo userRepo;

    @Autowired
    QueueRepo queueRepo;

    @Test
    void contextLoads() {
        boolean x = true;
        Assert.assertTrue(x);
    }

    @Test
    void fullCycleUserAuthCreateQueueTaskComment() {
        authController.register(User.builder()
                .email(MAIL)
                .username(USERNAME)
                .password(PASSWORD)
                .build());

        ResponseEntity<?> login = authController.login(UserCredentialsDto.builder()
                .email(MAIL)
                .password(PASSWORD)
                .build());

        UserSession userSessionBody = (UserSession) login.getBody();
        String token = userSessionBody.getToken();

        Queue queue = (Queue) queueController.createQueue(
                new QueueCreationDto(QUEUE_TITLE, QUEUE_DESCRIPTION), token)
                .getBody();

        Task task = (Task) taskController.createTask(
                new TaskCreationDto(TASK_TITLE, TASK_DESCRIPTION, 5, queue.getTitle()), token)
                .getBody();

        // update queue
        queue = queueRepo.getByTitle(queue.getTitle());
        Assert.assertEquals(task.getKey(), queue.getTaskList().get(0).getKey());

        Comment comment = (Comment) commentController.createComment(
                new CommentCreationDto(task.getKey(), COMMENT_TEXT, new ArrayList<>()), token)
                .getBody();

        queue = queueRepo.getByTitle(queue.getTitle());
        Assert.assertEquals(COMMENT_TEXT, queue.getTaskList().get(0).getComments().get(0).getText());

        commentController.editComment(comment.getId(), EDIT_COMMENT, token);
        queue = queueRepo.getByTitle(queue.getTitle());
        Assert.assertEquals(EDIT_COMMENT, queue.getTaskList().get(0).getComments().get(0).getText());

    }

}
