package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTestSuite {

    @Mock
    private TrelloValidator trelloValidator;

    @Test
    public void validateCardTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("task1", "description1", "position1", "list1");
        //When
        trelloValidator.validateCard(trelloCard);
        //Then
        verify(trelloValidator, times(1)).validateCard(trelloCard);
    }

    @Test
    public void validateTrelloBoardsTest() {
        //Given
        TrelloBoard trelloBoard1 = new TrelloBoard("1", "board1", new ArrayList<>());
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "board2", new ArrayList<>());
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard1);
        trelloBoards.add(trelloBoard2);
        TrelloValidator trelloValidator = new TrelloValidator();
        //When
        List<TrelloBoard> validatedTrelloBoards = trelloValidator.validateTrelloBoards(trelloBoards);
        //Then
        assertEquals(2, validatedTrelloBoards.size());
    }

}