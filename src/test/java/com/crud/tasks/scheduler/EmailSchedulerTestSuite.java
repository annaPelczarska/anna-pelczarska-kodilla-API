package com.crud.tasks.scheduler;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmailSchedulerTestSuite {

    @InjectMocks
    private EmailScheduler emailScheduler;


    @Test
    public void displayMessageOnTasksSizeTest() {
        //Given
        long size = 0L;
        final String MAIL_CONTENT = "Currently in database you got: ";
        String messageOnTasksSize = (size == 1) ? MAIL_CONTENT + size + " task" : MAIL_CONTENT + size + " tasks";
        //When
       String theMessage = emailScheduler.displayMessageOnTasksSize();
        //Then
        assertEquals(messageOnTasksSize, theMessage);
    }

   /* @Test
    public void sendInformationEmailTest() {
        //Given
        EmailScheduler emailSchedulerX =mock(EmailScheduler.class);
        doNothing().when(emailSchedulerX).sendInformationEmail();
        //When
        doNothing();
        //Then

    }*/
}