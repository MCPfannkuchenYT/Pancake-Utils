package de.pancakeutils;

/**
 * All Object-Reference based Utils
 * @author Pancake
 */
public class Objects {

	/**
	 * Checks whether a given array of Objects is null
	 * @param <T> Type of Object to check
	 * @param obj All Objects for the Check
	 * @return Whether any of the objects are null
	 */
	@SafeVarargs
	public static final <T> boolean isNullCheck(final T... obj) {
		for (int i = 0; i < obj.length; i++) {
			if (obj[i] == null) return true;
		}
		return false;
	}
	
}
