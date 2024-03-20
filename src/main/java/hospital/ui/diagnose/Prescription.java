package hospital.ui.diagnose;

public class Prescription {

    public enum Medication {
        HYDRALAZINE(Administration.INTRAMUSCULAR),
        LABETALOL(Administration.ORAL),
        FENOLDOPAM(Administration.INTRAMUSCULAR),
        ATORVASTATIN(Administration.ORAL),
        EZETIMIBE(Administration.ORAL),
        ALIROCUMAB(Administration.SUBCUTANEOUS),
        ROCALTROL(Administration.ORAL),
        XPHOZAH(Administration.ORAL),
        RENVELA(Administration.ORAL),
        EPCLUSA(Administration.ORAL),
        MAVYRET(Administration.ORAL),
        ZEPATIER(Administration.ORAL),
        IBUPROFEN(Administration.ORAL),
        OXYCODONE(Administration.ORAL),
        PHYSICAL_THERAPY(Administration.EXERCISE);

        Medication(Administration method) {
        }
    }

    public enum Administration {
        INTRAVASCULAR,
        INTRAMUSCULAR,
        SUBCUTANEOUS,
        EXERCISE,
        ORAL
    }

    private boolean isPrescribed;
    private Medication medication;

    /**
     * Constructs a new Prescription object with the specified medication.
     *
     * @param medication The medication to prescribe.
     */
    public Prescription(Medication medication) {
        this.medication = medication;
        isPrescribed = false;
    }

    /**
     * Checks if the medication is prescribed.
     *
     * @return True if the medication is prescribed, false otherwise.
     */
    public boolean isPrescribed() {
        return isPrescribed;
    }

    /**
     * Sets the prescribed status of the medication.
     *
     * @param prescribed True if the medication is prescribed, false otherwise.
     */
    public void setPrescribed(boolean prescribed) {
        isPrescribed = prescribed;
    }

    /**
     * Gets the prescribed medication.
     *
     * @return The prescribed medication.
     */
    public Medication getMedication() {
        return medication;
    }

}
