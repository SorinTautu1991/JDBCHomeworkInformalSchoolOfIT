package com.tse;

import static org.junit.Assert.assertTrue;

import com.tse.entities.Accomodation;
import com.tse.entities.AccomodationFairRelation;
import com.tse.entities.RoomFair;
import com.tse.management.DbManagement;
import org.junit.Test;


public class AppTest {

    @Test
    public void insertIntoTables(){
        Accomodation ac1 = new Accomodation("hotel", "double", 2, "double-bed room with sea view");
        RoomFair rf1 = new RoomFair(250, "summer");
        Accomodation ac2 = new Accomodation("hotel", "single", 1, "one-bed");
        RoomFair rf2 = new RoomFair(120, "winter");
        assertTrue(DbManagement.getInstance().addAccomodation(ac1));
        assertTrue(DbManagement.getInstance().addRoomFair(rf1));
        assertTrue(DbManagement.getInstance().addAccomodation(ac2));
        assertTrue(DbManagement.getInstance().addRoomFair(rf2));
        AccomodationFairRelation af = new AccomodationFairRelation(ac1.getId(), rf1.getId());
        AccomodationFairRelation af2 = new AccomodationFairRelation(ac2.getId(), rf2.getId());
        assertTrue(DbManagement.getInstance().addAccomodationFairRelation(af));
        assertTrue(DbManagement.getInstance().addAccomodationFairRelation(af2));
    }

    @Test
    public void printPricesAndRooms(){
        DbManagement.getInstance().printPricesForRooms();
    }


}
