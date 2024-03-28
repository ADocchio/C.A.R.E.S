package hospital.ui.diagnose;

import java.io.Serializable;

/**
 * Represents a diagnosis with associated medical conditions.
 */
public class Diagnosis implements Serializable {

    private boolean[] isDiagnosed = {false, false, false, false, false};

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

    /**
     * Retrieves an array of conditions associated with this diagnosis.
     *
     * @return An array of conditions.
     */
    public Condition[] getConditions() {
        return new Condition[]{highBloodPressure, highCholesterol, kidneyDisease, liverDisease, brokenHumerus};
    }

    public boolean[] getIsDiagnosed(){
        return isDiagnosed;
    }

    public void setIsDiagnosed(boolean bool, int diagnosis){
        isDiagnosed[diagnosis] = bool;
    }
}
