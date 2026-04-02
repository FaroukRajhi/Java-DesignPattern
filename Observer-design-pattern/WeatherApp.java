import java.util.ArrayList;
import java.util.List;
// Step 1: Observer Interface
interface WeatherObserver {
    void update(float temperature, float humidity, float pressure);
}

// Step 2: Subject Interface
interface WeatherSubject {
    void registerObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObservers();
}

// Step 3: Concrete Subject (The Weather Station)
class WeatherStation implements WeatherSubject {
    private List<WeatherObserver> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    
    public WeatherStation() {
        observers = new ArrayList<>();
    }
    
    @Override
    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
        System.out.println("New display device connected!");
    }
    
    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
        System.out.println("Display device disconnected!");
    }
    
    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
    
    // This method gets called when weather changes
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    
    private void measurementsChanged() {
        notifyObservers(); // Automatically notify all displays
    }
}

// Step 4: Concrete Observers (Different Displays)
class PhoneDisplay implements WeatherObserver {
    private String phoneName;
    
    public PhoneDisplay(String name) {
        this.phoneName = name;
    }
    
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println(phoneName + " Display - Temp: " + temperature 
                         + "°C, Humidity: " + humidity + "%, Pressure: " + pressure + " hPa");
    }
}

class TVDisplay implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("📺 TV WEATHER: " + temperature + "°C | "
                         + humidity + "% humidity | " + pressure + " hPa");
    }
}

class LEDBoard implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        if (temperature > 30) {
            System.out.println("🔴 LED BOARD: HEAT WARNING! " + temperature + "°C");
        } else {
            System.out.println("🟢 LED BOARD: Normal weather, " + temperature + "°C");
        }
    }
}

// Step 5: Demo the Pattern
public class WeatherApp {
    public static void main(String[] args) {
        // Create the subject (Weather Station)
        WeatherStation weatherStation = new WeatherStation();
        
        // Create observers (Different displays)
        PhoneDisplay iphone = new PhoneDisplay("iPhone");
        PhoneDisplay samsung = new PhoneDisplay("Samsung");
        TVDisplay tv = new TVDisplay();
        LEDBoard led = new LEDBoard();
        
        // Register observers (Subscribe)
        weatherStation.registerObserver(iphone);
        weatherStation.registerObserver(samsung);
        weatherStation.registerObserver(tv);
        weatherStation.registerObserver(led);
        
        System.out.println("\n--- Weather Update 1 ---");
        weatherStation.setMeasurements(25.5f, 65.0f, 1013.0f);
        
        System.out.println("\n--- Weather Update 2 (Heat Wave!) ---");
        weatherStation.setMeasurements(35.0f, 45.0f, 1008.0f);
        
        // Remove an observer (Unsubscribe)
        weatherStation.removeObserver(tv);
        
        System.out.println("\n--- Weather Update 3 (TV disconnected) ---");
        weatherStation.setMeasurements(28.0f, 70.0f, 1015.0f);
    }
}