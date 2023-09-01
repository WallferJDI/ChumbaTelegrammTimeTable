package com.example.chumbatelegramm.controller;

import com.example.chumbatelegramm.service.CommandService;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Controller
public class QueryController {

    private final CommandService commandService;

    public QueryController(CommandService commandService) {
        this.commandService = commandService;
    }

    public Message queryRequest(Update update){

        Message requestMessage = update.getMessage();
        Message responseMessage = null;

        if(requestMessage.hasText()) {
            if(requestMessage.isCommand()){
            responseMessage = commandService.commandProceed(requestMessage.getText());
            }
        }

        return responseMessage;
    }



}
