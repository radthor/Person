import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ProductReader {

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        System.out.println("Please select a file");
        try {

            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                System.out.format("%-12s %-12s %-26s %-3s%n",
                        "ID", "Name", "Description", "Cost");
                System.out.println("=======================================================");

                try (InputStream in = new BufferedInputStream(Files.newInputStream(file));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

                    while (reader.ready()) {
                        rec = reader.readLine();
                        String[] fields = rec.split(",");
                        if (fields.length == 4) {
                            Product product = new Product(
                                    fields[0].trim(),  // ID
                                    fields[1].trim(),  // Name
                                    fields[2].trim(),  // Description
                                    Double.parseDouble(fields[3].trim())  // Cost

                            );
                            products.add(product);

                            System.out.format("%-12s %-12s %-26s %-3s%n",
                                    fields[0].trim(),
                                    fields[1].trim(),
                                    fields[2].trim(),
                                    fields[3].trim());
                        }
                    }
                    System.out.println("\n\nData file read!");

                    System.out.println("\nPrinting all records in different formats:");
                    for (Product p : products) {
                        System.out.println("\nCSV Format:");
                        System.out.println(p.toCSV());
                        System.out.println("\nJSON Format:");
                        System.out.println(p.toJSONRecord());
                        System.out.println("\nXML Format:");
                        System.out.println(p.toXMLRecord());
                    }
                }
            } else  // User closed the chooser without selecting a file
            {
                System.out.println("No file selected!!! ... exiting.\nRun the program again and select a file.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
