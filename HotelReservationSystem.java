import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class Room {

    String type;
    int price;
    boolean available;
}


class Customer {

    String name;
    String roomType;
}


public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Room standard = new Room();
        Room deluxe = new Room();
        Room suite = new Room();

        standard.type = "Standard";
        standard.price = 1000;
        standard.available = true;

        deluxe.type = "Deluxe";
        deluxe.price = 2000;
        deluxe.available = true;

        suite.type = "Suite";
        suite.price = 3000;
        suite.available = true;


        Customer customer = new Customer();

        System.out.println("HOTEL RESERVATION SYSTEM");

        // Search available rooms

        System.out.println("\nAVAILABLE ROOMS");

        if (standard.available) {
            System.out.println("1. Standard Room - Rs." + standard.price);
        }

        if (deluxe.available) {
            System.out.println("2. Deluxe Room - Rs." + deluxe.price);
        }

        if (suite.available) {
            System.out.println("3. Suite Room - Rs." + suite.price);
        }


        System.out.print("\nEnter your name: ");
        customer.name = sc.nextLine();

        System.out.print("Choose room number: ");
        int choice = sc.nextInt();


        boolean booked = false;

        // Booking and availability check

        if (choice == 1 && standard.available) {

            customer.roomType = standard.type;
            standard.available = false;
            booked = true;

        }

        else if (choice == 2 && deluxe.available) {

            customer.roomType = deluxe.type;
            deluxe.available = false;
            booked = true;

        }

        else if (choice == 3 && suite.available) {

            customer.roomType = suite.type;
            suite.available = false;
            booked = true;

        }

        else {

            System.out.println("Room is not available or invalid choice.");
        }


        if (booked) {

            System.out.println("\nRoom booked successfully!");

            int payment = 0;

            if (choice == 1) {
                payment = standard.price;
            }

            else if (choice == 2) {
                payment = deluxe.price;
            }

            else if (choice == 3) {
                payment = suite.price;
            }


            // Reservation details

            System.out.println("\nRESERVATION DETAILS");
            System.out.println("Customer Name: " + customer.name);
            System.out.println("Room Type: " + customer.roomType);
            System.out.println("Payment Amount: Rs." + payment);


            // Payment simulation

            System.out.println("\nPAYMENT STATUS");
            System.out.println("Payment Successful");


            // Manage reservation

            System.out.print("\nDo you want to cancel the reservation? (yes/no): ");
            String cancel = sc.next();

            if (cancel.equalsIgnoreCase("yes")) {

                if (choice == 1) {
                    standard.available = true;
                }

                else if (choice == 2) {
                    deluxe.available = true;
                }

                else if (choice == 3) {
                    suite.available = true;
                }

                System.out.println("Reservation cancelled successfully.");
                System.out.println("Room is available again.");

            }

            else {

                System.out.println("Reservation confirmed.");
            }


            // File handling

            try {

                FileWriter file =
                        new FileWriter("ReservationDetails.txt");

                file.write("HOTEL RESERVATION DETAILS\n\n");

                file.write("Customer Name: " +
                        customer.name + "\n");

                file.write("Room Type: " +
                        customer.roomType + "\n");

                file.write("Payment Amount: Rs." +
                        payment + "\n");

                file.write("Payment Status: Successful\n");

                if (cancel.equalsIgnoreCase("yes")) {

                    file.write("Reservation Status: Cancelled\n");

                }

                else {

                    file.write("Reservation Status: Confirmed\n");
                }

                file.close();

                System.out.println(
                        "\nReservation details saved in ReservationDetails.txt");

            }

            catch (IOException e) {

                System.out.println("File error");
            }
        }


        sc.close();
    }
}