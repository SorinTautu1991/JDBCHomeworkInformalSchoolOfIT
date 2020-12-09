package com.tse.entities;

import java.util.UUID;

public class AccomodationFairRelation {
    private UUID id;
    private UUID accomodationId;
    private UUID roomFairId;


    public AccomodationFairRelation(UUID accomodationId, UUID roomFairId) {
        this.id = UUID.randomUUID();
        this.accomodationId = accomodationId;
        this.roomFairId = roomFairId;
    }

    public UUID getId() {
        return id;
    }

    public UUID getAccomodationId() {
        return accomodationId;
    }

    public UUID getRoomFairId() {
        return roomFairId;
    }
}
