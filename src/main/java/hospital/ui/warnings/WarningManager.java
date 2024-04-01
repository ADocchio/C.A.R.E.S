package hospital.ui.warnings;

import java.util.ArrayList;

/**
 * Manages warning messages within the application,
 * This class is responsible for registering warning listeners, removing them, and broadcasting
 * warning messages to all registered listeners.
 */
public class WarningManager {
    private static final WarningManager instance = new WarningManager();
    private final ArrayList<WarningListener> listeners = new ArrayList<>();

    /**
     * Private constructor to prevent instantiation from outside the class.
     * This is a key aspect of the Singleton pattern, ensuring that {@code WarningManager}
     * cannot be instantiated externally.
     */
    private WarningManager() {}

    /**
     * Returns the singleton instance of {@code WarningManager}.
     *
     * @return The singleton instance of {@code WarningManager}.
     */
    public static WarningManager getInstance() {
        return instance;
    }

    /**
     * Registers a listener to receive warning messages. This method allows for the dynamic
     * addition of components or modules that should be notified when a warning occurs within
     * the application.
     *
     * @param listener The {@code WarningListener} to register.
     */
    public void addListener(WarningListener listener) {
        listeners.add(listener);
    }

    /**
     * Unregisters a previously registered listener. If the specified listener is registered,
     * it will no longer receive warning messages after being removed.
     *
     * @param listener The {@code WarningListener} to unregister.
     */
    public void removeListener(WarningListener listener) {
        listeners.remove(listener);
    }

    /**
     * Broadcasts a warning message to all registered listeners. Each listener registered with
     * this {@code WarningManager} will have its {@code showWarning} method called, passing the
     * message along to it.
     *
     * @param message The warning message to broadcast.
     */
    public void showWarningToAll(String message) {
        for (WarningListener listener : listeners) {
            listener.showWarning(message);
        }
    }
}

