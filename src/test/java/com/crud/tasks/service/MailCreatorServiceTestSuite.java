package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MailCreatorServiceTestSuite {

    @InjectMocks
    private MailCreatorService mailCreatorService;

    @InjectMocks
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @MockBean
    AdminConfig adminConfig;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    public void buildTrelloCardEmailTest() {
/*        //Given
        String theMessage = "lovely1";
        //Context context = new Context();
        //context.setVariable("message", theMessage);
        //templateEngine.process("tempName",context);
        //When
       mailCreatorService.buildTrelloCardEmail(theMessage);
       // assertNotEquals(theMail, theMessage);*/
    }

    @Test
    public void buildDailyEmailTest() {
        /*String theMessage = "lovely1";
        mailCreatorService.buildDailyEmail(theMessage);*/
    }
}