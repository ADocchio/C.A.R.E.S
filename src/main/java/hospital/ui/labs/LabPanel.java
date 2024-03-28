package hospital.ui.labs;

import java.io.Serializable;

public class LabPanel implements Serializable {

    private final Lab redBloodLab = new Lab("Red Blood Cell", 100.0);
    private final Lab whiteBloodLab = new Lab("White Blood Cell", 100.0);
    private final Lab liverLab = new Lab("Liver Function",100.0);
    private final Lab renalLab = new Lab("Renal Function",100.0);
    private final Lab electrolyteLab = new Lab("Electrolyte Levels",100.0);

    private final Lab xrayLab = new Lab("X-Ray",100.0);
    private final Lab ctLab = new Lab("C.T. Scan",100.0);
    private final Lab mriLab = new Lab("MRI",100.0);

    private final Lab urineLab = new Lab("Urine Test",100.0);
    private final Lab stoolLab = new Lab("Stool Test",100.0);

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

    public Lab[] getLabs() {
        return labPanel;
    }
}
