// Implementation Hierarchy - Devices
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int percent);
    int getVolume();
    void setChannel(int channel);
    int getChannel();
    void printStatus();
}

// Concrete Implementations
class TV implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;
    
    @Override
    public void turnOn() {
        on = true;
        System.out.println("TV is now ON");
    }
    
    @Override
    public void turnOff() {
        on = false;
        System.out.println("TV is now OFF");
    }
    
    @Override
    public void setVolume(int percent) {
        volume = Math.max(0, Math.min(100, percent));
        System.out.println("TV volume set to " + volume + "%");
    }
    
    @Override
    public int getVolume() {
        return volume;
    }
    
    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("TV channel set to " + channel);
    }
    
    @Override
    public int getChannel() {
        return channel;
    }
    
    @Override
    public void printStatus() {
        System.out.println("TV Status - Power: " + (on ? "ON" : "OFF") + 
                         ", Volume: " + volume + "%, Channel: " + channel);
    }
}

class Radio implements Device {
    private boolean on = false;
    private int volume = 20;
    private int channel = 88; // FM frequency
    
    @Override
    public void turnOn() {
        on = true;
        System.out.println("Radio is now ON");
    }
    
    @Override
    public void turnOff() {
        on = false;
        System.out.println("Radio is now OFF");
    }
    
    @Override
    public void setVolume(int percent) {
        volume = Math.max(0, Math.min(100, percent));
        System.out.println("Radio volume set to " + volume + "%");
    }
    
    @Override
    public int getVolume() {
        return volume;
    }
    
    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("Radio frequency set to " + channel + " FM");
    }
    
    @Override
    public int getChannel() {
        return channel;
    }
    
    @Override
    public void printStatus() {
        System.out.println("Radio Status - Power: " + (on ? "ON" : "OFF") + 
                         ", Volume: " + volume + "%, Frequency: " + channel + " FM");
    }
}

class SmartSpeaker implements Device {
    private boolean on = false;
    private int volume = 40;
    private int channel = 1; // playlist number
    
    @Override
    public void turnOn() {
        on = true;
        System.out.println("Smart Speaker is now ON");
    }
    
    @Override
    public void turnOff() {
        on = false;
        System.out.println("Smart Speaker is now OFF");
    }
    
    @Override
    public void setVolume(int percent) {
        volume = Math.max(0, Math.min(100, percent));
        System.out.println("Smart Speaker volume set to " + volume + "%");
    }
    
    @Override
    public int getVolume() {
        return volume;
    }
    
    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("Smart Speaker playlist changed to #" + channel);
    }
    
    @Override
    public int getChannel() {
        return channel;
    }
    
    @Override
    public void printStatus() {
        System.out.println("Smart Speaker Status - Power: " + (on ? "ON" : "OFF") + 
                         ", Volume: " + volume + "%, Playlist: #" + channel);
    }
}

// Abstraction Hierarchy - Remote Controls
abstract class RemoteControl {
    protected Device device;
    
    public RemoteControl(Device device) {
        this.device = device;
    }
    
    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void volumeUp();
    public abstract void volumeDown();
    public abstract void channelUp();
    public abstract void channelDown();
}

class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }
    
    @Override
    public void turnOn() {
        device.turnOn();
    }
    
    @Override
    public void turnOff() {
        device.turnOff();
    }
    
    @Override
    public void volumeUp() {
        int volume = device.getVolume();
        device.setVolume(volume + 10);
    }
    
    @Override
    public void volumeDown() {
        int volume = device.getVolume();
        device.setVolume(volume - 10);
    }
    
    @Override
    public void channelUp() {
        int channel = device.getChannel();
        device.setChannel(channel + 1);
    }
    
    @Override
    public void channelDown() {
        int channel = device.getChannel();
        device.setChannel(channel - 1);
    }
}

