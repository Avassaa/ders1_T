/**
* @author Baha TÜTÜNCÜOĞLU
 * @since 1.0
 */
import java.util.Scanner;
public class TwoItemStore_20220808064 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        float itemTotal = 0;
        float itemTotal2 = 0;
        int itemRemaining= 0;
        int itemRemaining2=0;
        int count=0;
        String output=" ";
        String output2=" ";

        while(true) {
          //ITEM1 properties
          System.out.println("Enter item name 1");
          String itemName = scan.next();
            itemName = itemName.substring(0,1).toUpperCase()+ itemName.substring(1).toLowerCase();
            output=itemName;
          System.out.println("Enter item 1 quantity");
          int itemQuantity = scan.nextInt();
          itemRemaining=itemQuantity;
          if (itemQuantity < 0) {
              System.out.println("Error invalid input.");
              break;
          }
          System.out.println("Enter item 1 price");
          float itemPrice = scan.nextFloat();
          if (itemPrice < 0) {
              System.out.println("Error! Invalid input.");
              break;
          }

          //ITEM2 properties
          System.out.println("Enter item name 2");
          String itemName2 = scan.next();
            itemName2 = itemName2.substring(0,1).toUpperCase()+ itemName2.substring(1).toLowerCase();
            output2=itemName2;
          System.out.println("Enter item 2 quantity");
          int itemQuantity2 = scan.nextInt();
          itemRemaining2=itemQuantity2;
          if (itemQuantity2 < 0) {
              System.out.println("Error! Invalid input.");
              break;
          }
          System.out.println("Enter item 2 price");
          float itemPrice2 = scan.nextFloat();
          if (itemPrice2 < 0) {
              System.out.println("Error! Invalid input.");
              break;
          }


          while (true) {
              System.out.println("********************WELCOME TO OUR STORE********************");
              System.out.println("Which items would you like to purchase?\n1-" + itemName + "\n2-" + itemName2);
              System.out.println("0- If you're done shopping.");
              int itemSelection = scan.nextInt();
              if (itemSelection == 1) {
                  System.out.println("How many would you like to buy?");
                  int userRequest = scan.nextInt();
                  if(itemQuantity<userRequest){
                      System.out.println("We don't have that many left");
                      System.out.println("(We have "+itemQuantity+" "+itemName+" left)");

                  }
                  else if(userRequest<=0){
                      System.out.println("Please enter a valid quantity.");
                  }
                 else if((itemQuantity-userRequest)>=0){
                      itemQuantity-=userRequest;
                      itemTotal += itemPrice * userRequest;
                      itemRemaining=itemQuantity;


                  }


              }
             else if (itemSelection == 2) {
                  System.out.println("How many would you like to buy?");
                  int userRequest2 = scan.nextInt();
                  if(itemQuantity2<userRequest2){
                      System.out.println("We don't have that many left");
                      System.out.println("(We have "+itemQuantity2+" "+itemName2+" left)");

                  }
                  else if(userRequest2<=0){
                      System.out.println("Please enter a valid quantity.");
                  }
                 else if((itemQuantity2-userRequest2)>=0) {
                     itemQuantity2-=userRequest2;
                      itemTotal2 += itemPrice2 * userRequest2;
                      itemRemaining2 = itemQuantity2;
                  }

              }
              else if(itemSelection==0){
                  break;
              }
              else{
                  System.out.println("Please enter a valid item number.");
              }


          }
          count++;
          System.out.println("To exit program press 0, to restart press any number other than 0");
          int request=scan.nextInt();
          if(request==0)
              break;
          else
              continue;
      }

      float sum=itemTotal+itemTotal2;
      if(count>=1 ) {
          System.out.println("*******************CUSTOMER TOTAL ***********************");
          System.out.println("The total price for "+output+ " is " + itemTotal + "\nThe price for " +output2+" is  " + itemTotal2 + "\nTotal of " +sum);
          System.out.println("*******************FINAL REPORT ***********************");
          System.out.println(" We have total of "+itemRemaining+" of "+output+ " and "+itemRemaining2+" of "+output2+ " left in our inventory.");

      }
      }


    }
