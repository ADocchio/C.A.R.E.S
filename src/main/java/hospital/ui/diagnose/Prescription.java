package hospital.ui.diagnose;

import java.io.Serializable;

/**
 * Represents a medical prescription within a hospital's diagnosis system.
 * This class encapsulates information about a prescribed medication, including
 * its type and whether it has been officially prescribed.
 */
public class Prescription implements Serializable {

    /**
     * Enumerates various medications along with their respective administration methods.
     * This enumeration facilitates tracking of how medications should be administered
     * to patients.
     */
    public enum Medication implements Serializable {
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

        private final Administration administrationMethod;

        /**
         * Constructs a Medication enum with the specified administration method.
         *
         * @param method The administration method for the medication.
         */
        Medication(Administration method) {
            this.administrationMethod = method;
        }

        /**
         * Retrieves the administration method for the medication.
         *
         * @return The administration method of the medication.
         */
        public Administration getAdministrationMethod() {
            return administrationMethod;
        }
    }

    /**
     * Enumerates the various methods by which medications can be administered
     * to patients, including oral, intramuscular, subcutaneous, and through exercise.
     */
    public enum Administration implements Serializable {
        INTRAVASCULAR,
        INTRAMUSCULAR,
        SUBCUTANEOUS,
        EXERCISE,
        ORAL
    }

    private boolean isPrescribed;
    private final Medication medication;

    /**
     * Constructs a new Prescription object for the specified medication.
     * The prescription status is initialized to false, indicating it has not been prescribed yet.
     *
     * @param medication The medication to be associated with this prescription.
     */
    public Prescription(Medication medication) {
        this.medication = medication;
        isPrescribed = false;
    }

    /**
     * Determines whether the medication has been prescribed.
     *
     * @return True if the medication is prescribed, otherwise false.
     */
    public boolean isPrescribed() {
        return isPrescribed;
    }

    /**
     * Sets the prescribed status of this prescription.
     *
     * @param prescribed True to indicate the medication is prescribed, false otherwise.
     */
    public void setPrescribed(boolean prescribed) {
        isPrescribed = prescribed;
    }

    /**
     * Retrieves the medication associated with this prescription.
     *
     * @return The medication of this prescription.
     */
    public Medication getMedication() {
        return medication;
    }
}