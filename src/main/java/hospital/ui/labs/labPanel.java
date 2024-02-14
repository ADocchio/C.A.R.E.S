package hospital.ui.labs;

public class labPanel {

    private final lab redBloodLab = new lab();
    private final lab whiteBloodLab = new lab();
    private final lab liverLab = new lab();
    private final lab renalLab = new lab();
    private final lab electrolyteLab = new lab();

    private final lab xrayLab = new lab();
    private final lab ctLab = new lab();
    private final lab mriLab = new lab();

    private final lab urineLab = new lab();
    private final lab stoolLab = new lab();

    private final lab[] labPanel = {redBloodLab, whiteBloodLab, liverLab, renalLab, electrolyteLab, xrayLab, ctLab, mriLab, urineLab, stoolLab};

    /** resets a lab on the lab panel based on lab number
     *
     * @param labNumber, lab on panel to be reset
     * @return State of the lab reset so NotRun
     */
    public lab.LabResult resetLab(int labNumber){
        labPanel[labNumber].reset();
        return labPanel[labNumber].getResult();
    }

    /** Runs a lab on the lab panel
     *
     * @param labNumber, lab on panel to run
     * @return result of the run lab
     */
    public lab.LabResult runLab(int labNumber){
        labPanel[labNumber].run();
        return labPanel[labNumber].getResult();
    }


}
