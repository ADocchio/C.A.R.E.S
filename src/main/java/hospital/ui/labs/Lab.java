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
    private LabResult result = LabResult.NotRun;

    public Lab(){}

    public LabResult getResult() {
        return result;
    }

    public void reset() {
        result = LabResult.NotRun;
    }

    public void run(){
        int num = random.nextInt(0,2);

        switch (num) {
            case 0 -> result = Lab.LabResult.Abnormal;
            case 1 -> result = Lab.LabResult.Normal;
        }
    }



}
