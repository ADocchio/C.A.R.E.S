package hospital.ui.diagnose;

public class Diagnosis {
    public enum Administration {
        INTRAVASCULAR,
        INTRAMUSCULAR,
        SUBCUTANEOUS,
        PHYSICAL_THERAPY,
        ORAL
    }

    public enum Prescription {
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
        OXYCODONE(Administration.PHYSICAL_THERAPY);

        Prescription(Administration method) {
        }
    }

    Prescription[] prescriptions = {};
    String instructions = "";

    /**
     * Sets the prescriptions for the diagnosis.
     * @param prescriptions The array of prescriptions.
     */
    public void setPrescriptions(Prescription[] prescriptions) {
        this.prescriptions = prescriptions;
    }

    /**
     * Gets the prescriptions associated with the diagnosis.
     * @return The array of prescriptions.
     */
    public Prescription[] getPrescriptions() {
        return prescriptions;
    }

    /**
     * Sets the instructions for the diagnosis.
     * @param instructions The instructions for the diagnosis.
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    /**
     * Gets the instructions associated with the diagnosis.
     * @return The instructions for the diagnosis.
     */
    public String getInstructions() {
        return instructions;
    }

}
