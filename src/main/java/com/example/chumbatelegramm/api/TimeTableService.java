package com.example.chumbatelegramm.api;

import com.example.chumbatelegramm.api.utils.JsonReader;

import com.example.chumbatelegramm.api.utils.UrlHandler;
import com.example.chumbatelegramm.entity.LessonEntity;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class TimeTableService {


    private final JsonReader jsonReader;
    private final UrlHandler urlHandler;

    public TimeTableService(JsonReader jsonReader, UrlHandler urlHandler) throws IOException {
        this.jsonReader = jsonReader;
        this.urlHandler = urlHandler;
    }

    public String requestTimeTable(Integer groupId) {
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonReader.readJsonFromUrl(urlHandler.generateURL(groupId));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray array = jsonObject.getJSONArray("timetableEvents");
        StringBuilder stringBuilder = new StringBuilder();
        List<LessonEntity> lessonEntities = new ArrayList<>();
        for (int i =0; i< array.length();i++){

            LessonEntity lessonEntity =
                    null;
            try {
                lessonEntity = new LessonEntity(array.getJSONObject(i).getString("date"),
                        array.getJSONObject(i).getString("nameEt"),
                        array.getJSONObject(i).getString("timeStart"),
                         array.getJSONObject(i).getString("timeEnd"),
                        array.getJSONObject(i).getJSONArray("rooms").getJSONObject(0).getString("roomCode"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            lessonEntities.add(lessonEntity);

         }
        Collections.sort(lessonEntities);

        return lessonEntities.toString();
    }

}
