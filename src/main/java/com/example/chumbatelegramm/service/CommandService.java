package com.example.chumbatelegramm.service;

import com.example.chumbatelegramm.api.TimeTableService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;


@Service
public class CommandService {


    private final TimeTableService timeTableService;

    public CommandService(TimeTableService timeTableService) {
        this.timeTableService = timeTableService;
    }

    public Message commandProceed(String text)  {
        Message message = new Message();
        if(text.equals("/timetable")){

            message.setText(timeTableService.requestTimeTable());
        }else {
            message.setText("What?");
        }

        return  message;
    }
}
// try{
//         execute(new SendMessage(chat_id,"test "));
//         }catch (TelegramApiException e){
//         System.out.println(e.getMessage());
//         }