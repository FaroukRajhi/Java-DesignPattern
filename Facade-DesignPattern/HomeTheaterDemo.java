// Subsystem Classes - Complex components
class Amplifier {
    private int volume = 10;
    
    public void on() {
        System.out.println("Amplifier is ON");
    }
    
    public void off() {
        System.out.println("Amplifier is OFF");
    }
    
    public void setVolume(int level) {
        this.volume = level;
        System.out.println("Amplifier volume set to " + level);
    }
    
    public void setSurroundSound() {
        System.out.println("Amplifier surround sound mode ON");
    }
}

class DVDPlayer {
    private String movie;
    
    public void on() {
        System.out.println("DVD Player is ON");
    }
    
    public void off() {
        System.out.println("DVD Player is OFF");
    }
    
    public void play(String movie) {
        this.movie = movie;
        System.out.println("Playing DVD: " + movie);
    }
    
    public void stop() {
        System.out.println("DVD stopped");
    }
    
    public void eject() {
        System.out.println("DVD ejected");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is ON");
    }
    
    public void off() {
        System.out.println("Projector is OFF");
    }
    
    public void wideScreenMode() {
        System.out.println("Projector in widescreen mode (16:9)");
    }
}

class TheaterLights {
    public void dim(int level) {
        System.out.println("Theater lights dimmed to " + level + "%");
    }
    
    public void on() {
        System.out.println("Theater lights ON");
    }
}

class Screen {
    public void down() {
        System.out.println("Screen lowered");
    }
    
    public void up() {
        System.out.println("Screen raised");
    }
}

class PopcornPopper {
    public void on() {
        System.out.println("Popcorn popper ON");
    }
    
    public void off() {
        System.out.println("Popcorn popper OFF");
    }
    
    public void pop() {
        System.out.println("Popping popcorn!");
    }
}

// Facade - Simplified interface
class HomeTheaterFacade {
    private Amplifier amp;
    private DVDPlayer dvd;
    private Projector projector;
    private TheaterLights lights;
    private Screen screen;
    private PopcornPopper popper;
    
    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector projector,
                            TheaterLights lights, Screen screen, PopcornPopper popper) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }
    
    // Simplified methods for watching movie
    public void watchMovie(String movie) {
        System.out.println("\n=== Getting ready to watch a movie ===");
        popper.on();
        popper.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setSurroundSound();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
        System.out.println("=== Movie is now playing ===\n");
    }
    
    // Simplified method to end movie
    public void endMovie() {
        System.out.println("\n=== Shutting down theater ===");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();
        System.out.println("=== Theater is ready for next use ===\n");
    }
}

// Client
public class HomeTheaterDemo {
    public static void main(String[] args) {
        // Create subsystem components
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        TheaterLights lights = new TheaterLights();
        Screen screen = new Screen();
        PopcornPopper popper = new PopcornPopper();
        
        // Create facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
            amp, dvd, projector, lights, screen, popper);
        
        // Use simplified interface
        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}
