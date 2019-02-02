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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StaticWebPageController.class)
public class StaticWebPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void indexTest() throws Exception{

        //Given
        Map<String,Object> theMap = new HashMap<>();
        theMap.put("plus","+");
        //When & Then
        mockMvc.perform(get("http://localhost:8080/")).andExpect(status().isOk());


        //String theIndex = webPageController.index(theMap);
        //assertEquals("+", theIndex);

       //mockMvc.perform((webPageController.index(theMap)).contentEquals("plus")).andExpect(status().isOk());



    }


}