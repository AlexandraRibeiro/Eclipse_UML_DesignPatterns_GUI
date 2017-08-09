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
	
	public boolean regex(String sLine) {
		String reg = "^[A-Z][a-zA-Z]+[ ][A-Z][0-9]+[ ][0-9]{1,3}[ ][0-9]{1,3}[ ][0-9]{1,3}$";
		 return (sLine.matches(reg));
	}
	
	public boolean parserVerifTypes(String sTypes) {
		int i = 0;
		while (i < Tools.arrAircrafts.length)
		{
			if (	sTypes.equals(Tools.arrAircrafts[i]) == true)
				return true;
			i++;
		}
		return false;
	}
	
	public boolean parserVerifName(String sID, String sTypes) {
		if (sID.charAt(0) == sTypes.charAt(0)) {
			if (Tools.arrID.isEmpty() == true || Tools.arrID.contains(sID) == false) {
				Tools.arrID.add(sID);
				return true;
			}
		}
		return false;
	}
	
	public boolean parserVerifHeight(String sID, String sHeight) {
		int height = Integer.parseInt(sHeight);
		if (height > 100)
			return false;
		else if (height == 0) // this aircraft landed, no need to register
			Tools.arrID.remove(sID);
		return true;
	}
}
