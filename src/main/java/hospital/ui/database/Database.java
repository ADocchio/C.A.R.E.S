package hospital.ui.database;

import hospital.ui.Main;
import hospital.ui.users.Person;
import hospital.ui.users.patients.Patient;
import hospital.ui.users.staff.*;

import java.io.*;
import java.util.Hashtable;
import java.util.Map;

public class Database implements Serializable
{
    private static String patientDataFile = "PatientData";
    private static String loginDataFile = "LoginData";

    //private Objects made for hashtable databases
    private Hashtable<String, Patient> patientTable = new Hashtable<String, Patient>();
    private Hashtable<String, Staff> loginTable = new Hashtable<String, Staff>();

    public Database () {}

    /**
     * Gets the hashtable
     *
     * @return ht A hashtable for any preliminary data storage
     */
    public Hashtable<String, Staff> getLoginTable()
    {
        return loginTable;
    }

    /**
     * Gets the Person hashtable
     *
     * @return patientHt A hashtable for all Patient objects to be stored into
     */
    public Hashtable<String, Patient> getPatientTable()
    {
        return patientTable;
    }

    public void updateKey(String oldkey, String newKey){
        Patient patient = patientTable.remove(oldkey);
        if(!patientTable.containsKey(newKey)){
            patientTable.put(newKey, patient);
        }
        //warning
    }

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







