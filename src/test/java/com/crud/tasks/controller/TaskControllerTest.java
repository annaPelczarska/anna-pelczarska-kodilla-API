package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.service.DbService;
import com.crud.tasks.trello.client.mapper.TaskMapper;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;


@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DbService dbService;
    @MockBean
    private TaskMapper taskMapper;


    @Test
    public void shouldFetchTaskList() throws Exception{
        //Given
        List<TaskDto>taskDtos=new ArrayList<>();
        taskDtos.add(new TaskDto(1L,"task1","task1 description"));
        List<Task>tasks=new ArrayList<>();
        tasks.add(new Task(1L,"task1","task1 description"));
        when(taskMapper.mapToTaskDtoList(tasks)).thenReturn(taskDtos);
        when(dbService.getAllTasks()).thenReturn(tasks);
        //When & Then
        mockMvc.perform(get("/v1/task/getTasks").contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("task1")))
                .andExpect(jsonPath("$[0].content", is("task1 description")));
    }

    @Test
    public void shouldFetchTaskById() throws Exception {
        //Given
        Task task = new Task(1L,"task1","task1 description");
        TaskDto taskDto = new TaskDto(1L,"task1","task1 description");
        when(taskMapper.mapToTaskDto(any(Task.class))).thenReturn(taskDto);
        when(dbService.getTask(anyLong())).thenReturn(Optional.of(task));
        //When & Then
        mockMvc.perform(get("/v1/task/getTask?TaskId=1").contentType(MediaType.APPLICATION_JSON)
                .param("taskId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("task1")))
                .andExpect(jsonPath("$.content", is("task1 description")));
    }

    @Test
    public void shouldDeleteTaskbyId() throws Exception {
        //Given
        Task task = new Task(1L,"task1","task1 description");
        //When & Then
        mockMvc.perform(delete("/v1/task/deleteTask?taskId=1").contentType(MediaType.APPLICATION_JSON)
                .param("taskId", "1"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateTask() throws Exception {
        //Given
        Task task = new Task(1L,"task1","task1 description");
        TaskDto taskDto = new TaskDto(1L,"task1","task1 description");

        when(taskMapper.mapToTaskDto(any(Task.class))).thenReturn(taskDto);
        when(taskMapper.mapToTask(any(TaskDto.class))).thenReturn(task);
        when(dbService.saveTask(any(Task.class))).thenReturn(task);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);
        //When & Then
        mockMvc.perform(put("/v1/task/updateTask")
                .contentType(APPLICATION_JSON)
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("task1")))
                .andExpect(jsonPath("$.content", is("task1 description")));
    }

    @Test
    public void shouldCreateTask() throws Exception {
        //Given
        Task task = new Task(1L,"task1","task1 description");
        TaskDto taskDto = new TaskDto(1L,"task1","task1 description");

        when(taskMapper.mapToTaskDto(any(Task.class))).thenReturn(taskDto);
        when(taskMapper.mapToTask(any(TaskDto.class))).thenReturn(task);
        when(dbService.saveTask(any(Task.class))).thenReturn(task);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);
        //When & Then
        mockMvc.perform(post("/v1/task/createTask")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("task1")))
                .andExpect(status().isOk());
    }
}