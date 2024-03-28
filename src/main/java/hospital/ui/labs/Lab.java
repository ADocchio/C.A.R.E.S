package hospital.ui.labs;

import java.io.Serializable;
import java.util.Random;

public class Lab implements Serializable {

    public enum LabResult implements Serializable {
        NotRun,
        Normal,
        Abnormal
    }

    private final Random random = new Random();
    private LabResult result;
    private String name;
    private int timesRun = 0;
    private double cost = 0;

    /** Constructor
     *
     */
    public Lab(String name, double cost){
        this.name = name;
        result = LabResult.NotRun;
        this.cost = cost;

    }

    public double getBaseCost() { return cost; }

    public double getTotalCost() { return cost * timesRun; }

    public String getName(){ return name; }

    public int getTimesRun() { return timesRun; }

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
        timesRun++;

        if (num == 0){
            result = LabResult.Abnormal;
        } else {
            result = LabResult.Normal;
        }
    }
}
