package com.crud.tasks.controller;

import com.crud.tasks.service.DbService;
import com.crud.tasks.trello.client.mapper.TaskMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class StaticWebPageControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StaticWebPageController webPageController;
    @MockBean
    private DbService dbService;
    @MockBean
    private TaskMapper taskMapper;

    @Test
    public void indexTest(){

        //Given
        Map<String,Object> theMap = new HashMap<>();
        theMap.put("plus","+");
        theMap.put("minus","-");
       /* //When
        String theIndex = webPageController.index(theMap);
        //Then
        assertEquals("?", theIndex);*/

       //mockMvc.perform((webPageController.index(theMap)).contentEquals("plus")).andExpect(status().isOk());



    }


}