package com.example.chumbatelegramm.api.utils;

import org.springframework.stereotype.Component;
import java.time.LocalDate;


@Component
public class UrlHandler {


    public String generateURL(){
        return "https://tahvel.edu.ee/hois_back/schoolBoard/8/timetableByGroup?from="
                + LocalDate.now()+"T00:00:00Z&studentGroups=6453&thru=" + LocalDate.now().plusDays(5)+"T00:00:00Z";
    }
}
