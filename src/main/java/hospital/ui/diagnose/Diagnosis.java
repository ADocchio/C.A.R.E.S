package hospital.ui.diagnose;

import java.io.Serializable;

/**
 * Represents a diagnosis with associated medical conditions.
 */
public class Diagnosis implements Serializable {

    private final boolean[] isDiagnosed = {false, false, false, false, false};

    private Condition highBloodPressure = new Condition(
            new Prescription(Prescription.Medication.HYDRALAZINE),
            new Prescription(Prescription.Medication.LABETALOL),
            new Prescription(Prescription.Medication.FENOLDOPAM));

    private Condition highCholesterol = new Condition(
            new Prescription(Prescription.Medication.ATORVASTATIN),
            new Prescription(Prescription.Medication.EZETIMIBE),
            new Prescription(Prescription.Medication.ALIROCUMAB));

    private Condition kidneyDisease = new Condition(
            new Prescription(Prescription.Medication.ROCALTROL),
            new Prescription(Prescription.Medication.XPHOZAH),
            new Prescription(Prescription.Medication.RENVELA));

    private Condition liverDisease = new Condition(
            new Prescription(Prescription.Medication.EPCLUSA),
            new Prescription(Prescription.Medication.MAVYRET),
            new Prescription(Prescription.Medication.ZEPATIER));

    private Condition brokenHumerus = new Condition(
            new Prescription(Prescription.Medication.IBUPROFEN),
            new Prescription(Prescription.Medication.OXYCODONE),
            new Prescription(Prescription.Medication.PHYSICAL_THERAPY));

    private final Condition[] conditions = {highBloodPressure, highCholesterol, kidneyDisease, liverDisease, brokenHumerus};

    /**
     * Retrieves an array of {@link Condition} objects associated with this diagnosis.
     * This method provides direct access to the internal array storing the conditions.
     * Each {@link Condition} in the array represents a specific medical condition, such as
     * high blood pressure, high cholesterol, kidney disease, liver disease, or a broken humerus.
     *
     * @return A direct reference to the internal array of {@code Condition} objects. Modifications
     *         to this array will affect the object's internal state.
     */
    public Condition[] getConditions() {
        return conditions;
    }

    /**
     * Retrieves the diagnosis status for all conditions.
     *
     * This method returns an array of boolean values where each element
     * represents the diagnosis status of a specific condition. True indicates
     * that the diagnosis for that condition is positive (diagnosed), and false
     * indicates it is negative (not diagnosed).
     *
     * @return An array of boolean values indicating the diagnosis status for each condition.
     */
    public boolean[] getIsDiagnosed() {
        return isDiagnosed;
    }

    /**
     * Sets the diagnosis status for a specific condition.
     *
     * This method updates the diagnosis status of a specific condition
     * based on the provided index and status. The index corresponds to
     * the condition being diagnosed, and the status indicates whether the
     * condition is diagnosed (true) or not (false).
     *
     * @param bool The diagnosis status to set for the specified condition.
     *             True for diagnosed, false for not diagnosed.
     * @param diagnosis The index of the condition whose diagnosis status
     *                  is to be updated. This should be within the bounds
     *                  of the array holding the diagnosis statuses.
     */
    public void setIsDiagnosed(boolean bool, int diagnosis) {
        isDiagnosed[diagnosis] = bool;
    }
}
