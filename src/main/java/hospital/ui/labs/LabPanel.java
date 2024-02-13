package hospital.ui.labs;

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

    private final Lab[] labs = {redBloodLab, whiteBloodLab, liverLab, renalLab, electrolyteLab, xrayLab, ctLab, mriLab, urineLab, stoolLab};

    public Lab.LabResult resetLab(int labNumber){
        labs[labNumber].reset();
        return labs[labNumber].getResult();
    }

    public Lab.LabResult runLab(int labNumber){
        labs[labNumber].run();
        return labs[labNumber].getResult();
    }


}
