package avaj_launcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Leader {
	
	public int nb_cycle;
	public int nb_aircraft;
	private String[] sArrayLine;
	private ArrayList<String> arrAllLines = new ArrayList<String>();
	private Parser p;
	public boolean landed = false;
	BufferedReader buff = null;
	
	public void reader(String[] args) throws IOException, MyExceptions, NoSuchAlgorithmException {
		if (args.length == 1) {
			String sCurrentLine;
			try {
				buff = new BufferedReader(new FileReader(args[0]));
			}
			catch (Exception e) {
				throw new MyExceptions("\n=> Error : '" + args[0] + "' no such file or directory");
			}


			
			// Parser ______________________________________________________________________________
			p = new Parser();
			nb_aircraft = -1;

			while ((sCurrentLine = buff.readLine()) != null) {
				landed = false;
				
				if (nb_aircraft == -1) {
					nb_cycle = p.verifFirstLine(sCurrentLine);
					verifCycle();
				}
				else
					verifRegex(sCurrentLine);
				nb_aircraft++;
				if (landed == true)
					arrAllLines.remove(sCurrentLine);
			}
	
			if (nb_aircraft == -1)
				throw new MyExceptions("\n=> Error : empty file");
			else if (nb_aircraft == 0)
				throw new MyExceptions("\n=> All aircrafts landed");
			else {
				
				/* MD5 generator > File ok ___________________________________*/
				if (Tools.generateMD5 == true) {
					new GenerateMD5(arrAllLines, args[0], nb_cycle);
					return;
				}
				/* ___________________________________________________________*/
				
				int i = 0;
				while (i < arrAllLines.size()) {
					System.out.println(arrAllLines.get(i));
					i++;
				}
				i = 0;
				WeatherTower wt = new WeatherTower();
				
				// Create Aircraft & register tower _______________________________________________
				while (i < nb_aircraft) {
					sArrayLine = arrAllLines.get(i).split(" ");
					Flyable flyable = AircraftFactory.newAircraft(sArrayLine[0],
																sArrayLine[1],
																Integer.parseInt(sArrayLine[2]),
																Integer.parseInt(sArrayLine[3]),
																Integer.parseInt(sArrayLine[4]));
					flyable.registerTower(wt);
					i++;
				}
				
				// Change weather with cycles ______________________________________________________
				i = 0;
				while (i < nb_cycle)
				{
					wt.changeWeather();
					i++;
				}
				
				/* Test MD5 -> enlever throw NoSuchAlgorithmException */
				String hash1 = "5B86C55E8E0EFEC9A65584CB31D1B324";
				Crypted crypted = new Crypted();
				String hash2 = crypted.cryptedStr("Baloon B2");
				System.out.println("\n** Test MD5 :" + crypted.verifHashs(hash1, hash2));
				
				// Generate a file simulation.txt___________________________________________________
				Path sim = Paths.get("simulation.txt");
				Files.write(sim, Tools.arrLogs);
			}
		}
		else
			throw new MyExceptions("\n=> Error : arguments, args != 1");
	}
	
	
	/* FOR PARSER ********************************************************************************/
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
			arrAllLines.add(sCurrentLine); //stock all Lines for params new Flyable
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
			landed = true;
		}
		else
			System.out.println("-> ok Height"); //debug
	}
	/* *******************************************************************************************/
	
}
