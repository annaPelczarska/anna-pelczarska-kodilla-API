package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTestSuite {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private AdminConfig adminConfig;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    SimpleEmailService simpleEmailService;

    @Test
    public void shouldFetchTrelloBoards() {
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "board1", new ArrayList<>());
        List<TrelloBoardDto> trelloList = new ArrayList<>();
        trelloList.add(trelloBoardDto);
        when(trelloService.fetchTrelloBoards()).thenReturn(trelloList);
        //When
        List<TrelloBoardDto> fetchList = trelloService.fetchTrelloBoards();
        //Then
        assertEquals(1, fetchList.size());
    }

    @Test
    public void shouldCreateTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("task1", "description1", "pos1", "listId1");
        CreatedTrelloCardDto createdTrelloCard = new CreatedTrelloCardDto("1", "task1", "http://");
        when(trelloService.createTrelloCard(trelloCardDto)).thenReturn(createdTrelloCard);
        //When
        CreatedTrelloCardDto newCard = trelloService.createTrelloCard(trelloCardDto);
        //Then
        assertEquals("1", newCard.getId());
        assertEquals("task1", newCard.getName());
        assertEquals("http://", newCard.getShortUrl());
    }

}