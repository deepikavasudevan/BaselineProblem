/**
 * Created by vdeepika on 24/08/15.
 */
import com.sun.tools.javac.util.BasicDiagnosticFormatter;

import java.io.*;

public class SalesTax {

    double totalSalesTax=0.0, totalPrice=0.0;
    String bill="";

    String getItemDetails() {
        String totalItemDetails="";
        try {
            BufferedReader br=new BufferedReader (new InputStreamReader (System.in));
            totalItemDetails=br.readLine();
        }
        catch (IOException io) {
            System.err.println("Error in input"+io);
        }
     return totalItemDetails;
    }

    boolean isImportedItem(String value) {
        if (value.equalsIgnoreCase("imported"))
            return true;
        else
            return false;
    }

    boolean isExemptedFromSalesTax(String itemName) {
        String exemptedItems[]={"book", "pills", "chocolate", "chocolates"};
        boolean isExempted=false;
            for (int i=0;i<exemptedItems.length-1;i++){
                if (itemName.contains(exemptedItems[i])) {
                 isExempted=true;
                    break;
                }
            }
    return isExempted;
    }

    void calculatesTotalCost(int quantityOfItem, double shelfPriceOfItem, String itemName, boolean isImportedItem) {
        double totalCost=0.0d;
        double salesTax=0.0d, importTax=0.0d;

        if (!(isExemptedFromSalesTax(itemName))) {
            salesTax=calculateSalesTax(shelfPriceOfItem);
        }

        if (isImportedItem) {
            importTax=calculateImportedTax(shelfPriceOfItem);
        }

        totalCost=Math.round((shelfPriceOfItem+salesTax+importTax)*100.0)/100.0;

        bill+=quantityOfItem+" "+itemName+":"+totalCost+"\n";
        totalPrice+=totalCost;
    }

    void formatItemDetails(String itemDetails) {
        String arrayOfDetails[]=itemDetails.split(" ");
        String itemName="";

        int lastIndex=arrayOfDetails.length-1;

        int quantityOfItem=Integer.parseInt(arrayOfDetails[0]);
        double shelfPriceOfItem=Double.parseDouble (arrayOfDetails[lastIndex]);

        if (isImportedItem(arrayOfDetails[1])) {
            for (int i=2;i<lastIndex-1;i++){
                itemName+=arrayOfDetails[i]+" ";
            }
        }
        else {
            for (int i=1;i<lastIndex-1;i++){
                itemName+=arrayOfDetails[i]+" ";
            }
        }

        calculatesTotalCost(quantityOfItem, shelfPriceOfItem, itemName, isImportedItem(arrayOfDetails[1]));
    }


    double calculateSalesTax(double shelfPrice) {
        double salesTax=Math.round((shelfPrice*0.10)*100.0)/100.0;

        totalSalesTax+=salesTax;

        return salesTax;
    }

    double calculateImportedTax(double shelfPrice) {

        return (shelfPrice*0.05);
    }

    void printBill() {
        System.out.println(bill);
        System.out.println("Sales Taxes: "+totalSalesTax);
        System.out.println("Total: "+totalPrice);
    }

    public static void main(String[] args) {

        SalesTax st=new SalesTax();
        String item;

        for (; ;) {
           item= st.getItemDetails();

           if (!(item.equals("Done"))) {
               st.formatItemDetails(item);
           }
           else {
           break;
           }
        }

        st.printBill();
    }
}
