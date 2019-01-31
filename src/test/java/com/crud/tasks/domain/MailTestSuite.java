package com.crud.tasks.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class MailTestSuite {

    @InjectMocks
    private Mail mail;


    @Test
    public void getMailToTest() {
        Mail theMail = new Mail("rec1", "sub1", "mess1", "rec2");
        String rec1Mail = theMail.getMailTo();
        assertEquals("rec1", rec1Mail);
    }

    @Test
    public void getSubjectTest() {
        Mail theMail = new Mail("rec1", "sub1", "mess1", "rec2");
        String subject1 = theMail.getSubject();
        assertEquals("sub1", subject1);
    }

    @Test
    public void getMessageTest() {
        Mail theMail = new Mail("rec1", "sub1", "mess1", "rec2");
        String message1 = theMail.getMessage();
        assertEquals("mess1", message1);
    }

    @Test
    public void getToCcTest() {
        Mail theMail = new Mail("rec1", "sub1", "mess1", "rec2");
        String inCc = theMail.getToCc();
        assertEquals("rec2", inCc);
    }
}