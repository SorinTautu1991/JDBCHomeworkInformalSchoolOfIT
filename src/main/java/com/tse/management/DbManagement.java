package com.tse.management;

import com.tse.entities.Accomodation;
import com.tse.entities.AccomodationFairRelation;
import com.tse.entities.RoomFair;

import java.sql.*;

public class DbManagement implements DbInterface {
    private Connection connection;
    private static DbManagement instance;



    private DbManagement() {
        try{
            Class.forName("org.postgresql.Driver");
            DbCredentials credentials = new DbCredentials();
            connection = DriverManager.getConnection(credentials.getConnectionString());
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }


    public static DbManagement getInstance() {
        if (instance == null) {
            instance = new DbManagement();
        }
        return instance;
    }


    @Override
    public boolean addAccomodation(Accomodation accomodation) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT into accomodation VALUES (?, ?, ?, ?, ?)");
            ps.setObject(1, accomodation.getId());
            ps.setString(2, accomodation.getType());
            ps.setString(3, accomodation.getBedType());
            ps.setInt(4, accomodation.getMaxGuests());
            ps.setString(5, accomodation.getDescription());
            ps.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addRoomFair(RoomFair roomFair) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO room_fair VALUES (?, ?, ?)");
            ps.setObject(1, roomFair.getId());
            ps.setDouble(2, roomFair.getValue());
            ps.setString(3, roomFair.getSeason());
            ps.executeUpdate();
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addAccomodationFairRelation(AccomodationFairRelation accomodationFairRelation) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO accomodation_fair_relation VALUES (?, ?, ?)");
            ps.setObject(1, accomodationFairRelation.getId());
            ps.setObject(2, accomodationFairRelation.getAccomodationId());
            ps.setObject(3, accomodationFairRelation.getRoomFairId());
            ps.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public void printPricesForRooms() {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT accomodation.type as room, room_fair.value as price\n" +
                    "FROM accomodation_fair_relation\n" +
                    "INNER JOIN accomodation ON \n" +
                    "accomodation_fair_relation.id_accomodation = accomodation.id\n" +
                    "INNER JOIN room_fair\n" +
                    "ON accomodation_fair_relation.id_room_fair = room_fair.id");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("The type of room is: " + rs.getString("room"));
                System.out.println("The price of room is: " + rs.getDouble("price"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
