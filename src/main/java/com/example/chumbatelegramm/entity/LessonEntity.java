package com.example.chumbatelegramm.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LessonEntity implements Comparable<LessonEntity>{

    private String date;
    private String nameEt;
    private String timeStart;
    private String timeEnd;
    private String roomCode;

    public LessonEntity(String dateStr, String nameEt, String timeStart, String timeEnd, String roomCode) throws ParseException {
        date = dateStr.split("T")[0];
        this.nameEt = nameEt;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.roomCode = roomCode;
    }

    @Override
    public String toString() {
        return "\n"
                + nameEt + '\n'
                + timeStart +" - "+timeEnd + '\n'
                + roomCode + '\n' +
                '\n';
    }

    public String getNameEt() {
        return nameEt;
    }


    public String getTimeStart() {
        return timeStart;
    }



    public String getTimeEnd() {
        return timeEnd;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int compareTo(LessonEntity o) {
        Date date1 = null;
        Date date2 = null;
        try {
             date1 = new SimpleDateFormat("yyyy-dd-MM").parse(getDate());
             date2 = new SimpleDateFormat("yyyy-dd-MM").parse(o.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return date1.compareTo(date2);
    }
}
