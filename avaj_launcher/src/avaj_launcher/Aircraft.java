package avaj_launcher;

public abstract class Aircraft {
	protected long id;
	
	protected String name;
	
	protected Coordinates coordinates;
	
	private static long idCounter;
	

	protected Aircraft(String name, Coordinates coordinates){
		this.id = nextId();
		this.name = name;
		this.coordinates = coordinates;
	}
	
	private long nextId(){
		idCounter++;
		return idCounter;
	}
}
