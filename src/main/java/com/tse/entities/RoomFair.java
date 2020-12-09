package com.tse.entities;

import java.util.UUID;

public class RoomFair {
    private UUID id;
    private double value;
    private String season;


    public RoomFair(double value, String season) {
        this.id = UUID.randomUUID();
        this.value = value;
        this.season = season;
    }


    public UUID getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public String getSeason() {
        return season;
    }
}
