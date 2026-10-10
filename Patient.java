public class Patient {

    private String firstName;
    private String middleName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String emergencyContactName;
    private String emergencyContactPhone;

    // Creates a Patient with every field set to an empty string

    public Patient() {
        this("", "", "", "", "", "", "", "", "", "");
    }

    // Constructor that initializes the first, middle, and last name.

    public Patient(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "", "", "", "", "", "", "");
    }

    // initializes attributes of the patient

    public Patient(String firstName, String middleName, String lastName,
                   String streetAddress, String city, String state, String zipCode,
                   String phoneNumber, String emergencyContactName,
                   String emergencyContactPhone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
    }



    // Returns  patient's first name
    public String getFirstName() { return firstName; }

    // Returns patient's middle name
    public String getMiddleName() { return middleName; }

    // Returns patient's last name.
    public String getLastName() { return lastName; }

    // Returns patient's street address
    public String getStreetAddress() { return streetAddress; }

    // Returns patient's city
    public String getCity() { return city; }

    // Returns patient's state
    public String getState() { return state; }

    // Returns patient's ZIP code.
    public String getZipCode() { return zipCode; }

    // Returns patient's phone number
    public String getPhoneNumber() { return phoneNumber; }

    // Returns emergency contacts name
    public String getEmergencyContactName() { return emergencyContactName; }

    // Returns emergency contact's phone number
    public String getEmergencyContactPhone() { return emergencyContactPhone; }


    // Sets patient's first name
    public void setFirstName(String firstName) { this.firstName = firstName; }

    // Sets  patient's middle name
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    // Sets  patient's last name
    public void setLastName(String lastName) { this.lastName = lastName; }

    // Sets  patient's street address
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }

    // Sets  patient's city
    public void setCity(String city) { this.city = city; }

    // Sets  patient's state
    public void setState(String state) { this.state = state; }

    // Sets  patient's ZIP code
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    // Sets patient's phone number
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    // Sets emergency contact's name
    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    // Sets emergency contact's phone number
    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }



    // Builds and returns  patient's full name

    public String buildFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    // Builds and returns the patient's address

    public String buildAddress() {
        return streetAddress + " " + city + " " + state + " " + zipCode;
    }

    //  Builds and returns emergency contact

    public String buildEmergencyContact() {
        return emergencyContactName + " " + emergencyContactPhone;
    }



    // checks whether a phone number matches the format

    private static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    // Returns true if the patient's phone number is in

    public boolean isValidPhoneNumber() {
        return isValidPhone(phoneNumber);
    }

    //  Returns true if the emergency contact's phone number is available

    public boolean isValidEmergencyPhoneNumber() {
        return isValidPhone(emergencyContactPhone);
    }

    //  Returns the patient's name in the form
    public String getLastFirstMiddle() {
        return lastName + ", " + firstName + " " + middleName;
    }

    // Returns true if the given city and state match the patient's city

    public boolean hasSameCityState(String city, String state) {
        return this.city.equalsIgnoreCase(city) && this.state.equalsIgnoreCase(state);
    }

    // Updates all four address fields (
    public void updateAddress(String street, String city, String state, String zip) {
        this.streetAddress = street;
        this.city = city;
        this.state = state;
        this.zipCode = zip;
    }

    // Returns a formatted summary of the patient's phone

    public String getContactSummary() {
        return "Patient: " + buildFullName() + "\n"
                + "Phone: " + phoneNumber + "\n"
                + "Emergency Contact: " + emergencyContactName + "\n"
                + "Emergency Phone: " + emergencyContactPhone;
    }

    //  Returns all patient information
    @Override
    public String toString() {
        return "Name: " + buildFullName() + "\n"
                + "Address: " + buildAddress() + "\n"
                + "Phone Number: " + phoneNumber + "\n"
                + "Emergency Contact: " + buildEmergencyContact();
    }
}

