package com.crud.tasks.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@TestPropertySource(properties = {"admin.mail"})
public class AdminConfigTestSuite {

    @InjectMocks
    private AdminConfig adminConfig;

  /*  @Test
    public void getAdminMailTest() {
        //Given
        //When
        String mail = adminConfig.getAdminMail();
        //Then
        assertEquals("ankaindigitland@gmail.com", mail );

    }*/

    @Test
    public void getAdminNameTest() {
    }

    @Test
    public void getCompanyNameTest() {
    }

    @Test
    public void getCompanyGoalTest() {
    }

    @Test
    public void getCompanyEmailTest() {
    }
}