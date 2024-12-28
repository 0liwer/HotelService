package hotel.main;

import hotel.structure.Room;
import hotel.service.RoomController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RoomController roomController = new RoomController();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\n=== System Zarządzania Hotelem ===");
            System.out.println("1. Dodaj pokój");
            System.out.println("2. Wyświetl wszystkie pokoje");
            System.out.println("3. Wyświetl dostępne pokoje");
            System.out.println("4. Zaktualizuj dane pokoju");
            System.out.println("5. Usuń pokój");
            System.out.println("6. Wyjdź");
            System.out.print("Wybierz opcję (lub wpisz '§' aby zakończyć): ");
            choice = scanner.nextLine();

            if (choice.equals("§")) {
                System.out.println("Zamykanie aplikacji...");
                break;
            }

            switch (choice) {
                case "1": // Dodanie pokoju
                    System.out.print("Podaj numer pokoju: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Czyszczenie bufora

                    String type;
                    while (true) {
                        System.out.println("Dostępne typy pokoi:");
                        for (String roomType : Room.RoomType.getAllTypes()) {
                            System.out.println("- " + roomType);
                        }
                        System.out.print("Podaj typ pokoju (lub wpisz '§' aby zakończyć): ");
                        type = scanner.nextLine();

                        if (type.equals("§")) {
                            System.out.println("Zamykanie aplikacji...");
                            return;
                        }

                        if (isValidRoomType(type)) {
                            break;
                        } else {
                            System.out.println("Nieprawidłowy typ pokoju. Spróbuj ponownie.");
                        }
                    }

                    int available;
                    while (true) {
                        System.out.print("Czy pokój jest dostępny (0 = Nie, 1 = Tak): ");
                        available = scanner.nextInt();
                        scanner.nextLine(); // Czyszczenie bufora

                        if (available == 0 || available == 1) {
                            break;
                        } else {
                            System.out.println("Nieprawidłowa wartość. Wprowadź 0 (Nie) lub 1 (Tak).\n");
                        }
                    }

                    boolean isAvailable = (available == 1);
                    roomController.addRoom(new Room(roomNumber, type, isAvailable));
                    System.out.println("Pokój został dodany pomyślnie!");
                    break;

                case "2": // Wyświetlenie wszystkich pokoi
                    System.out.println("Wszystkie pokoje:");
                    if (roomController.getAllRooms().isEmpty()) {
                        System.out.println("Brak zapisanych pokoi.");
                    } else {
                        roomController.getAllRooms().forEach(room -> System.out.println(formatRoomInfo(room)));
                    }
                    break;

                case "3": // Wyświetlenie dostępnych pokoi
                    System.out.println("Dostępne pokoje:");
                    if (roomController.getAvailableRooms().isEmpty()) {
                        System.out.println("Brak dostępnych pokoi.");
                    } else {
                        roomController.getAvailableRooms().forEach(room -> System.out.println(formatRoomInfo(room)));
                    }
                    break;

                case "4": // Aktualizacja pokoju
                    System.out.print("Podaj numer pokoju do aktualizacji: ");
                    int updateRoomNumber = scanner.nextInt();
                    scanner.nextLine(); // Czyszczenie bufora

                    System.out.print("Podaj nowy typ pokoju: ");
                    String newType = scanner.nextLine();

                    int newAvailable;
                    while (true) {
                        System.out.print("Czy pokój jest dostępny (0 = Nie, 1 = Tak): ");
                        newAvailable = scanner.nextInt();
                        scanner.nextLine(); // Czyszczenie bufora

                        if (newAvailable == 0 || newAvailable == 1) {
                            break;
                        } else {
                            System.out.println("Nieprawidłowa wartość. Wprowadź 0 (Nie) lub 1 (Tak).");
                        }
                    }

                    boolean isNewAvailable = (newAvailable == 1);
                    roomController.updateRoom(updateRoomNumber, newType, isNewAvailable);
                    System.out.println("Dane pokoju zostały zaktualizowane pomyślnie!");
                    break;

                case "5": // Usunięcie pokoju
                    System.out.print("Podaj numer pokoju do usunięcia: ");
                    int deleteRoomNumber = scanner.nextInt();
                    scanner.nextLine(); // Czyszczenie bufora

                    roomController.deleteRoom(deleteRoomNumber);
                    System.out.println("Pokój został usunięty pomyślnie!");
                    break;

                case "6": // Wyjście
                    System.out.println("Zamykanie aplikacji...");
                    break;

                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }
        } while (!choice.equals("6"));
    }

    private static boolean isValidRoomType(String type) {
        for (String validType : Room.RoomType.getAllTypes()) {
            if (validType.equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }

    private static String formatRoomInfo(Room room) {
        return String.format("Pokój %d - Typ: %s, Dostępny: %s",
                room.getRoomNumber(),
                room.getType(),
                room.isAvailable() ? "Tak" : "Nie");
    }
}