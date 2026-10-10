
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PatientDriverApp {


    private static final String STUDENT_NAME = "Herson Ventura";

    private static final String TABLE_FORMAT = "%-20s%-13s%-20s%-16s%s%n";

    // Prompts the user for patient information

    static Patient inputPatient(Scanner input) {
        System.out.print("Enter first name: ");
        String first = input.nextLine();
        System.out.print("Enter middle name: ");
        String middle = input.nextLine();
        System.out.print("Enter last name: ");
        String last = input.nextLine();
        System.out.print("Enter street address: ");
        String street = input.nextLine();
        System.out.print("Enter city: ");
        String city = input.nextLine();
        System.out.print("Enter state: ");
        String state = input.nextLine();
        System.out.print("Enter zip: ");
        String zip = input.nextLine();
        System.out.print("Enter phone number (###-###-####): ");
        String phone = input.nextLine();
        System.out.print("Enter emergency contact name: ");
        String emergencyName = input.nextLine();
        System.out.print("Enter emergency contact phone (###-###-####): ");
        String emergencyPhone = input.nextLine();

        return new Patient(first, middle, last, street, city, state, zip,
                phone, emergencyName, emergencyPhone);
    }

    // Creates the first procedure using the no-arg constructor

    static Procedure createProcedure1() {
        Procedure procedure = new Procedure();
        procedure.setProcedureName("Physical Exam");
        procedure.setDate("07/20/2026");
        procedure.setPractitionerName("Dr. Irvine");
        procedure.setCharges(250.00);
        return procedure;
    }

    // Creates the second procedure using the name/date constructor
    static Procedure createProcedure2() {
        Procedure procedure = new Procedure("X-ray", "07/20/2026");
        procedure.setPractitionerName("Dr. Jamison");
        procedure.setCharges(550.43);
        return procedure;
    }

    // Creates the third procedure using the constructor
    static Procedure createProcedure3() {
        return new Procedure("Blood Test", "07/20/2026", "Dr. Smith", 1400.75);
    }

    // Displays all patient information under a heading

    static void displayPatient(Patient patient) {
        System.out.println();
        System.out.println("Patient Information");
        System.out.println("-------------------");
        System.out.println(patient);
        System.out.println("Phone Valid: " + patient.isValidPhoneNumber());
        System.out.println("Emergency Phone Valid: " + patient.isValidEmergencyPhoneNumber());
    }

    //  Displays a single procedure as one aligned row
    static void displayProcedure(Procedure procedure) {
        System.out.printf(TABLE_FORMAT,
                procedure.getProcedureName(),
                procedure.getDate(),
                procedure.getPractitionerName(),
                procedure.getFormattedCharge(),
                procedure.getChargeCategory());
    }

    // Displays the column headings and a separator line,
    static void displayProcedureTable(Procedure p1, Procedure p2, Procedure p3) {
        System.out.println();
        System.out.printf(TABLE_FORMAT, "Procedure", "Date", "Practitioner", "Charge", "Category");
        System.out.println("-".repeat(72));
        displayProcedure(p1);
        displayProcedure(p2);
        displayProcedure(p3);
    }

    // Returns the sum of the charges of the three procedures.

    static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
        return p1.getCharges() + p2.getCharges() + p3.getCharges();
    }

    // Returns the average charge of the three procedures.

    static double calculateAverageCharge(Procedure p1, Procedure p2, Procedure p3) {
        return calculateTotalCharges(p1, p2, p3) / 3.0;
    }

    // Returns the procedure with the highest charge

    static Procedure findHighestChargeProcedure(Procedure p1, Procedure p2, Procedure p3) {
        Procedure highest = p1;
        if (p2.getCharges() > highest.getCharges()) {
            highest = p2;
        }
        if (p3.getCharges() > highest.getCharges()) {
            highest = p3;
        }
        return highest;
    }

    //  Returns how many of the three procedures
    static int countExpensiveProcedures(Procedure p1, Procedure p2, Procedure p3) {
        int count = 0;
        if (p1.isExpensiveProcedure()) count++;
        if (p2.isExpensiveProcedure()) count++;
        if (p3.isExpensiveProcedure()) count++;
        return count;
    }

    //  Displays the charge summary
    static void displaySummary(Procedure p1, Procedure p2, Procedure p3) {
        System.out.println();
        System.out.printf("Total Charges: $%,.2f%n", calculateTotalCharges(p1, p2, p3));
        System.out.printf("Average Charge: $%,.2f%n", calculateAverageCharge(p1, p2, p3));
        System.out.println("Highest Charge Procedure: "
                + findHighestChargeProcedure(p1, p2, p3).getProcedureName());
        System.out.println("Number of Expensive Procedures: "
                + countExpensiveProcedures(p1, p2, p3));
    }

    // Reads the patient from the keyboard, creates the procedures
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Patient patient = inputPatient(input);
        Procedure p1 = createProcedure1();
        Procedure p2 = createProcedure2();
        Procedure p3 = createProcedure3();

        displayPatient(patient);
        displayProcedureTable(p1, p2, p3);
        displaySummary(p1, p2, p3);

        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yy"));
        System.out.println();
        System.out.println("The program was developed by a Student: " + STUDENT_NAME + " " + today);

        input.close();
    }
}
