package hotel.structure;

public class Room {
    private int roomNumber;  // Numer pokoju
    private String type;     // Typ pokoju
    private boolean available; // Dostępność pokoju

    // Klasa statyczna dla typów pokoi
    public static class RoomType {
        public static final String JEDNOOSOBOWY = "Jednoosobowy";
        public static final String DWUOSOBOWY = "Dwuosobowy";
        public static final String DELUXE = "Deluxe";
        public static final String APARTAMENT = "Apartament";

        public static String[] getAllTypes() {
            return new String[] { JEDNOOSOBOWY, DWUOSOBOWY, DELUXE, APARTAMENT };
        }
    }

    // Konstruktor
    public Room(int roomNumber, String type, boolean available) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.available = available;
    }

    // Gettery i settery
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Reprezentacja tekstowa obiektu Room
    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", type='" + type + '\'' +
                ", available=" + available +
                '}';
    }
}
