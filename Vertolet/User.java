package Vertolet;



public class User {
    public static void main(String[] args) {
        Vertolet tv = new Vertolet();

        // Prompt the user to choose a method
        System.out.println("Choose a method to execute: ");
        System.out.println("1. Switch On TV");
        System.out.println("2. Switch Off TV");

        int choice = tv.sc.nextInt();

        // Execute the chosen method
        switch (choice) {
            case 1:
                tv.switchOnTv();
                break;
            case 2:
                tv.switchOffTv();
                break;
            default:
                System.out.println("Invalid choice");
        }

    }
}