package com.crud.tasks.trello.client.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoardTest() {
        //Given
        List<TrelloListDto> listDtos = new ArrayList<>();
        listDtos.add(new TrelloListDto("new list id", "new list name",false));
        List<TrelloBoardDto> boardDtos = new ArrayList<>();
        boardDtos.add(new TrelloBoardDto("new board id","new board name", listDtos));
        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(boardDtos);
        //Then
        assertEquals(1, trelloBoards.size());
        assertEquals("new board id", trelloBoards.get(0).getId());
        assertEquals("new board name", trelloBoards.get(0).getName());
        assertEquals(1, trelloBoards.get(0).getLists().size());
    }

    @Test
    public void mapToBoardsDtoTest() {
        //Given
        List<TrelloList> lists = new ArrayList<>();
        lists.add(new TrelloList("new list id", "new list name",false));
        List<TrelloBoard> boards = new ArrayList<>();
        boards.add(new TrelloBoard("new board id","new board name", lists));
        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(boards);
        //Then
        assertEquals(1, trelloBoardDtos.size());
        assertEquals("new board id", trelloBoardDtos.get(0).getId());
        assertEquals("new board name", trelloBoardDtos.get(0).getName());
        assertEquals(1, trelloBoardDtos.get(0).getLists().size());
    }

    @Test
    public void mapToListTest() {
        //Given
        List<TrelloListDto> listDtos = new ArrayList<>();
        listDtos.add(new TrelloListDto("new list id", "new list name",false));
        //When
        List<TrelloList> trelloLists =trelloMapper.mapToList(listDtos);
        //Then
        assertEquals(1,trelloLists.size());
        assertEquals("new list id",trelloLists.get(0).getId());
        assertEquals("new list name",trelloLists.get(0).getName());
        assertEquals(false,trelloLists.get(0).isClosed());
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        List<TrelloList> lists = new ArrayList<>();
        lists.add(new TrelloList("new list id", "new list name",false));
        //When
        List<TrelloListDto> listDtos =trelloMapper.mapToListDto(lists);
        //Then
        assertEquals(1,listDtos.size());
        assertEquals("new list id",listDtos.get(0).getId());
        assertEquals("new list name",listDtos.get(0).getName());
        assertEquals(false,listDtos.get(0).isClosed());
    }

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("card name","card description","card position","list id");
        //When
        TrelloCardDto cardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("card name",cardDto.getName());
        assertEquals("card description",cardDto.getDescription());
        assertEquals("card position",cardDto.getPos());
        assertEquals("list id",cardDto.getListId());
    }

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("card name","card description","card position","list id");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(cardDto);
        //Then
        assertEquals("card position",trelloCard.getPos());
        assertEquals("card name", trelloCard.getName());
        assertEquals("card description", trelloCard.getDescription());
        assertEquals("list id", trelloCard.getListId());

    }
}
