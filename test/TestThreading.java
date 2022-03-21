import de.pancakeutils.Threading;

public class TestThreading {

	public static void main(String[] args) {
		/* TEST Threading.sleep */
		System.out.print("Checking Threading.sleep");
		try {
			if (!Threading.sleep(100))
				throw new Exception("Sleep was interrupted!");
			System.out.println(" - Check passed");
		} catch (Exception e) {
			System.out.println(" - Check failed");
		}
		/* TEST Threading.sleep */
		System.out.print("Checking Threading.runSafe");
		try {
			if (Threading.runSafe(() -> { return false; } ))
				throw new Exception("The result of the runnable was not returned properly");
			if (Threading.runSafe(() -> { throw new Exception(); } ))
				throw new Exception("The exception of the runnable was not caught properly");
			System.out.println(" - Check passed");
		} catch (Exception e) {
			System.out.println(" - Check failed");
		}
		/* TEST Threading.multithreadTask */
		System.out.print("Checking Threading.multithreadTask");
		try {
			System.out.print(" - ");
			Threading.multithreadTask(i -> System.out.print(i + " "), 12, 1000);
			System.out.println("- Check passed");
		} catch (Exception e) {
			System.out.println(" - Check failed");
		}
		System.out.println("-------------------------------");
	}
	
}
