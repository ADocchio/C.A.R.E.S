package hospital.ui.users.patients;

/**
 * Represents an operation that updates a {@code Patient} object using a {@code String} value.
 * Implementations of this interface can modify various aspects of a {@code Patient} based on
 * the provided value, allowing for dynamic updates at runtime.
 */
public interface PatientUpdater {

    /**
     * Applies an update to the given {@code Patient} object using the specified {@code String} value.
     * The nature of the update is determined by the implementation of this method.
     * @param patient The {@code Patient} object to be updated. This parameter must not be {@code null}.
     * @param value A {@code String} value used to update the patient. The meaning and format of this
     *              value depend on the implementation.
     */
    void apply(Patient patient, String value);
}
