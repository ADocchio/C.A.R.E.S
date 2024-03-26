package hospital.ui.database;

import hospital.ui.users.Person;
import hospital.ui.users.patients.Patient;

import java.io.*;
import java.util.Hashtable;
import java.util.Map;

public class Database<k, v> extends Hashtable<k, v>
{
    private static Hashtable<String, Patient> hashtable;
    private static String filename;
    //private Objects made for hashtable databases
    private Hashtable<Object, Object> ht = new Hashtable<Object, Object>();
    private Hashtable<String, Person> personHt = new Hashtable<String, Person>();
    private Hashtable<String, Patient> patientHt = new Hashtable<String, Patient>();

    public Database ()
    {
        super();
    }
    public Database (Person p)
    {
        super();
        this.personHt = new Hashtable<String, Person>();
        this.personHt.put("1", p);
    }

    public Database(Patient p)
    {
        super();
        this.patientHt = new Hashtable<String, Patient>();
        this.patientHt.put("1", p);
    }

    /**
     * Gets the hashtable
     *
     * @return ht A hashtable for any preliminary data storage
     */
    public Hashtable<Object, Object> getHT()
    {
        return ht;
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
    public Hashtable<String, Patient> getPaHt()
    {
        return patientHt;
    }

    /**
     * Takes the inputted Person Hashtable and turns it into a binary file and stores it
     * under the inputted file name
     *
     * @param filename The name that the file will be stored under
     */
    public static void storeDataToFilePer(String filename)
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
    public static void storeDataToFilePat(String filename)
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
    public static Hashtable<String, Object> grabStoredData(String filename)
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

