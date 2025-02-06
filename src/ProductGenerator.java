import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {

        public static void main(String[] args) {
            ArrayList<Product> products = new ArrayList<>();
            Scanner in = new Scanner(System.in);

            File workingDirectory = new File(System.getProperty("user.dir"));
            Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

            boolean done = false;
            String productRec = "";

            String name = "";
            String description = "";
            String ID = "";
            double cost= 0;

            do {
                ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]: ");
                name = SafeInput.getNonZeroLenString(in, "Enter the products name: ");
                description = SafeInput.getNonZeroLenString(in, "Enter the products description: ");
                cost = SafeInput.getRangedDouble(in, " Enter the products cost:  ", 0, 9999);

               Product product = new Product(ID, name, description, cost);
                products.add(product);

                done= SafeInput.getYNConfirm(in, "Are you done?");
            }while(!done);

            for( Product p: products) {
                System.out.println(p.toCSV());
                System.out.println(p.toXMLRecord());
                System.out.println(p.toJSONRecord());
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile())))
            {

                for(Product product : products)
                {
                    writer.write(product.toCSV());

                    writer.newLine();  // adds the new line

                }
                writer.close(); // must close the file to seal it and flush buffer
                System.out.println("Data file written!");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }

