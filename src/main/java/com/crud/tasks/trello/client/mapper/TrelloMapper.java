package com.crud.tasks.trello.client.mapper;


import com.crud.tasks.domain.*;
import org.springframework.stereotype.Component;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Component
public class TrelloMapper {

    public List <TrelloBoard> mapToBoards(final List<TrelloBoardDto> trelloBoardDtoList) {
        return trelloBoardDtoList.stream()
                .map(trelloBoard->
                        new TrelloBoard(trelloBoard.getId(), trelloBoard.getName(), mapToList(trelloBoard.getLists()))
        ).collect(toList());
    }
    public List<TrelloBoardDto> mapToBoardsDto(final List<TrelloBoard> list) {
        return list.stream()
                .map(trelloBoard -> new TrelloBoardDto(trelloBoard.getId(), trelloBoard. getName(),
                        mapToListDto(trelloBoard.getLists())))
                .collect(toList());
    }

    public List<TrelloList> mapToList(final List<TrelloListDto> trelloListDto) {
        return trelloListDto.stream()
                .map(trelloList -> new TrelloList(trelloList.getId(), trelloList.getName(), trelloList.isClosed()))
                .collect(toList());
    }

    public List<TrelloListDto> mapToListDto(final List<TrelloList> list) {
        return list.stream()
                .map(trelloList -> new TrelloListDto(trelloList.getId(), trelloList.getName(), trelloList.isClosed()))
                .collect(toList());
    }
    public TrelloCardDto mapToCardDto(final TrelloCard trelloCard) {
        return new TrelloCardDto(trelloCard.getName(), trelloCard.getDescription(), trelloCard.getPos(), trelloCard.getListId());
    }

    public TrelloCard mapToCard(final TrelloCardDto trelloCardDto) {
        return new TrelloCard(trelloCardDto.getName(), trelloCardDto.getDescription(), trelloCardDto.getPos(), trelloCardDto.getListId());
    }
}
