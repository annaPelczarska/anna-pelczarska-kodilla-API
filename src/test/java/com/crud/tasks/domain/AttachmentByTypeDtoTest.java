package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class AttachmentByTypeDtoTest {

    @Test
    public void getTrelloTest() {
        TrelloTrelloDto theTrelloTrelloDto = new TrelloTrelloDto(1,2);
        AttachmentByTypeDto theAttachmentByTypeDto = new AttachmentByTypeDto(theTrelloTrelloDto);
        assertEquals(theTrelloTrelloDto, theAttachmentByTypeDto.getTrello());
    }
}