package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

/*    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {



        List<TrelloBoardDto>filteredTrelloBoards = trelloClient.getTrelloBoards().stream()
                .filter(trelloBoardDto -> (!trelloBoardDto.getName().isEmpty() && !trelloBoardDto.getId().isEmpty()))
                .filter(trelloBoardDto -> trelloBoardDto.getName().contains("Kodilla"))
                .collect(Collectors.toList());

        filteredTrelloBoards.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));

        if(filteredTrelloBoards.isEmpty()){
            System.out.println("There are no boards matching search criteria. Full list of the user's boards can be found below");
        trelloClient.getTrelloBoards().forEach(trelloBoardDto ->
                    System.out.println(trelloBoardDto.getId() + " - " + trelloBoardDto.getName()));
                }

        return filteredTrelloBoards;
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCardDto createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }
}
