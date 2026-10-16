package fleetflow;
import java.util.*;

public class Module1 {
    public static void menu(Scanner sc, DataRepository data) {
        while (true) {
            System.out.println("\n--- MODULE 1: DATA / ADDRESS / CODE SEARCH ---");
            System.out.println("1. Find delivery by Delivery ID");
            System.out.println("2. Find delivery by Tracking Code");
            System.out.println("3. Find delivery by Destination Address");
            System.out.println("4. Search any dataset field");
            System.out.println("5. Dataset summary");
            System.out.println("6. Show first 10 records");
            System.out.println("0. Back to main menu");
            int c = Util.readInt(sc, "Choice: ");
            if (c == 0) return;
            switch (c) {
                case 1: search(sc, data, "delivery_id", "Enter Delivery ID (example DLV-00001): "); break;
                case 2: search(sc, data, "tracking_code", "Enter Tracking Code (example TRK-00001): "); break;
                case 3: search(sc, data, "destination_address", "Enter full or partial address/city: "); break;
                case 4:
                    System.out.println("Available fields: " + String.join(", ", data.header()));
                    String f = Util.readLine(sc, "Field name exactly as shown: ");
                    String q = Util.readLine(sc, "Text to find: ");
                    List<Shipment> rs = data.search(f, q);
                    printResults(rs);
                    break;
                case 5: data.summary(); break;
                case 6: data.all().stream().limit(10).forEach(System.out::println); break;
                default: System.out.println("Invalid choice. Select 0-6.");
            }
        }
    }

    private static void search(Scanner sc, DataRepository data, String field, String prompt) {
        String query = Util.readLine(sc, prompt).trim();
        List<Shipment> results = data.search(field, query);
        printResults(results);
    }

    private static void printResults(List<Shipment> results) {
        System.out.println("Matches found: " + results.size());
        if (results.isEmpty()) {
            System.out.println("No match found. Check the code/address and try again.");
            return;
        }
        results.stream().limit(30).forEach(System.out::println);
        if (results.size() > 30) System.out.println("Showing first 30 matches.");
    }
}
