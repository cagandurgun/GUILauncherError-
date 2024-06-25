/*
 * This code was written by Çağan Durgun.
 */

package error;

import javax.swing.*;

/**
 * This class throws an error as a PopUp on the screen.
 * <p>
 * It is <strong>mandatory</strong> to use the
 * <strong>{@link GUILauncherError#exitProtocol()}</strong>
 * method at the end of the <strong>main()</strong> method in
 * the project where it will be used! Usage information is
 * explained in the relevant method.
 */
public class GUILauncherError extends Exception {

    /**
     * Constructor to create an error message.
     */
    public GUILauncherError(String message) {
        super(message);
    }

    /**
     * Constructor for the exit protocol.
     */
    public GUILauncherError() {
        super("");
    }

    /**
     * This method must be used within the main method of the
     * program for it to terminate properly.
     * <p><strong>Usage:</strong>
     * <pre>{@code
     *      public class Main {
     *          public static void main(String[] args) {
     *
     *              new GUILauncherError().exitProtocol();
     *          }
     *      }
     * }</pre>
     * <p>
     * as shown.
     */
    public void exitProtocol() {
        System.exit(0);
    }

    /**
     * If the user wants to see the error.
     */
    @Override
    public void printStackTrace() {
        new GUI(getMessage()).errorPopUp();
    }

    /**
     * Graphical User Interface (GUI)
     */
    private static class GUI extends JFrame {
        private final String message;

        public GUI(String message) {
            this.message = message;
        }

        private void errorPopUp() {
            if (message.isEmpty()) {
                JOptionPane.showMessageDialog(this, message, "No Error Message!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, message, "GUI Error!", JOptionPane.INFORMATION_MESSAGE);
            }

            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (frame != null) {
                frame.dispose();
            }
        }
    }
}
