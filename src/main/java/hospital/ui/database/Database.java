package hospital.ui.database;

import hospital.ui.users.patients.Patient;
import hospital.ui.users.staff.*;
import hospital.ui.warnings.WarningManager;

import java.io.*;
import java.util.Hashtable;
import java.util.Objects;


/**
 * Represents a database for managing patient and staff information in a medical context.
 * This class provides functionality to load, save, and update patient and staff data using hash tables.
 * It supports serializing the data to files and deserializing it back into the application.
 */
public class Database implements Serializable
{
    private static String patientDataFile = "PatientData";
    private static String loginDataFile = "LoginData";

    //private Objects made for hashtable databases
    private Hashtable<String, Patient> patientTable = new Hashtable<String, Patient>();
    private Hashtable<String, Staff> loginTable = new Hashtable<String, Staff>();

    public Database () {}

    /**
     * Retrieves the hashtable containing staff login data.
     *
     * @return A hashtable mapping staff IDs to {@link Staff} objects.
     */
    public Hashtable<String, Staff> getLoginTable()
    {
        return loginTable;
    }

    /**
     * Retrieves the hashtable containing patient data.
     *
     * @return A hashtable mapping patient IDs to {@link Patient} objects.
     */
    public Hashtable<String, Patient> getPatientTable()
    {
        return patientTable;
    }

    /**
     * Updates the key associated with a specific patient in the patient hashtable.
     * If the new key does not exist in the hashtable, the patient's data is updated to use the new key.
     *
     * @param oldKey The current key associated with the patient's data.
     * @param newKey The new key to associate with the patient's data.
     */
    public void updateKey(String oldKey, String newKey){
        Patient patient = patientTable.remove(oldKey);
        if(!patientTable.containsKey(newKey)){
            patientTable.put(newKey, patient);
        } else if (!Objects.equals(oldKey, newKey)) {
            WarningManager.getInstance().showWarningToAll("There is already a patient with this information in the system ");
        }

    }

    /**
     * Saves the current state of the database (both patient and staff data) to files.
     * This method serializes the loginTable and patientTable hashtables to their respective files.
     */
    public void saveDatabase() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(loginDataFile))) {
            oos.writeObject(loginTable);
        } catch (IOException e) {
            System.out.println("Error saving hashtable: " + e.getMessage());
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(patientDataFile))) {
            oos.writeObject(patientTable);
        } catch (IOException e) {
            System.out.println("Error saving hashtable: " + e.getMessage());
        }
    }

    /**
     * Loads the database state (both patient and staff data) from files.
     * This method deserializes the loginTable and patientTable hashtables from their respective files.
     * If the files do not exist, it initializes the tables with default data.
     */
    @SuppressWarnings("unchecked")
    public void loadDataBase() {
        File file = new File(loginDataFile);
        if (!file.exists()) {
            // File doesn't exist, create a new hashtable
            loginTable = new Hashtable<>();
            loginTable.put("Billing123", new BillingStaff("Doe", "John", "1/14/2000", "Somewhere Drive", "8908742222", "Billing", "123"));
            loginTable.put("Staff123", new EmergencyRoomStaff("Doe", "John", "1/14/2000", "Somewhere Drive", "8908742222", "Staff", "123" ));
            loginTable.put("Nurse123", new Nurse("Doe", "John", "1/14/2000", "Somewhere Drive", "8908742222", "Nurse", "123" ));
            loginTable.put("Doctor123", new Doctor("Doe", "John", "1/14/2000", "Somewhere Drive", "8908742222", "Doctor", "123" ));
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loginDataFile))) {
            loginTable = (Hashtable<String, Staff>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Database file not found, creating a new one.");
            loginTable = new Hashtable<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading hashtable: " + e.getMessage());
        }

        file = new File(patientDataFile);
        if (!file.exists()) {
            // File doesn't exist, create a new hashtable
            patientTable = new Hashtable<>();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(patientDataFile))) {
            patientTable = (Hashtable<String, Patient>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Database file not found, creating a new one.");
            patientTable = new Hashtable<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading hashtable: " + e.getMessage());
        }
    }
}







