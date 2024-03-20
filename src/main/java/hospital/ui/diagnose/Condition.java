package hospital.ui.diagnose;

public class Condition {
    private Prescription[] validPrescriptions = new Prescription[3];

    /**
     * Constructs a new Condition object with the specified name and valid prescriptions.
     *
     * @param p1   The first valid prescription.
     * @param p2   The second valid prescription.
     * @param p3   The third valid prescription.
     */
    public Condition(Prescription p1, Prescription p2, Prescription p3) {

        validPrescriptions[0] = p1;
        validPrescriptions[1] = p2;
        validPrescriptions[2] = p3;
    }

    /**
     * Gets the valid prescriptions for this medical condition.
     *
     * @return An array containing the valid prescriptions.
     */
    public Prescription[] getValidPrescriptions() {
        return validPrescriptions;
    }

    /**
     * Sets the valid prescriptions for this medical condition.
     *
     * @param validPrescriptions An array containing the valid prescriptions to set.
     */
    public void setValidPrescriptions(Prescription[] validPrescriptions) {
        this.validPrescriptions = validPrescriptions;
    }
}