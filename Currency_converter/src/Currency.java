import java.net.HttpURLConnection;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Scanner;

import javax.print.DocFlavor.URL;

public class Currency {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, String> CODESofCurr = new HashMap<Integer, String>();

        CODESofCurr.put(1, "USD");
        CODESofCurr.put(2, "INR");
        CODESofCurr.put(3, "CAD");
        CODESofCurr.put(4, "EUR");
        CODESofCurr.put(5, "HKD");

        int fromcode, tocode;
        double amount;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the currency converter\n");

        System.out.println("What would you want to convert from?\n");
        System.out.print("Press:\n 1. USD \n 2.INR \n 3. CAD \n 4. EUR \n 5.HKD\n\n");
        fromcode = sc.nextInt();

        System.out.println("What would you want it to convert into?\n");
        System.out.print("Press:\n 1. USD \n 2.INR \n 3. CAD \n 4. EUR \n 5.HKD\n\n");
        tocode = sc.nextInt();
        System.out.println("Enter the amount:\n");
        amount = sc.nextInt();

        sc.close();

        SendHttpGetRequest(fromcode, tocode, amount);

        System.out.println("Thank You for using my converter");
    }

    public static void SendHttpGetRequest(int fromcode, int tocode, double amount) {
        String GET_URL = "http://data.fixer.io/api/latest?access_key=08c5e8b2b001509a2aa6bebe697441d7/base=" + tocode
                + "&symbols" + fromcode;
        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = url.openConnection();
    }
}
