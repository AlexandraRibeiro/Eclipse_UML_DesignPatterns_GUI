package avaj_launcher;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		try {
			Lead lead = new Lead();
			lead.reader(args);
		}
		catch (MyExceptions e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
