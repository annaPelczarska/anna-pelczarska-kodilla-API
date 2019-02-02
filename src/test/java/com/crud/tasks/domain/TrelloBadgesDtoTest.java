package com.crud.tasks.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class TrelloBadgesDtoTest {

    @InjectMocks
    private TrelloBadgesDto trelloBadgesDto;

    @MockBean
    private AttachmentByTypeDto attachmentByTypeDto;

    @MockBean
    private TrelloTrelloDto trelloTrelloDto;

    @Test
    public void getVotesTest() {
        TrelloTrelloDto theTrelloTrelloDto = new TrelloTrelloDto(1,2);
        AttachmentByTypeDto theAttachmentByTypeDto = new AttachmentByTypeDto(theTrelloTrelloDto);
        TrelloBadgesDto theBadgesDto = new TrelloBadgesDto(3,theAttachmentByTypeDto);
        assertEquals(3, theBadgesDto.getVotes());
    }

    @Test
    public void getAttachmentTest() {
        TrelloTrelloDto theTrelloTrelloDto = new TrelloTrelloDto(1,2);
        AttachmentByTypeDto theAttachmentByTypeDto = new AttachmentByTypeDto(theTrelloTrelloDto);
        TrelloBadgesDto theBadgesDto = new TrelloBadgesDto(3,theAttachmentByTypeDto);
        assertEquals(theAttachmentByTypeDto, theBadgesDto.getAttachment());

    }
}