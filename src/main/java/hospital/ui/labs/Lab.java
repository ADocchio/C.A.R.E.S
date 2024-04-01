package hospital.ui.labs;

import java.io.Serializable;
import java.util.Random;


/**
 * Represents a laboratory test within a medical application. This class encapsulates
 * details about the lab test, including its name, cost, the number of times it has been
 * run, and the result of the test.
 */
public class Lab implements Serializable {

    /**
     * Enumerates possible results of a laboratory test. A test can either not have been
     * run yet, have a normal result, or have an abnormal result.
     */
    public enum LabResult implements Serializable {
        NotRun,
        Normal,
        Abnormal
    }

    private final Random random = new Random();
    private LabResult result;
    private final String name;
    private int timesRun;
    private final double cost;

    /**
     * Constructs a new Lab instance with the specified name and base cost.
     * The test is initialized in the NotRun state.
     *
     * @param name The name of the laboratory test.
     * @param cost The base cost of performing the laboratory test once.
     */
    public Lab(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.result = LabResult.NotRun;
        this.timesRun = 0;
    }

    /**
     * Gets the base cost of the lab test.
     *
     * @return The base cost of performing the test once.
     */
    public double getBaseCost() {
        return cost;
    }

    /**
     * Calculates the total cost of the lab test based on the number of times it has been run.
     *
     * @return The total cost incurred for all runs of the test.
     */
    public double getTotalCost() {
        return cost * timesRun;
    }

    /**
     * Gets the name of the lab test.
     *
     * @return The name of the laboratory test.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of times the lab test has been run.
     *
     * @return The number of times the test has been performed.
     */
    public int getTimesRun() {
        return timesRun;
    }

    /**
     * Gets the current result of the laboratory test.
     *
     * @return The result of the lab test, which can be NotRun, Normal, or Abnormal.
     */
    public LabResult getResult() {
        return result;
    }

    /**
     * Resets the laboratory test to its initial state, setting the result to NotRun.
     */
    public void reset() {
        result = LabResult.NotRun;
    }

    /**
     * Simulates running the laboratory test, updating its state and result.
     * There is a 1/6 chance that the test result will be set to Abnormal; otherwise,
     * it will be set to Normal. Increments the counter for the number of times the test
     * has been run.
     */
    public void run() {
        int num = random.nextInt(6);
        timesRun++;

        if (num == 0) {
            result = LabResult.Abnormal;
        } else {
            result = LabResult.Normal;
        }
    }
}
