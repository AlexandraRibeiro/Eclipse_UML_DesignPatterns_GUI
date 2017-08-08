package avaj_launcher;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	
	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	
	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		String logHelicopter = "Helicopter#" + name + "(" + Long.toString(id) + "): " + Tools.getLogAircrafts(weather);
		
		Tools.arrLogs.add(logHelicopter);
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		String logHelicopter = "Tower says: " + "Helicopter#" + name + "(" + Long.toString(id) + ") registered to weather tower.";
		this.weatherTower = weatherTower;
		this.weatherTower.register(this); //Tower.java
		
		Tools.arrLogs.add(logHelicopter);

	}

}
