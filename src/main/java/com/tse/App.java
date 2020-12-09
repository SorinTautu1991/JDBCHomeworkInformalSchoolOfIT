package com.tse;


import com.tse.entities.Accomodation;
import com.tse.entities.AccomodationFairRelation;
import com.tse.entities.RoomFair;
import com.tse.management.DbManagement;

public class App {
    public static void main( String[] args ) {

        Accomodation ac1 = new Accomodation("hotel", "double", 2, "double-bed room with sea view");
        RoomFair rf1 = new RoomFair(250, "summer");
        Accomodation ac2 = new Accomodation("hotel", "single", 1, "one-bed");
        RoomFair rf2 = new RoomFair(120, "winter");

        DbManagement.getInstance().addAccomodation(ac1);
        DbManagement.getInstance().addRoomFair(rf1);
        DbManagement.getInstance().addAccomodation(ac2);
        DbManagement.getInstance().addRoomFair(rf2);
        AccomodationFairRelation af = new AccomodationFairRelation(ac1.getId(), rf1.getId());
        AccomodationFairRelation af2 = new AccomodationFairRelation(ac2.getId(), rf2.getId());
        DbManagement.getInstance().addAccomodationFairRelation(af);
        DbManagement.getInstance().addAccomodationFairRelation(af2);
        DbManagement.getInstance().printPricesForRooms();




    }
}
