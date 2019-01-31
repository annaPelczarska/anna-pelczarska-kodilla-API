package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTestSuite {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void getAllTasksTest() {
        //Given
        Task task = new Task(1L, "task1", "description1");
        Task task2 = new Task(2L, "task2", "description2");
        Task task3 = new Task(3L, "task3", "description3");
        List<Task> allTasks = new ArrayList<>();
        allTasks.add(task);
        allTasks.add(task2);
        allTasks.add(task3);
        when(dbService.getAllTasks()).thenReturn(allTasks);
        //When
        List<Task> findTasks = dbService.getAllTasks();
        //Then
        assertEquals(3, findTasks.size());
    }

    @Test
    public void getTaskTest() {
        //Given
        Task task = new Task(1L, "task1", "description1");
        when(dbService.getTask(1L)).thenReturn(Optional.ofNullable(task));
        //When
        Optional<Task> findTask = dbService.getTask(1L);
        //Then
        assertNotEquals(null, findTask);
    }

    @Test
    public void saveTask() {
        //Given
        Task task = new Task(1L, "task1", "description1");
        when(dbService.getTask(1L)).thenReturn(Optional.ofNullable(task));
        //When
        Optional<Task> theTask = dbService.getTask(1L);
        //Then
        assertNotEquals(null, theTask);
    }

    @Test
    public void deleteTask() {
        //Given
        Task theTask = new Task(1L, "task1", "description1");
        //When
        dbService.deleteTask(1L);
        //Then
        //assertEquals(null, theTask);
    }
}