// Simple Factory


public class VehicleFactory
{
	public Vehicle createVehicle(String type)
	{
		if(type == null) return null;

		switch(type.toLowerCase())
		{
			case "car":
				return new Car();
			case "bike":
				return new Bike();
			default:
				throw new IllegalArgumentException("Unknown vehicle type");
		}
	}
}
