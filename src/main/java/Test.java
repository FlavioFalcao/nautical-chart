import java.io.File;


public class Test {

	public static void main (String args[]) {
		System.out.println(String.valueOf(new File(Test.class.getClassLoader()..getResourceAsStream("configuration.properties")).exists()));
	}
}
