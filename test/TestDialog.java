import de.pancakeutils.Dialog;

public class TestDialog {

	public static void main(String[] args) {
		/* TEST Dialog.enableSystemStyle */
		System.out.print("Checking Dialog.enableSystemStyle");
		try {
			Dialog.enableSystemStyle();
			System.out.println(" - Check passed, successfully changed to system style");
		} catch (Exception e) {
			if ("Unable to change ui look and feel".equals(e.getMessage())) {
				System.out.println(" - Check passed, could not switch to system style");
			} else {
				System.out.println(" - Check failed, unknown error message");
				e.printStackTrace();
				return;
			}
		}
		/* TEST Dialog.askForUserInput */
		System.out.print("Checking Dialog.askForUserInput");
		try {
			Dialog.askForUserInput(null, null);
			System.out.println(" - Check failed");
		} catch (RuntimeException e) {
			System.out.println(" - Check passed");
		} catch (Exception e) {
			System.out.println(" - Check failed, unknown error");
			e.printStackTrace();
		}
		System.out.println("-------------------------------");
	}
	
}
