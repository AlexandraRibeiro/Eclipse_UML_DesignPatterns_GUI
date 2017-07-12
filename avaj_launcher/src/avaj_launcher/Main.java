package avaj_launcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader buff = null;
		
		try {
			if (args.length == 1) {
				String sCurrentLine;
				buff = new BufferedReader(new FileReader(args[0]));
				Parser p = new Parser();
				
				while ((sCurrentLine = buff.readLine()) != null) {
					System.out.println(sCurrentLine); //debug
					
					// Parser.java ->regex?
					System.out.println(p.verifFirstLine(sCurrentLine));	
				}
			}
			else
				throw new MyExceptions("Error: args != 1");
		}
		catch (MyExceptions e) {
			System.out.println(e.getMessage());
			System.out.println("\n=> Leaving program now!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
