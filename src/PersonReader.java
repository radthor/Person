import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class PersonReader {
    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<>();
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

                System.out.format("%-12s %-12s %-12s %-8s %-4s%n",
                        "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("==================================================");

                try (InputStream in = new BufferedInputStream(Files.newInputStream(file));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
                {

                    while (reader.ready()) {
                        rec = reader.readLine();
                        String[] fields = rec.split(",");
                        if (fields.length == 5) {
                            Person person = new Person(
                                    fields[0].trim(),  // ID
                                    fields[1].trim(),  // firstName
                                    fields[2].trim(),  // lastName
                                    fields[3].trim(),  // title
                                    Integer.parseInt(fields[4].trim())  // YOB
                            );
                            people.add(person);

                            System.out.format("%-12s %-12s %-12s %-8s %-4s%n",
                                    fields[0].trim(),
                                    fields[1].trim(),
                                    fields[2].trim(),
                                    fields[3].trim(),
                                    fields[4].trim());
                        }
                    }
                    System.out.println("\n\nData file read!");

                    System.out.println("\nPrinting all records in different formats:");
                    for(Person p : people) {
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
