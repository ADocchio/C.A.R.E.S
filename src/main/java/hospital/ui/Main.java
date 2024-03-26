package hospital.ui;

import hospital.ui.labs.LabPanel;
import hospital.ui.users.Person;
import hospital.ui.users.patients.Patient;
import hospital.ui.database.Database;

import static hospital.ui.database.Database.*;


public class   Main {

    public static Patient currentPatient = new Patient(new Person("Jack", "Docchio", "05/08/2005", "16 Brian Woods Drive", "8606900953"));

    public static Database pHt;

    public static void main(String[] args) {
        InterfaceLoad.startApp();
        pHt = new Database(getCurrentPatient());
        pHt.storeDataToFilePat("file");

//        pHt.grabStoredData("file");
    }

    public static Patient getCurrentPatient(){
        return currentPatient;
    }
}
