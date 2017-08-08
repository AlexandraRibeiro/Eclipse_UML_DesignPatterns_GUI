package avaj_launcher;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	
	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	
	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		String logBaloon;
		
		coordinates = Tools.changeCoordinates(coordinates, weather, "Baloon");
		int height = coordinates.getHeight();
		if (height < 1)
		{
			weatherTower.unregister(this);
			logBaloon = "Baloon#" + name + "(" + Long.toString(id) + "): " + Tools.getLogAircrafts(weather) + '\n' 
					+ "Baloon#" + name + "(" + Long.toString(id) + ") landing.\n"
					+ "Tower says: " + "Baloon#" + name + "(" + Long.toString(id) + ") unregistered from weather tower.";
		}
		else
			logBaloon = "Baloon#" + name + "(" + Long.toString(id) + "): " + Tools.getLogAircrafts(weather);
		
		Tools.arrLogs.add(logBaloon);
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		String logBaloon = "Tower says: " + "Baloon#" + name + "(" + Long.toString(id) + ") registered to weather tower.";
		this.weatherTower = weatherTower;
		this.weatherTower.register(this); //Tower.java
		
		Tools.arrLogs.add(logBaloon); //debug > put in file
	}

}
