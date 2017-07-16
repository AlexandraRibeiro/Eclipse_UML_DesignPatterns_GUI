package avaj_launcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leader {
	
	public int nb_cycle;
	public int nb_aircraft;
	BufferedReader buff = null;
	
	public void reader(String[] args) throws IOException, MyExceptions {
	
		if (args.length == 1) {
			String sCurrentLine;
			buff = new BufferedReader(new FileReader(args[0]));
			Parser p = new Parser();
			nb_aircraft = -1;

			while ((sCurrentLine = buff.readLine()) != null) {
				System.out.println(sCurrentLine); //debug

				if (nb_aircraft == -1) {
					nb_cycle = p.verifFirstLine(sCurrentLine);
					System.out.println(nb_cycle); // debug
					if (nb_cycle == 0)
						throw new MyExceptions("\n=> Error : not enough cycle, cycle = 0");
					else if (nb_cycle > 255)
						throw new MyExceptions("\n=> Error : too much cycle, cycle > 255");
					else if (nb_cycle < 0)
						throw new MyExceptions("\n=> Error : error value cycle, cycle < 0");
				}
				else
					p.verifLines(sCurrentLine); //regex lines
				nb_aircraft++;
			}
		}
		else {
			throw new MyExceptions("\n=> Error : arguments, args != 1");
		}
		
	}
	
}
