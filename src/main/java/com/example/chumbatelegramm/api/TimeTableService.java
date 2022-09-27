package com.example.chumbatelegramm.api;

import com.example.chumbatelegramm.api.utils.JsonReader;

import com.example.chumbatelegramm.api.utils.UrlHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TimeTableService {


    private final JsonReader jsonReader;
    private final UrlHandler urlHandler;

    public TimeTableService(JsonReader jsonReader, UrlHandler urlHandler) throws IOException {
        this.jsonReader = jsonReader;
        this.urlHandler = urlHandler;
        requestTimeTable();
    }

    public String requestTimeTable()  {
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonReader.readJsonFromUrl(urlHandler.generateURL());
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray array = jsonObject.getJSONArray("timetableEvents");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i =0; i< array.length();i++){
            stringBuilder.append( array.getJSONObject(i).getString("date") + "\n"+
                    " "+ array.getJSONObject(i).getString("nameEt") + "\n"+
                    " "+ array.getJSONObject(i).getString("timeStart")+"-"+array.getJSONObject(i).getString("timeEnd")+"\n"+
                    "Room -"+ array.getJSONObject(i).getJSONArray("rooms").getJSONObject(0).getString("roomCode")+"\n"+"\n");




         }
        return stringBuilder.toString();
    }

}
