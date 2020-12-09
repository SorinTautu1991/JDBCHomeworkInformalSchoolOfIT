package com.tse.entities;

import java.util.UUID;

public class Accomodation {
    private UUID id;
    private String type;
    private String bedType;
    private int maxGuests;
    private String description;

    public Accomodation(String type, String bedType, int maxGuests, String description) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.bedType = bedType;
        this.maxGuests = maxGuests;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getBedType() {
        return bedType;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public String getDescription() {
        return description;
    }
}
