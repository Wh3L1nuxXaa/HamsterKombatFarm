package wtf.Wh3L1nuxXaa;

import wtf.Wh3L1nuxXaa.library.HTTPConnection;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Enter your auth token");
        Scanner sc = new Scanner(System.in);
        String token = sc.nextLine();
        System.out.println("Enter your max energy");
        int maxEnerg = sc.nextInt();
        System.out.println("Enter your tap count");
        int tapcount = sc.nextInt();
        System.out.println("Enter cooldown (ms)");
        int time = sc.nextInt();
        onClick(maxEnerg, tapcount, time, token);
    }

    public static void onClick(int maxEnerg, int tapcount, long time, String token) throws InterruptedException, IOException {
        long unixTime = System.currentTimeMillis() / 1000L;
        System.out.println("[Click] Sended response: " + HTTPConnection.sendRequest(maxEnerg, tapcount, unixTime, token));
        Thread.sleep(time);
        onClick(maxEnerg, tapcount, time, token);
    }
}
