package hospital.ui.labs;

import java.util.Random;

public class Lab {

    public enum LabResult {
        NotRun,
        Normal,
        Abnormal
    }

    private enum LabType {
        redBloodCell(100.00),
        whiteBloodCell(100.00),
        liverFunction(100.00),
        renalFunction(100.00),
        electrolyte(100.00),

        xRay(100.00),
        ctScan(100.00),
        mri(100.00),

        urine(100.00),
        stool(100.00);

        LabType(double cost) {
        }
    }

    private final Random random = new Random();
    private LabResult result;
    private int timeRun = 0;

    /** Constructor
     *
     */
    public Lab(){
        result = LabResult.NotRun;
    }

    /** Returns the result of the lab class
     *
     * @return result of the lab, type: LabResult
     */
    public LabResult getResult() {
        return result;
    }

    /** Resets the lab state to NotRun
     *
     */
    public void reset() {
        result = LabResult.NotRun;
    }

    /** Runs the lab and sets its value with a 1/6 chance of being Abnormal
     *
     */
    public void run(){
        int num = random.nextInt(0,6);
        timeRun++;

        if (num == 0){
            result = LabResult.Abnormal;
        } else {
            result = LabResult.Normal;
        }
    }
}
