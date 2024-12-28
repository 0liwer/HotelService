package hotel.service;

import hotel.structure.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomController {
    private List<Room> rooms = new ArrayList<>();

    // Dodanie pokoju
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Pobranie wszystkich pokoi
    public List<Room> getAllRooms() {
        return rooms;
    }

    // Pobranie dostępnych pokoi
    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    // Aktualizacja danych pokoju
    public void updateRoom(int roomNumber, String newType, boolean newAvailability) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.setType(newType);
                room.setAvailable(newAvailability);
                break;
            }
        }
    }

    // Usunięcie pokoju
    public void deleteRoom(int roomNumber) {
        rooms.removeIf(room -> room.getRoomNumber() == roomNumber);
    }
}
