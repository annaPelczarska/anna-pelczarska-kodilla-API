package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrelloTrelloDtoTest {

    @Test
    public void getBoardTest() {
        TrelloTrelloDto theTrelloTrelloDto = new TrelloTrelloDto(1,2);
        assertEquals(1, theTrelloTrelloDto.getBoard());
    }

    @Test
    public void getCardTest() {
        TrelloTrelloDto theTrelloTrelloDto = new TrelloTrelloDto(1,2);
        assertEquals(2, theTrelloTrelloDto.getCard());
    }
}