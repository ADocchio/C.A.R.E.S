package hospital.ui.labs;

import java.util.ArrayList;
import java.util.List;

public class LabPanel {

    private final Lab redBloodLab = new Lab();
    private final Lab whiteBloodLab = new Lab();
    private final Lab liverLab = new Lab();
    private final Lab renalLab = new Lab();
    private final Lab electrolyteLab = new Lab();

    private final Lab xrayLab = new Lab();
    private final Lab ctLab = new Lab();
    private final Lab mriLab = new Lab();

    private final Lab urineLab = new Lab();
    private final Lab stoolLab = new Lab();

    private final Lab[] labPanel = {redBloodLab, whiteBloodLab, liverLab, renalLab, electrolyteLab, xrayLab, ctLab, mriLab, urineLab, stoolLab};

    /** resets a lab on the lab panel based on lab number
     *
     * @param labNumber, lab on panel to be reset
     * @return State of the lab reset so NotRun
     */
    public Lab.LabResult resetLab(int labNumber){
        labPanel[labNumber].reset();
        return labPanel[labNumber].getResult();
    }

    /** Runs a lab on the lab panel
     *
     * @param labNumber, lab on panel to run
     * @return result of the run lab
     */
    public Lab.LabResult runLab(int labNumber){
        labPanel[labNumber].run();
        return labPanel[labNumber].getResult();
    }

    public String[] getCurrentResults(){
        String[] results = new String[10];
        for(int i = 0; i < results.length; i++) {
            results[i] = labPanel[i].getResult().name();
        }

        return results;
    }
}
