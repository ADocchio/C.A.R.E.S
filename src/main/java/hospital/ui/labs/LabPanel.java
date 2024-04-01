package hospital.ui.labs;

import java.io.Serializable;


/**
 * Represents a collection of laboratory tests, often referred to as a lab panel,
 * within a medical diagnostic application. This class encapsulates various types of
 * lab tests, including blood tests, imaging tests (X-Ray, C.T. Scan, MRI), and others
 * like urine and stool tests, each with a fixed cost.
 */
public class LabPanel implements Serializable {

    private final Lab redBloodLab = new Lab("Red Blood Cell", 100.0);
    private final Lab whiteBloodLab = new Lab("White Blood Cell", 100.0);
    private final Lab liverLab = new Lab("Liver Function", 100.0);
    private final Lab renalLab = new Lab("Renal Function", 100.0);
    private final Lab electrolyteLab = new Lab("Electrolyte Levels", 100.0);
    private final Lab xrayLab = new Lab("X-Ray", 100.0);
    private final Lab ctLab = new Lab("C.T. Scan", 100.0);
    private final Lab mriLab = new Lab("MRI", 100.0);
    private final Lab urineLab = new Lab("Urine Test", 100.0);
    private final Lab stoolLab = new Lab("Stool Test", 100.0);
    private final Lab[] labPanel = {redBloodLab, whiteBloodLab, liverLab, renalLab, electrolyteLab, xrayLab, ctLab, mriLab, urineLab, stoolLab};

    /**
     * Resets a specific lab test in the lab panel to its initial state, indicating
     * that the test has not been run. This method is useful for reinitializing a lab
     * test before running it again.
     *
     * @param labNumber The index of the lab in the lab panel to reset, based on its
     *                  position in the array of labs.
     * @return The LabResult indicating the reset state of the lab, typically LabResult.NotRun.
     */
    public Lab.LabResult resetLab(int labNumber) {
        labPanel[labNumber].reset();
        return labPanel[labNumber].getResult();
    }

    /**
     * Runs a specific lab test in the lab panel, updating its state to either Normal
     * or Abnormal based on a random chance defined in the Lab class. This method
     * simulates performing the lab test and automatically updates its result.
     *
     * @param labNumber The index of the lab in the lab panel to run.
     * @return The result of the lab test after running it, either LabResult.Normal or LabResult.Abnormal.
     */
    public Lab.LabResult runLab(int labNumber) {
        labPanel[labNumber].run();
        return labPanel[labNumber].getResult();
    }

    /**
     * Retrieves the current results of all lab tests in the panel. This method
     * is useful for quickly assessing the outcomes of all tests within the panel.
     *
     * @return An array of strings representing the results of each lab test in the panel.
     */
    public String[] getCurrentResults() {
        String[] results = new String[labPanel.length];
        for (int i = 0; i < labPanel.length; i++) {
            results[i] = labPanel[i].getResult().name();
        }

        return results;
    }

    /**
     * Provides access to the array of lab tests within the panel. This method can
     * be used to perform more detailed operations on individual lab tests or to
     * examine their properties.
     *
     * @return An array of Lab objects representing all the lab tests in the panel.
     */
    public Lab[] getLabs() {
        return labPanel;
    }
}