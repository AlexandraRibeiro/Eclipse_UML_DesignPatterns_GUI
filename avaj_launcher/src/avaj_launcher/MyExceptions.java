package avaj_launcher;

public class MyExceptions extends Exception {
	public MyExceptions(String message) {
		super(Tools.RED + message + Tools.RESET);
	}
	
	static final long serialVersionUID = 1L; //assign a long value
}
