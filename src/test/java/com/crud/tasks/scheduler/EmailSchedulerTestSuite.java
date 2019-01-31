package com.crud.tasks.scheduler;


import com.crud.tasks.domain.Mail;
import com.crud.tasks.service.ScheduledEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class EmailSchedulerTestSuite {

    @InjectMocks
    private EmailScheduler emailScheduler;

    @InjectMocks
    private ScheduledEmailService scheduledEmailService;

    @Mock
    private JavaMailSender javaMailSender;


    @Test
    public void displayMessageOnTasksSizeTest() {
        //Given
        long size = 0L;
        final String MAIL_CONTENT = "Currently you have: ";
        String messageOnTasksSize = (size == 1) ? MAIL_CONTENT + size + " task" : MAIL_CONTENT + size + " tasks";
        //When
        String theMessage = emailScheduler.displayMessageOnTasksSize();
        //Then
        assertEquals(messageOnTasksSize, theMessage);
    }

    @Test
    public void sendInformationEmailTest(){
        //Given
        Mail theMail = new Mail("rec1","sub1", "mess1", "rec2");
        //When
        scheduledEmailService.send(theMail);
        //Then
        verify(javaMailSender, times(1)).send(any(MimeMessagePreparator.class));
    }


}
