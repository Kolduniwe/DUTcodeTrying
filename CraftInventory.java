import java.util.Arrays;
import java.util.Scanner;

public class CraftInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your nickname: ");
        String nickname = scanner.nextLine();

        String[] inventoryWeapons = {"DesertEagle", "Bat", "Katana"};

        System.out.println("Your Inventory:");
        for (int i = 0; i < inventoryWeapons.length; i++) {
            System.out.println("[" + i + "] " + inventoryWeapons[i]);
        }

        String[] heroes = {"Adolf", "Yaroslav", "Sofia"};

        System.out.println("\nMy Heroes:");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println("Hero [" + i + "]: " + heroes[i]);
        }

        System.out.print("\nEnter the indices of the inventory items you want to select (separated by space): ");
        String input = scanner.nextLine();
        String[] selectedIndices = input.split("\\s+");

        String[] selectedItems = new String[Math.min(selectedIndices.length, 2)];

        for (int i = 0; i < selectedItems.length; i++) {
            int selectedIndex = Integer.parseInt(selectedIndices[i]);
            if (selectedIndex >= 0 && selectedIndex < inventoryWeapons.length) {
                selectedItems[i] = inventoryWeapons[selectedIndex];
            } else {
                System.out.println("Invalid index. Skipping selection.");
            }
        }

        System.out.print("You selected: ");
        boolean anyItemSelected = false;
        for (String selectedItem : selectedItems) {
            if (selectedItem != null) {
                System.out.print(selectedItem + " ");
                anyItemSelected = true;
            }
        }

        System.out.println();

        System.out.print("Enter the index of the hero you want to select: ");
        int selectedHeroIndex = scanner.nextInt();

        if (selectedHeroIndex >= 0 && selectedHeroIndex < heroes.length) {
            String selectedHero = heroes[selectedHeroIndex];
            System.out.println("You selected: " + selectedHero);

            if (!selectedHero.equalsIgnoreCase("tolubko") && anyItemSelected) {
                System.out.println("You did not choose tolubko :(. Character's name: " + selectedHero);
                System.out.println("Your items " + Arrays.toString(selectedItems));
                System.out.println("Your nickname: " + nickname);
            }
        } else {
            System.out.println("Invalid index. No hero selected.");
        }

        scanner.close();
    }
}