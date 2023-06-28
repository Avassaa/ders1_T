import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class StoreUsingFiles_20220808064 {
    static String a;

    public static void main( String[] args) throws Exception {
a=args[0];
        File requestFile=new File(args[0]+"_Order.txt");
        File logFile=new File(args[0]+".log");
        File receiptFile=new File(args[0]+"_Receipt.txt");
        Scanner requestReader =new Scanner(requestFile);

        PrintWriter receiptWriter =new PrintWriter(receiptFile);
        PrintWriter errorWriter =new PrintWriter(logFile);



        String[] IDreader=new String[countProducts(args[0]+"_ProductInfo.txt")];
        String [] itemNameReader=new String[countProducts(args[0]+"_ProductInfo.txt")];
        int [] quantityReader=new int [countProducts(args[0]+"_ProductInfo.txt")];
        double[] priceReader = new double[countProducts(args[0]+"_ProductInfo.txt")];
        //inventory section

        getProductInfo(IDreader,itemNameReader,quantityReader,priceReader,args[0]+"_ProductInfo.txt");
        String [] requestID=new String[countProducts(args[0]+"_Order.txt")];
        int [] requestQuantity=new int[countProducts(args[0]+"_Order.txt")];
        for(int i=0;i<countProducts(args[0]+"_Order.txt");i++){

            requestID[i]=requestReader.next();
            requestQuantity[i]=requestReader.nextInt();
        }
boolean[] IDcheck=new boolean[countProducts(args[0]+"_Order.txt")];
boolean[] positiveCheck= new boolean[countProducts(args[0]+"_Order.txt")];

        for(int i=0;i<countProducts(args[0]+"_ProductInfo.txt");i++) {
            for (int k = 0; k < countProducts(args[0] + "_Order.txt"); k++) {
                if (IDreader[i].equals(requestID[k])) {
                    IDcheck[k] = true;

                    if (requestQuantity[k] > quantityReader[i]) {
                        errorWriter.println("Your request exceeds the quantity.We have " + quantityReader[i] + " of item " + itemNameReader[i]);
                    }



                  else  if (requestQuantity[k] <= quantityReader[i] && requestQuantity[k] >= 0) {
                        quantityReader[i] -= requestQuantity[k];
                    }

                }
            }
        }

        for(int i =0;i<IDcheck.length;i++) {
            if (!(IDcheck[i]))
                errorWriter.println("The item with ID " + requestID[i] + " not found :))");
            if (requestQuantity[i] < 0) {
                errorWriter.println("The request for item " + requestID[i] + " can't be less than 0.");
                positiveCheck[i] = true;
            }
        }
        errorWriter.close();
        int receiptWriterLength=countProducts(args[0]+"_ProductInfo.txt");
        int orderLength= countProducts(args[0]+"_Order.txt");
        writeProductInfo(IDreader,itemNameReader,quantityReader,priceReader,args[0]+"_ProductInfoAfterOrder.txt");

        for(int i=0;i<receiptWriterLength;i++){
            if(i==0)
            receiptWriter.println("******************************");
            for(int k =0;k<orderLength;k++){
                if(IDreader[i].equals(requestID[k])&&requestQuantity[k]>=0){
                    receiptWriter.println((i+1)+"- "+itemNameReader[i]+" "+requestQuantity[k]+"X"+priceReader[i]+ " is total of "
                    +priceReader[i]*requestQuantity[k]+" TL");
                }
            }
            if(i==receiptWriterLength-1)
                receiptWriter.println("****************************");



        }
        receiptWriter.close();
    }
    public static int countProducts(String filename) throws FileNotFoundException {
        int lineCount=0;
        File f=new File(filename);
        Scanner scan=new Scanner(f);
      String a ="";
        Scanner lineCounter=new Scanner(f);
        while(scan.hasNextLine()){
           a=scan.nextLine();
            lineCount++;
        }
        lineCounter.close();
        return lineCount;
    }

    public static void getProductInfo(String [] itemID,String[] itemName,int[] quantity,double[] price
            ,String filename) throws Exception {
        File f = new File(filename);
        Scanner inputFromFile = new Scanner(f);
        int lineCount = countProducts(filename);
        for (int i = 0; i < lineCount; i++) {
            itemID[i] = inputFromFile.next();
            itemName[i] = inputFromFile.next();
            quantity[i] = inputFromFile.nextInt();
            price[i] = inputFromFile.nextDouble();
        }
    }
    public static void writeProductInfo(String [] itemID,String[] itemName,int[] quantity,double[] price
            ,String filename) throws Exception{
        File f = new File(filename);
        int lineCount = countProducts(a+"_ProductInfo.txt");
        try(
        PrintWriter pw =new PrintWriter(f)
        ){
           for(int i=0; i<lineCount;i++){
               pw.print(itemID[i]+" "+itemName[i]+" "+quantity[i]+" "+price[i]);
               pw.println();
           }
        }
    }



}