package hospital.ui;

public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private String insurance;
    private String phoneNumber;
    private Person emergencyContact;
    private String role;
    private String id;
    private double weight;
    private double height;
    private int bpm;

    // Constructor
    public Person(String firstName, String lastName, String address, String insurance, String phoneNumber,
                  Person emergencyContact, String role, String id, double weight, double height, int bpm) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.insurance = insurance;
        this.phoneNumber = phoneNumber;
        this.emergencyContact = emergencyContact;
        this.role = role;
        this.id = id;
        this.weight = weight;
        this.height = height;
        this.bpm = bpm;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(Person emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    // Additional methods like toString(), equals(), and hashCode() can be added as needed
}

