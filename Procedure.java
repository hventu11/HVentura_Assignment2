public class Procedure {

    private static final double EXPENSIVE_THRESHOLD = 1000.00;
    private static final double MEDIUM_THRESHOLD = 500.00;

    private String procedureName;
    private String date;
    private String practitionerName;
    private double charges;

    //  Creates a Procedure with empty strings for th text fields.

    public Procedure() {
        this("", "", "", 0.0);
    }

    // Constructor that initializes the procedure name and date.

    public Procedure(String procedureName, String date) {
        this(procedureName, date, "", 0.0);
    }

    // Constructor that initializes name, date, practitioner, and charges.
    public Procedure(String procedureName, String date, String practitionerName, double charges) {
        this.procedureName = procedureName;
        this.date = date;
        this.practitionerName = practitionerName;
        this.charges = charges;
    }

    // Returns the name
    public String getProcedureName() { return procedureName; }

    // Returns the date
    public String getDate() { return date; }

    // Returns the name of the practitioner
    public String getPractitionerName() { return practitionerName; }

    //  Returns the charges
    public double getCharges() { return charges; }



    // Sets the name of the procedure.
    public void setProcedureName(String procedureName) { this.procedureName = procedureName; }

    // Sets the date the procedure
    public void setDate(String date) { this.date = date; }

    // Sets the name of the practitioner.
    public void setPractitionerName(String practitionerName) { this.practitionerName = practitionerName; }

    // Sets the charges for the procedure.
    public void setCharges(double charges) { this.charges = charges; }



    // Returns true if the procedure's charges are more than 1000

    public boolean isExpensiveProcedure() {
        return charges >= EXPENSIVE_THRESHOLD;
    }

    // Reduces the charges by the given percentage.

    public void applyDiscount(double percent) {
        if (percent >= 0 && percent <= 100) {
            charges = charges - (charges * percent / 100.0);
        }
    }

    // Returns the charge category for the procedure.
    public String getChargeCategory() {
        if (charges < MEDIUM_THRESHOLD) {
            return "Low";
        } else if (charges < EXPENSIVE_THRESHOLD) {
            return "Medium";
        } else {
            return "High";
        }
    }

    // Returns true if the given practitioner name matches
    public boolean isPerformedBy(String practitionerName) {
        return this.practitionerName.equalsIgnoreCase(practitionerName);
    }

    // Returns the charges formatted
    public String getFormattedCharge() {
        return String.format("$%,.2f", charges);
    }


    @Override
    public String toString() {
        return "Procedure: " + procedureName + "\n"
                + "Date: " + date + "\n"
                + "Practitioner: " + practitionerName + "\n"
                + "Charge: " + getFormattedCharge() + "\n"
                + "Category: " + getChargeCategory();
    }
}

