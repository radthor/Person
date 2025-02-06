import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

        public static void main(String[] args) {
            ArrayList<Person> people = new ArrayList<>();
            Scanner in = new Scanner(System.in);

            File workingDirectory = new File(System.getProperty("user.dir"));
            Path file = Paths.get(workingDirectory.getPath() + "\\src\\personData.txt");

            boolean done = false;

            String personRec = "";
            String ID = "";
            String firstName = "";
            String lastName = "";
            String title = "";
            int YOB = 0;

            do {
                ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]: ");
                firstName = SafeInput.getNonZeroLenString(in, "Enter the first name: ");
                lastName = SafeInput.getNonZeroLenString(in, "Enter the last name: ");
                title = SafeInput.getNonZeroLenString(in, "Enter the title: ");
                YOB = SafeInput.getRangedInt(in, " Enter the year of birth: ", 1000, 9999);

                Person person = new Person (ID, firstName, lastName, title, YOB);
                people.add(person);

                done= SafeInput.getYNConfirm(in, "Are you done?");
            }while(!done);

            for( Person p: people) {
                System.out.println(p.toCSV());
                System.out.println(p.toXMLRecord());
                System.out.println(p.toJSONRecord());
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile())))
            {

                for(Person person : people)
                {
                    writer.write(person.toCSV());

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

