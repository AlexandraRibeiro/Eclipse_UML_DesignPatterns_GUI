package avaj_launcher;

public class Parser {
	
	public int verifFirstLine(String sLine) throws MyExceptions {
		try {
			int cycle = Integer.parseInt(sLine);
			return cycle;
		}
		catch (Exception e) {
			throw new MyExceptions("\n=> Error : first line not an integer");
		}
	}
	
	public void verifLines(String sLine) {
		
	}
	
}
