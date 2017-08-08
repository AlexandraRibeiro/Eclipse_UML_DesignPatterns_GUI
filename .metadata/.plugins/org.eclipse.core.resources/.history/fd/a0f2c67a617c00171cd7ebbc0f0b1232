package avaj_launcher;

public abstract class AircraftFactory {

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
		Flyable f = null;
		Coordinates coord = new Coordinates(longitude, latitude, height);
		
		if (type.equals("JetPlane")){
			//System.out.printf("\t type : >%s<   name : >%s<\n", type, name);
			f = new JetPlane(name, coord );
		}
		else if (type.equals("Helicopter")){
			//System.out.printf("\t type : >%s<   name : >%s<\n", type, name);
			f = new Helicopter(name, coord );
		}
		else if(type.equals("Baloon")){
			//System.out.printf("\t type : >%s<   name : >%s<\n", type, name);
			f = new Baloon(name, coord );
		}
		else {
			f = new Others(type, name, coord );
		}

		return f;		
	}
	
}
