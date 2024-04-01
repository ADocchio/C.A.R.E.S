package hospital.ui.users.staff;

import java.io.Serializable;

/**
 * Represents a billing staff member, specializing the {@link Staff} class for billing operations.
 * This class is designed to manage billing staff members, extending the generic
 * functionalities provided by the {@code Staff} class.
 */
public class BillingStaff extends Staff implements Serializable {

    /**
     * Constructs a new {@code BillingStaff} instance with specified personal details and login credentials.
     *
     * @param firstName The first name of the billing staff member.
     * @param lastName  The last name of the billing staff member.
     * @param dob       The date of birth of the billing staff member.
     * @param permAdd   The permanent address of the billing staff member.
     * @param phoneNum  The phone number of the billing staff member.
     * @param username  The username for the billing staff member's login credentials.
     * @param password  The password for the billing staff member's login credentials.
     */
    public BillingStaff(String firstName, String lastName, String dob, String permAdd, String phoneNum,
                        String username, String password) {
        super(firstName, lastName, dob, permAdd, phoneNum, username, password);
    }
}

