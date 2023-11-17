package Vertolet;
import java.util.Scanner;

public class Vertolet {
    Scanner sc = new Scanner(System.in);
    String name = "Samsung";
    int buttons = 4;
    int channels = 14;

    // Method to switch off the TV
    public void switchOffTv() {
        System.out.println("if 1 tv turn off.");
        int i = 0;
        int b = i + sc.nextInt();

        if (b == 1) {
            System.out.println("TV is off");
        } else if (b < 1) {
            System.out.println("Nothing");
        }
    }

    // Method to switch on the TV
    public void switchOnTv() {
        System.out.println("TV is on");
        System.out.println("You have " + channels + " channels.");
        System.out.println("Do you want to add a channel? (write yes or no)");

        String choice = sc.next();

        switch (choice) {
            case "yes":
                System.out.println("write number u want to add:");
                // Reading channels to add
                int channelsToAdd = sc.nextInt();
                int wsSup = channels + channelsToAdd;
                System.out.println("Channels after switch on: " + wsSup);
                break;
            case "no":
                System.out.println("Channels remain unchanged.");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}


