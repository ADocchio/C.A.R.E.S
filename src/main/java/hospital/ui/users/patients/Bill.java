package hospital.ui.users.patients;

public class Bill {
    private Patient patient;
    private String contents;

    /**
     * Constructs a Bill object with the specified patient and contents.
     * @param patient The patient associated with the bill.
     * @param contents The contents of the bill.
     */
    public Bill(Patient patient, String contents) {
        this.patient = patient;
        this.contents = contents;
    }

    /**
     * Retrieves a string representation of the bill.
     * @return The bill contents as a string.
     */
    public String seeBill() {
        return contents;
    }

    // Getters and setters

    /**
     * Gets the patient associated with the bill.
     * @return The patient object.
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Sets the patient associated with the bill.
     * @param patient The patient object.
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Gets the contents of the bill.
     * @return The contents of the bill.
     */
    public String getContents() {
        return contents;
    }

    /**
     * Sets the contents of the bill.
     * @param contents The contents of the bill.
     */
    public void setContents(String contents) {
        this.contents = contents;
    }
}

