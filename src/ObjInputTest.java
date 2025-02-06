import java.util.Scanner;

public class ObjInputTest {


    public static void main(String[] args) {
        // Create a SafeInputObj instance
        SafeInputObj safeInput = new SafeInputObj();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Testing SafeInputObj methods:\n");

        // Test getNonZeroLenString
        System.out.println("Testing getNonZeroLenString:");
        String nonZeroString = safeInput.getNonZeroLenString(scanner, "Enter any non-empty string");
        System.out.println("You entered: " + nonZeroString + "\n");

        // Test getMinLenString
        System.out.println("Testing getMinLenString:");
        String minLenString = safeInput.getMinLenString(scanner, "Enter a string", 5);
        System.out.println("You entered: " + minLenString + "\n");

        // Test getRangedInt
        System.out.println("Testing getRangedInt:");
        int rangedInt = safeInput.getRangedInt(scanner, "Enter a number", 1, 10);
        System.out.println("You entered: " + rangedInt + "\n");

        // Test getInt
        System.out.println("Testing getInt:");
        int regularInt = safeInput.getInt(scanner, "Enter any integer");
        System.out.println("You entered: " + regularInt + "\n");

        // Test getRangedDouble
        System.out.println("Testing getRangedDouble:");
        double rangedDouble = safeInput.getRangedDouble(scanner, "Enter a decimal number", 0, 100);
        System.out.println("You entered: " + rangedDouble + "\n");

        // Test getDouble
        System.out.println("Testing getDouble:");
        double regularDouble = safeInput.getDouble(scanner, "Enter any decimal number");
        System.out.println("You entered: " + regularDouble + "\n");

        // Test getYNConfirm
        System.out.println("Testing getYNConfirm:");
        boolean yesNo = safeInput.getYNConfirm(scanner, "Do you want to continue?");
        System.out.println("You entered: " + (yesNo ? "Yes" : "No") + "\n");

        // Test getRegExString
        System.out.println("Testing getRegExString:");
        String regExString = safeInput.getRegExString(scanner, "Enter a valid email address", "^[A-Za-z0-9+_.-]+@(.+)$");
        System.out.println("You entered: " + regExString + "\n");

        System.out.println("All tests completed!");
        scanner.close();
    }
}
