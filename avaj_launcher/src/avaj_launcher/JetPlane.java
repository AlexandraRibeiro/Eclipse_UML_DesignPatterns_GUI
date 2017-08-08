package avaj_launcher;

public class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	
	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		String logJet = "JetPlane#" + name + "(" + Long.toString(id) + "): " + Tools.getLogAircrafts(weather);
		
		Tools.arrLogs.add(logJet);
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		String logJet = "Tower says: " + "JetPlane#" + name + "(" + Long.toString(id) + ") registered to weather tower.";
		this.weatherTower = weatherTower;
		this.weatherTower.register(this); //Tower.java
		
		Tools.arrLogs.add(logJet); //debug > put in file

	}

}
