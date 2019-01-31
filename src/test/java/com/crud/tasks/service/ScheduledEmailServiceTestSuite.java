package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class ScheduledEmailServiceTestSuite {

    @InjectMocks
    private ScheduledEmailService scheduledEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Mock
    MailCreatorService mailCreatorService;

    @Test
    public void shouldSendScheduledEmail() {
        //Given
        Mail theMail = new Mail("rec1","sub1", "mess1", "rec2");
        //When
        scheduledEmailService.send(theMail);
        //Then
        verify(javaMailSender, times(1)).send(any(MimeMessagePreparator.class));
    }

    @Test
    public void shouldCreateMimeMessage() {
        //Given
        Mail theMail = new Mail("rec1","sub1", "mess1", "rec2");
        String theMessage = "lovely";
        //When
        scheduledEmailService.mailCreatorService.buildDailyEmail(theMessage);
        //Then
        //verify(any(MimeMessagePreparator.class));
    }

}