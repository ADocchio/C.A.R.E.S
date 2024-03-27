package hospital.ui.database;

import hospital.ui.Main;
import hospital.ui.users.Person;
import hospital.ui.users.patients.Patient;
import hospital.ui.users.staff.*;

import java.io.*;
import java.util.Hashtable;
import java.util.Map;

public class Database
{
    private Hashtable<String, Patient> hashtable;
    private String filename;

    //private Objects made for hashtable databases
    private Hashtable<Object, Object> ht = new Hashtable<Object, Object>();
    private Hashtable<String, Person> personHt = new Hashtable<String, Person>();
    private Hashtable<String, Patient> patientTable = new Hashtable<String, Patient>();
    private Hashtable<String, Staff> loginTable = new Hashtable<String, Staff>();

    public Database ()
    {
       loginTable.put("Billing123", new BillingStaff("Doe", "John", "1/14/2000", "Somewhere Drive", "8908742222", "Billing", "123"));
       loginTable.put("Staff123", new EmergencyRoomStaff("Doe", "John", "1/14/2000", "Somewhere Drive", "8908742222", "Staff", "123" ));
       loginTable.put("Nurse123", new Nurse("Doe", "John", "1/14/2000", "Somewhere Drive", "8908742222", "Nurse", "123" ));
       loginTable.put("Doctor123", new Doctor("Doe", "John", "1/14/2000", "Somewhere Drive", "8908742222", "Doctor", "123" ));
       patientTable.put("D'OcchioAden03/05/2003", new Patient(new Person("D'Occhio", "Aden","03/05/2003", "16 Brian Woods dr", "8606900953"), "Blue Cross", "8602024502"));
       patientTable.put("D'OcchioJack03/05/2004", new Patient(new Person("D'Occhio", "Jack","03/05/2004", "16 Brian Woods dr", "8606900953"), "Blue Cross", "8602024502"));
    }

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
     * @return personHt A hashtable for all Person objects to be stored into
     */
    public Hashtable<String, Person> getPerHt()
    {
        return personHt;
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

    /**
     * Takes the inputted Person Hashtable and turns it into a binary file and stores it
     * under the inputted file name
     *
     * @param filename The name that the file will be stored under
     */
    public void storeDataToFilePer(String filename)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            oos.writeObject(hashtable);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Takes the inputted Patient Hashtable and turns it into a binary file and stores it
     * under the inputted file name
     *
     * @param filename The name that the file will be stored under
     */
    public void storeDataToFilePat(String filename)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            oos.writeObject(hashtable);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Takes the inputted file name and returns the Hashtable from the file by
     * reading it through ObjectIntputStream and FileOutputStream
     *
     * @param filename The name of the file that the hashtable is in
     * @return Hashtable<String, Object> The hashtable that is extracted from the file
     */
    public Hashtable<String, Object> grabStoredData(String filename)
    {
        Hashtable<String, Object> ht1 = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
        {
            ht1 = (Hashtable<String, Object>) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return ht1;
    }
}