class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }
    
    @Override
    public void turnOn() {
        device.turnOn();
    }
    
    @Override
    public void turnOff() {
        device.turnOff();
    }
    
    @Override
    public void volumeUp() {
        int volume = device.getVolume();
        device.setVolume(volume + 5);
    }
    
    @Override
    public void volumeDown() {
        int volume = device.getVolume();
        device.setVolume(volume - 5);
    }
    
    @Override
    public void channelUp() {
        int channel = device.getChannel();
        device.setChannel(channel + 1);
    }
    
    @Override
    public void channelDown() {
        int channel = device.getChannel();
        device.setChannel(channel - 1);
    }
    
    // Additional features
    public void mute() {
        device.setVolume(0);
        System.out.println("Device muted");
    }
    
    public void setVolumeExact(int volume) {
        device.setVolume(volume);
    }
}

class VoiceRemote extends RemoteControl {
    public VoiceRemote(Device device) {
        super(device);
    }
    
    @Override
    public void turnOn() {
        System.out.println("Voice command: Turn on");
        device.turnOn();
    }
    
    @Override
    public void turnOff() {
        System.out.println("Voice command: Turn off");
        device.turnOff();
    }
    
    @Override
    public void volumeUp() {
        System.out.println("Voice command: Volume up");
        int volume = device.getVolume();
        device.setVolume(volume + 10);
    }
    
    @Override
    public void volumeDown() {
        System.out.println("Voice command: Volume down");
        int volume = device.getVolume();
        device.setVolume(volume - 10);
    }
    
    @Override
    public void channelUp() {
        System.out.println("Voice command: Next channel");
        int channel = device.getChannel();
        device.setChannel(channel + 1);
    }
    
    @Override
    public void channelDown() {
        System.out.println("Voice command: Previous channel");
        int channel = device.getChannel();
        device.setChannel(channel - 1);
    }
    
    public void voiceCommand(String command) {
        System.out.println("Voice command received: " + command);
        // Parse and execute voice commands
        if (command.toLowerCase().contains("play playlist")) {
            int playlistNum = Integer.parseInt(command.replaceAll("[^0-9]", ""));
            device.setChannel(playlistNum);
        }
    }
}

// Client
public class BridgePatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Bridge Pattern: Remote Controls ===\n");
        
        // Test with TV and Basic Remote
        Device tv = new TV();
        RemoteControl basicRemote = new BasicRemote(tv);
        System.out.println("--- TV with Basic Remote ---");
        basicRemote.turnOn();
        basicRemote.volumeUp();
        basicRemote.channelUp();
        tv.printStatus();
        
        // Test with Radio and Advanced Remote
        Device radio = new Radio();
        AdvancedRemote advancedRemote = new AdvancedRemote(radio);
        System.out.println("\n--- Radio with Advanced Remote ---");
        advancedRemote.turnOn();
        advancedRemote.volumeUp();
        advancedRemote.channelDown();
        advancedRemote.mute();
        radio.printStatus();
        
        // Test with Smart Speaker and Voice Remote
        Device speaker = new SmartSpeaker();
        VoiceRemote voiceRemote = new VoiceRemote(speaker);
        System.out.println("\n--- Smart Speaker with Voice Remote ---");
        voiceRemote.turnOn();
        voiceRemote.volumeUp();
        voiceRemote.voiceCommand("play playlist 5");
        speaker.printStatus();
        
        // Demonstrate flexibility: Switch device for same remote
        System.out.println("\n--- Same Advanced Remote controlling different devices ---");
        Device newTV = new TV();
        AdvancedRemote universalRemote = new AdvancedRemote(newTV);
        universalRemote.turnOn();
        universalRemote.setVolumeExact(45);
        newTV.printStatus();
        
        // Switch to radio
        Device newRadio = new Radio();
        universalRemote = new AdvancedRemote(newRadio);
        universalRemote.turnOn();
        universalRemote.setVolumeExact(30);
        newRadio.printStatus();
    }
}
