package hospital.database;

import hospital.ui;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

public class Database
{
    //private Objects made for hashtable databases
    private Hashtable ht = new Hashtable<Object, Object>;
    private Hashtable personHt = new Hashtable<String, Person>;
    private Hashtable patientHt = new Hashtable<String, Patient>;

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
     * Takes the inputted Hashtable and turns it into a binary file and stores it
     * under the inputted file name
     *
     * @param Hashtable<String, Object> A hashtable to store into the file
     * @param filename The name that the file will be stored under
     */
    public static void storeDataToFile(Hashtable<String, Object>, filename)
    {
      try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
      {
        oos.writeObject(Hashtable);
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
    public static Hashtable<String, Object> grabStoredData(filename)
    {
      Hashtable<String, Object> ht1 = null;
      try (ObjectIntputStream ois = new ObjectIntputStream(new FileOutputStream(filename)))
      {
        ht1 = (Hashtable<String, Object>) ois.readObject();
      }
      catch (IOException | ClassNotFoundException e)
      {
        e.printStackTrace
      }
      return ht1;
    }
}
