package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {

    private List<Room> roomList = new ArrayList<>();

    public void AddRoom(double length, double width, double height) {

        Room room = new Room(width, length, height);

        roomList.add(room);

    }

    public String toString() {

        if (!roomList.isEmpty()) {

            String areaOfRooms = "";

            for (Room room : roomList) {
                 areaOfRooms += "Room with area: " + room.getArea() + "\n";
            }

            return areaOfRooms;

        } else {
            return "No rooms found, please try to add a room first";
        }
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}
