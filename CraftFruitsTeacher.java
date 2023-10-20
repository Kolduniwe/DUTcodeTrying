import java.io.BufferedReader;import java.io.IOException;
import java.io.InputStreamReader;
    public class CraftFruitsTeacher {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));         String[][] fruits = { { "pine", "pen", "apple", "black", "employee" } };
            String result = "";         int i = 0;
            while (i < 10) {
                try {                 System.out.print("Enter the index of the first fruit and the second: ");
                    String inputLine = br.readLine();                 String[] inputParts = inputLine.split(" ");
                    if (inputParts.length != 2) {
                        System.out.println("Invalid input. Please enter two integers separated by a space.");                     continue;
                    }
                    int b = Integer.parseInt(inputParts[0]);                 int c = Integer.parseInt(inputParts[1]);
                    if (b >= 0 && b < fruits[0].length && c >= 0 && c < fruits[0].length) {
                        i++;                     System.out.println("\nThe " + ((i == 1) ? i + "-st fruit: "
                                : (i == 2) ? i + "-nd" : (i == 3) ? i + "-rd" : i + "-th"));                     result += fruits[0][b] + fruits[0][c] + "\n";
                        System.out.print(fruits[0][b] + fruits[0][c] + "\n");                 } else {
                        System.out.println("Invalid index. The maximum index is " + (fruits[0].length - 1));                 }
                } catch (Exception e) {                 System.out.println("Invalid input. Please enter valid indices.");
                }         }
            System.out.println("You've reached the finish!");
            System.out.println("\nHistory: \n" + result);     }

    }
