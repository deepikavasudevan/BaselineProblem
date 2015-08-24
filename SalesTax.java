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

        int quantityOfItem=Integer.parseInt(arrayOfDetails[0]);
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

        do {
           item= st.getItemDetails();
            st.formatItemDetails(item);
        } while (!(item.equals("Done")));

    }
}
