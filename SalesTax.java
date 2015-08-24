/**
 * Created by vdeepika on 24/08/15.
 */
import java.io.*;

public class SalesTax {

    String getItem() {
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

    double calculateSalesTax(int shelfPrice) {
        int salesTax=shelfPrice*
    }

    public static void main(String[] args) {

        SalesTax st=new SalesTax();
        String item;

        do {
           item= st.getItem();
        } while (!(item.equals("Done")));

    }
}
