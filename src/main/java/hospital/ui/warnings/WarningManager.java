package hospital.ui.warnings;

import java.util.ArrayList;

public class WarningManager {
    private static final WarningManager instance = new WarningManager();
    private final ArrayList<WarningListener> listeners = new ArrayList<>();

    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private WarningManager() {}

    /**
     * Returns the singleton instance of WarningManager.
     * @return The singleton instance.
     */
    public static WarningManager getInstance() {
        return instance;
    }

    /**
     * Registers a listener to receive warning messages.
     * @param listener The listener to register.
     */
    public void addListener(WarningListener listener) {
        listeners.add(listener);
    }

    /**
     * Unregisters a previously registered listener.
     * @param listener The listener to unregister.
     */
    public void removeListener(WarningListener listener) {
        listeners.remove(listener);
    }

    /**
     * Broadcasts a warning message to all registered listeners.
     * @param message The warning message to broadcast.
     */
    public void showWarningToAll(String message) {
        for (WarningListener listener : listeners) {
            listener.showWarning(message);
        }
    }
}

