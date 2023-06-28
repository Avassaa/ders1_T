import java.util.Scanner;
public class Breadstore_20220808064 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter how many breads are left");
        int breadCount = scan.nextInt();

        if (breadCount < 0) {
            System.out.println("Error");
        }
        else  {
            System.out.println("Enter the cost of a bread.");
            double breadPrice = scan.nextDouble();

            if (breadPrice < 0)
                System.out.println("Wrong input");
            else {

                System.out.println("Welcome to TÜTÜNCÜOĞLU Bakery we have a total amount of " + breadCount + " breads, How many breads would you like?");
                int customerRequest = scan.nextInt();
                if (customerRequest <= 0 || breadCount < customerRequest) {
                    System.out.println("Wrong input");
                }
                if (customerRequest > 0 && breadCount >= customerRequest) {
                    int breadsLeft = breadCount - customerRequest;
                    System.out.println("Total cost is " + customerRequest * breadPrice);
                    System.out.println("Breads left " + breadsLeft);
                }
            }
        }
    }
}
