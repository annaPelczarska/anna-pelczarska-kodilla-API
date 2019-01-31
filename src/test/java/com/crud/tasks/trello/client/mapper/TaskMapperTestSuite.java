package com.crud.tasks.trello.client.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTestSuite {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void mapToTaskTest() {
        TaskDto taskDto = new TaskDto(1L, "task1", "description1");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(1L, (long)task.getId());
        assertEquals("task1", task.getTitle());
        assertEquals("description1", task.getContent());
    }

    @Test
    public void mapToTaskDtoTest() {
        //Given
        Task task = new Task(1L, "task1", "description1");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(1L, (long)taskDto.getId());
        assertEquals("task1", taskDto.getTitle());
        assertEquals("description1", taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoListTest() {
        //Given
        Task task = new Task(1L, "task1", "description1");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        //When
        List<TaskDto> tasksDto = taskMapper.mapToTaskDtoList(tasks);
        //Then
        assertEquals(1, tasksDto.size());
    }

}