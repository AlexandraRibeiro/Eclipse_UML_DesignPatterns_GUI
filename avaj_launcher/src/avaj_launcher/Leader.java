package avaj_launcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leader {
	
	public int nb_cycle;
	public int nb_aircraft;
	private String[] sArrayLine;
	private Parser p;
	BufferedReader buff = null;
	
	public void reader(String[] args) throws IOException, MyExceptions {

		if (args.length == 1) {
			String sCurrentLine;
			try {
				buff = new BufferedReader(new FileReader(args[0]));
			}
			catch (Exception e) {
				throw new MyExceptions("\n=> Error : '" + args[0] + "' no such file or directory");
			}
			
			p = new Parser();
			nb_aircraft = -1;

			while ((sCurrentLine = buff.readLine()) != null) {
				System.out.println(sCurrentLine); //debug
				if (nb_aircraft == -1) {
					nb_cycle = p.verifFirstLine(sCurrentLine);
					verifCycle();
				}
				else
					verifRegex(sCurrentLine);
				nb_aircraft++;
			}		
	
			if (nb_aircraft == -1)
				throw new MyExceptions("\n=> Error : empty file");
			else {
				int i = 0;
				WeatherTower wt = new WeatherTower();
				while (i < nb_aircraft) {
					
				}
			}
		}
		else
			throw new MyExceptions("\n=> Error : arguments, args != 1");
	}
	
	private void verifCycle() throws MyExceptions {
		if (nb_cycle == 0)
			throw new MyExceptions("\n=> Error : not enough cycles, cycle = 0");
		else if (nb_cycle > 255)
			throw new MyExceptions("\n=> Error : too much cycles, cycle > 255");
		else if (nb_cycle < 0)
			throw new MyExceptions("\n=> Error : the value of the cycles is negative");
	}
	
	private void verifRegex(String sCurrentLine) throws MyExceptions {
		if (p.regex(sCurrentLine) == false)
			throw new MyExceptions("\n=> Error (regex) : line " + (nb_aircraft + 2)); //error regex
		else {
			System.out.println("-> ok regex"); // debug
			sArrayLine = sCurrentLine.split(" ");
			readType();
		}
	}
	
	private void readType() throws MyExceptions {
		if (p.parserVerifTypes(sArrayLine[0]) == false) {
			throw new MyExceptions("\n=> Error (parser) : '" + sArrayLine[0] + "' unknown type, line " + (nb_aircraft + 2)); //error Type
		}
		else {
			System.out.println("-> ok Type"); //debug
			readName();
		}
	}
	
	
	private void readName() throws MyExceptions {
		if (p.parserVerifName(sArrayLine[1], sArrayLine[0]) == false) {
			throw new MyExceptions("\n=> Error (parser) : '" + sArrayLine[1] + "' wrong Name, line " + (nb_aircraft + 2)); //error ID
		}
		else {
			System.out.println("-> ok Name"); //debug
			readHeight();
		}
	}
	
	private void readHeight() throws MyExceptions {
		if (p.parserVerifHeight(sArrayLine[1], sArrayLine[4]) == false) {
			sArrayLine[4] = "100";
			System.out.println("-> ok Height = 100"); //debug
		}
		else if (Integer.parseInt(sArrayLine[4]) == 0) {
			nb_aircraft --;
			System.out.println("-> ok this aircraft landed, no need to register"); //debug
		}
		else
			System.out.println("-> ok Height"); //debug
	}

	
	
}
