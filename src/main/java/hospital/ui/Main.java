package hospital.ui;

import hospital.ui.users.patients.Patient;
import hospital.ui.database.Database;

public class   Main {

    public static Database database = new Database();

    public static void main(String[] args) {
        InterfaceLoad.startApp();
//        pHt.grabStoredData("file");
    }
}
