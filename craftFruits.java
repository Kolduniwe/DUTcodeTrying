import java.util.Scanner;
import java.util.Arrays;
public class craftFruits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] fruits = {"pine", "pen", "apple", "black", "employee"};
        //                   0       1       2        3       4
        System.out.print("Enter the index of fruit: ");
        for (int b = sc.nextInt(); b <= fruits.length; b+=0) {
            for (int i = sc.nextInt(); i <= fruits.length; i+=0) {
                System.out.println("U GOT A NEW FRUIT: " + fruits[b] + fruits[i]);
break;

            }
            return;
        }
    }
}
