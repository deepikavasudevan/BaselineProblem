/**
 * Created by vdeepika on 24/08/15.
 */
import java.io.*;

public class SalesTax {

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

    void formatItemDetails(String itemDetails) {
        String arrayOfDetails[]=itemDetails.split(" ");
        String itemName="";

        int lastIndex=arrayOfDetails.length-1;

        int quantityOfItem=Integer.parseInt(arrayOfDetails[0]);
        double shelfPriceOfItem=Double.parseDouble (arrayOfDetails[lastIndex]);

        if (arrayOfDetails[1].equalsIgnoreCase("imported")) {
            for (int i=2;i<lastIndex-1;i++){
                itemName+=arrayOfDetails[i];
            }
        }
        else {
            for (int i=1;i<lastIndex-1;i++){
                itemName+=arrayOfDetails[i];
            }
        }

        System.out.println ("Q"+quantityOfItem+" S"+shelfPriceOfItem+"I"+itemName);

    }

    double calculateSalesTax(double shelfPrice) {

        return (shelfPrice*0.10);
    }

    double calculateImportedTax(double shelfPrice) {

        return (shelfPrice*0.05);
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
               System.exit(0);
           }
        }

    }
}
