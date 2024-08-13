import java.util.Scanner;

public class UI{

	private static UI instance;
	Scanner scan;
	private UI(){
		scan = new Scanner(System.in);
	}

	public static synchronized UI getInstance(){
		if(instance==null)
			instance=new UI();
		return instance;
	}

	public static synchronized void print(String s) {
		System.out.println(s);
	}

	public String read()  {


		String in  = scan.nextLine();
		return in;

	}
}