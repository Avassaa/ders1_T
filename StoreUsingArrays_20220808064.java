import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class StoreUsingArrays_20220808064 {
    public static void main(String[] args) {

    }
    public static int menu(String[] item, double[] price, Scanner scan) {
        int itemRequest;
        capitalizeArray(item);

        System.out.println("~*~*~*~*~*~*~*~*~*~*~*~MENU~*~*~*~*~*~*~*~*~*~*~*~");

        for (int j = 0; j < item.length; j++) {
            System.out.println(j+1 + "- " + item[j] + " - " + price[j]+"TL");
        }

        System.out.println("0- To exit.");
        System.out.println("Which item would you like to buy");
        itemRequest = (scan.nextInt())-1;

        return itemRequest;

    }
    public static void storeRun(String[] items, int[] itemQuantity, double[] price) {
        double totalCost = 0;
        int itemRequest;
        int userRequest = 0;
        int temp=0;
        int counter=0;
        String[] outputArray=new String[items.length];
        Arrays.fill(outputArray, "");
        Scanner scan = new Scanner(System.in);
        System.out.println("**************Welcome to our store********* ");


        while (true) {
            itemRequest = menu(items, price, scan);
            if (itemRequest == -1) {

                break;
            } else if (itemRequest > items.length ||itemRequest < -1) {
                System.out.println("Error");
                continue;
            } else {

                System.out.println("How many of "+items[itemRequest]+" would you like");
                userRequest=scan.nextInt();

                if(userRequest>itemQuantity[itemRequest]){
                    System.out.println("Error,we don't have that many left.");
                    continue;
                }
                else if(userRequest<0) {
                    System.out.println("User request can't be less than 0.Exiting.");
                }
                else{
                    if(itemQuantity[itemRequest]>=userRequest) {
                        counter++;
                        totalCost += price[itemRequest] * userRequest;
                        itemQuantity[itemRequest]-=userRequest;
                        outputArray[itemRequest] = items[itemRequest] + "- " + userRequest + "x" + price[itemRequest] +"="+userRequest*price[itemRequest]+"TL and "+itemQuantity[itemRequest]+" remaining";

                    }
                    System.out.println("If you wish to continue press a number other than 0");
                    temp=scan.nextInt();

                }
                if (temp == 0) {
                    break;
                }
            }
        }
        if(counter!=0) {
            System.out.println("*********CHECKOUT***********");
            for(String i : outputArray) {
                if(!(i.equals("")))
                    System.out.println(i);
            }
            System.out.println("Total of "+totalCost);
            System.out.println("-------------------------");
            System.out.println("Money to be returned is");
            System.out.println(returnedAmounts(totalCost));
            System.out.println("************************");

        }
        else
            System.out.println("You didn't buy anything.");
    }

    public static String capitalizeString(String a) {
        a = a.substring(0, 1).toUpperCase() + a.substring(1).toLowerCase();
        return a;
    }
    public static void capitalizeArray(String[] sArr) {
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = capitalizeString(sArr[i]);
        }
    }

    public static String returnedAmounts(double amount ){
        String output=" ";
        int returnCount=0;
        int incm=0;
        double[] banknoteArray={0.01,0.05,0.10,0.25,0.50,1,5,10,20,50,100,200};
        int[] returnArray=new int [banknoteArray.length];


        for(int i = banknoteArray.length-1; i>=0;i--){
            if (amount >= banknoteArray[i]) {
                incm=(int)(amount/banknoteArray[i]);
                amount %= banknoteArray[i];
                returnArray[i]+=incm;
                output+=returnArray[i]+"- "+banknoteArray[i]+"\n";
            }
        }
        return output;
    }
}