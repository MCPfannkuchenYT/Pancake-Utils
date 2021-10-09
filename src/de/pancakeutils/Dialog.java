package de.pancakeutils;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * All Dialog-UI based Utils
 * @author Pancake
 */
public final class Dialog {

	/**
	 * Tries to change the Look And Feel of any swing window to the
	 * standard System Look And Feel.
	 * @throws Exception Unable to change Look And Feel
	 */
	public static final void enableSystemStyle() throws Exception {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (final ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			throw new Exception("Unable to change ui look and feel", e);
		}
	}
	
	/**
	 * Opens a User Input Prompt and requires the User to enter something
	 * @param message Message to prompt
	 * @param defaultValue Default Value for text field
	 * @return User Input as String
	 * @throws Exception No User Input
	 */
	public static final String askForUserInput(final String message, final String defaultValue) throws Exception {
		if (defaultValue == null) throw new RuntimeException("No default value given.");
		final String userIn = JOptionPane.showInputDialog(null, message, defaultValue);
		if (userIn == null) throw new Exception("No user input.");
		if (userIn.isEmpty()) throw new Exception("No user input.");
		return userIn;
	}
	
}
