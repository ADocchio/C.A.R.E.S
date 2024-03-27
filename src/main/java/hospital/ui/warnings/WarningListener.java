package hospital.ui.warnings;

/**
 * Interface for listening to warning messages.
 * Implement this interface to handle the display of warning messages in the UI.
 */
public interface WarningListener {
    /**
     * Display a warning message.
     * @param message The warning message to be displayed.
     */
    void showWarning(String message);
}
