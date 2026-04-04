// Command Interface
interface Command {
    void execute();
    void undo();
    String getName();
}

// Receiver Classes
class Light {
    private String location;
    private boolean isOn;
    
    public Light(String location) {
        this.location = location;
        this.isOn = false;
    }
    
    public void turnOn() {
        isOn = true;
        System.out.println(location + " light is ON");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println(location + " light is OFF");
    }
    
    public boolean isOn() {
        return isOn;
    }
}

class Stereo {
    private int volume;
    private boolean isOn;
    
    public void on() {
        isOn = true;
        System.out.println("Stereo is ON");
    }
    
    public void off() {
        isOn = false;
        System.out.println("Stereo is OFF");
    }
    
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Stereo volume set to " + volume);
    }
    
    public void setCD() {
        System.out.println("Stereo set to CD mode");
    }
}

class CeilingFan {
    private String location;
    private int speed;
    public static final int OFF = 0;
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int HIGH = 3;
    
    public CeilingFan(String location) {
        this.location = location;
        this.speed = OFF;
    }
    
    public void low() {
        speed = LOW;
        System.out.println(location + " ceiling fan on LOW");
    }
    
    public void medium() {
        speed = MEDIUM;
        System.out.println(location + " ceiling fan on MEDIUM");
    }
    
    public void high() {
        speed = HIGH;
        System.out.println(location + " ceiling fan on HIGH");
    }
    
    public void off() {
        speed = OFF;
        System.out.println(location + " ceiling fan is OFF");
    }
    
    public int getSpeed() {
        return speed;
    }
}

// Concrete Commands
class LightOnCommand implements Command {
    private Light light;
    
    public LightOnCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.turnOn();
    }
    
    @Override
    public void undo() {
        light.turnOff();
    }
    
    @Override
    public String getName() {
        return "Light On";
    }
}

class LightOffCommand implements Command {
    private Light light;
    
    public LightOffCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.turnOff();
    }
    
    @Override
    public void undo() {
        light.turnOn();
    }
    
    @Override
    public String getName() {
        return "Light Off";
    }
}

class StereoOnWithCDCommand implements Command {
    private Stereo stereo;
    
    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }
    
    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
    
    @Override
    public void undo() {
        stereo.off();
    }
    
    @Override
    public String getName() {
        return "Stereo On with CD";
    }
}

class CeilingFanHighCommand implements Command {
    private CeilingFan fan;
    private int previousSpeed;
    
    public CeilingFanHighCommand(CeilingFan fan) {
        this.fan = fan;
    }
    
    @Override
    public void execute() {
        previousSpeed = fan.getSpeed();
        fan.high();
    }
    
    @Override
    public void undo() {
        switch (previousSpeed) {
            case CeilingFan.HIGH: fan.high(); break;
            case CeilingFan.MEDIUM: fan.medium(); break;
            case CeilingFan.LOW: fan.low(); break;
            default: fan.off(); break;
        }
    }
    
    @Override
    public String getName() {
        return "Fan High";
    }
}

// NoCommand for null object pattern
class NoCommand implements Command {
    @Override
    public void execute() {}
    @Override
    public void undo() {}
    @Override
    public String getName() { return "No Command"; }
}

// Invoker - Remote Control
class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand;
    
    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }
    
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }
    
    public void onButtonPressed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }
    
    public void offButtonPressed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }
    
    public void undoButtonPressed() {
        System.out.print("Undo: ");
        undoCommand.undo();
    }
    
    public void display() {
        System.out.println("\n------ Remote Control -------");
        for (int i = 0; i < onCommands.length; i++) {
            System.out.println("[slot " + i + "] " + onCommands[i].getName() + 
                             "    " + offCommands[i].getName());
        }
        System.out.println("[undo] " + undoCommand.getName());
    }
}

// Client
public class SmartHomeAutomation {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        
        // Create receivers
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        Stereo stereo = new Stereo();
        CeilingFan fan = new CeilingFan("Living Room");
        
        // Create commands
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);
        Command stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        Command fanHigh = new CeilingFanHighCommand(fan);
        
        // Set commands to remote slots
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);
        remote.setCommand(2, stereoOnWithCD, new NoCommand());
        remote.setCommand(3, fanHigh, new NoCommand());
        
        remote.display();
        
        // Test the remote
        System.out.println("\n--- Testing Remote Control ---");
        remote.onButtonPressed(0);
        remote.offButtonPressed(0);
        remote.undoButtonPressed();
        
        remote.onButtonPressed(1);
        remote.undoButtonPressed();
        
        remote.onButtonPressed(2);
        remote.undoButtonPressed();
        
        remote.onButtonPressed(3);
        remote.undoButtonPressed();
    }
}
