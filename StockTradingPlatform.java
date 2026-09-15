import java.io.FileWriter;
import java.io.IOException;

class Stock {

    String name;
    int price;
    int quantity;
}

class User {

    String name;
    int balance;
}

class Transaction {

    String type;
    String stockName;
    int quantity;
    int amount;
}

public class StockTradingPlatform {

    public static void main(String[] args) {

        User u = new User();

        u.name = "Sushmitha";
        u.balance = 10000;


        Stock s1 = new Stock();
        Stock s2 = new Stock();
        Stock s3 = new Stock();

        s1.name = "TCS";
        s1.price = 300;
        s1.quantity = 0;

        s2.name = "Infosys";
        s2.price = 170;
        s2.quantity = 0;

        s3.name = "Wipro";
        s3.price = 130;
        s3.quantity = 0;


        System.out.println("STOCK TRADING PLATFORM");

        System.out.println("\nUser Name: " + u.name);
        System.out.println("Starting Balance: " + u.balance);

        System.out.println("\nMARKET DATA");

        System.out.println(s1.name + " Price: " + s1.price);
        System.out.println(s2.name + " Price: " + s2.price);
        System.out.println(s3.name + " Price: " + s3.price);


        int valueBefore =
                (s1.price * s1.quantity) +
                (s2.price * s2.quantity) +
                (s3.price * s3.quantity);

        System.out.println("\nPortfolio Value Before Transaction: " + valueBefore);


        Transaction t1 = new Transaction();

        t1.type = "BUY";
        t1.stockName = s1.name;
        t1.quantity = 5;
        t1.amount = s1.price * t1.quantity;

        u.balance = u.balance - t1.amount;
        s1.quantity = s1.quantity + t1.quantity;

        System.out.println("\nBought " + t1.quantity +
                " shares of " + t1.stockName);


        Transaction t2 = new Transaction();

        t2.type = "SELL";
        t2.stockName = s1.name;
        t2.quantity = 2;
        t2.amount = s1.price * t2.quantity;

        u.balance = u.balance + t2.amount;
        s1.quantity = s1.quantity - t2.quantity;

        System.out.println("Sold " + t2.quantity +
                " shares of " + t2.stockName);


        int valueAfter =
                (s1.price * s1.quantity) +
                (s2.price * s2.quantity) +
                (s3.price * s3.quantity);

        System.out.println("\nPORTFOLIO");

        System.out.println(s1.name +
                " Quantity: " + s1.quantity);

        System.out.println(s2.name +
                " Quantity: " + s2.quantity);

        System.out.println(s3.name +
                " Quantity: " + s3.quantity);

        System.out.println("Available Balance: " + u.balance);

        System.out.println("Portfolio Value: " + valueAfter);


        System.out.println("\nPORTFOLIO PERFORMANCE");

        System.out.println("Before Transaction: " + valueBefore);
        System.out.println("After Transaction: " + valueAfter);


        System.out.println("\nTRANSACTION HISTORY");

        System.out.println(t1.type + " " +
                t1.quantity + " " +
                t1.stockName +
                " Amount: " + t1.amount);

        System.out.println(t2.type + " " +
                t2.quantity + " " +
                t2.stockName +
                " Amount: " + t2.amount);


        try {

            FileWriter file = new FileWriter("TransactionHistory.txt");

            file.write("STOCK TRADING PLATFORM\n\n");

            file.write("User Name: " + u.name + "\n");
            file.write("Balance: " + u.balance + "\n\n");

            file.write("TRANSACTION HISTORY\n");

            file.write(t1.type + " " +
                    t1.quantity + " " +
                    t1.stockName +
                    " Amount: " + t1.amount + "\n");

            file.write(t2.type + " " +
                    t2.quantity + " " +
                    t2.stockName +
                    " Amount: " + t2.amount + "\n");

            file.close();

            System.out.println("\nTransaction details saved in TransactionHistory.txt");

        }

        catch (IOException e) {

            System.out.println("File error");
        }
    }
}