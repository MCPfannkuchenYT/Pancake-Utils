import de.pancakeutils.Objects;

public class TestObjects {

	public static void main(String[] args) {
		/* TEST Objects.isNullCheck */
		System.out.print("Checking Objects.isNullCheck");
		boolean isNotNull = Objects.isNullCheck(true, "not-null", "", 12, 5.0F, 255.234D, 12512312983701L);
		boolean isNull = Objects.isNullCheck("hello", null);
		if (!isNotNull && isNull) 
			System.out.println(" - Check passed");
		else 
			System.err.println(" - Check failed, expected false + true but got " + isNotNull + " + " + isNull);
		System.out.println("-------------------------------");
	}
	
}
