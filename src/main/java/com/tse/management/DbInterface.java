package com.tse.management;

import com.tse.entities.Accomodation;
import com.tse.entities.AccomodationFairRelation;
import com.tse.entities.RoomFair;

public interface DbInterface {
    boolean addAccomodation(Accomodation accomodation);
    boolean addRoomFair(RoomFair roomFair);
    boolean addAccomodationFairRelation(AccomodationFairRelation accomodationFairRelation);
    void printPricesForRooms();
}
