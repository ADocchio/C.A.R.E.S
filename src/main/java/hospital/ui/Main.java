package hospital.ui;

import hospital.ui.labs.LabPanel;
import hospital.ui.users.Person;
import hospital.ui.users.patients.Patient;
import hospital.ui.database.Database;

public class   Main {

    public static Patient currentPatient = new Patient(new Person("Jack", "Docchio", "05/08/2005", "16 Brian Woods Drive", "8606900953"));

    public static void main(String[] args) {
        InterfaceLoad.startApp();
        Database pHt = new Database(currentPatient);
        pHt.storeDataToFilePat("file");
    }

    public static Patient getCurrentPatient(){
        return currentPatient;
    }
}
