// Product class - The complex object to be built
public class Computer {
    // Required parameters
    private final String cpu;
    private final String ram;
    
    // Optional parameters
    private final String storage;
    private final String graphicsCard;
    private final boolean bluetooth;
    private final boolean wifi;
    private final String operatingSystem;
    
    // Private constructor - only Builder can create Computer objects
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.bluetooth = builder.bluetooth;
        this.wifi = builder.wifi;
        this.operatingSystem = builder.operatingSystem;
    }
    
    // Getters for all fields
    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public String getGraphicsCard() { return graphicsCard; }
    public boolean hasBluetooth() { return bluetooth; }
    public boolean hasWifi() { return wifi; }
    public String getOperatingSystem() { return operatingSystem; }
    
    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", bluetooth=" + bluetooth +
                ", wifi=" + wifi +
                ", operatingSystem='" + operatingSystem + '\'' +
                '}';
    }
    
    // Static nested Builder class
    public static class Builder {
        // Required parameters
        private final String cpu;
        private final String ram;
        
        // Optional parameters - initialized to default values
        private String storage = "256GB SSD";
        private String graphicsCard = "Integrated";
        private boolean bluetooth = false;
        private boolean wifi = true;
        private String operatingSystem = "Windows 11";
        
        // Builder constructor with required parameters
        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }
        
        // Builder methods for optional parameters
        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }
        
        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }
        
        public Builder bluetooth(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }
        
        public Builder wifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }
        
        public Builder operatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }
        
        // Build method that creates the Computer object
        public Computer build() {
            // Validation can be added here
            if (cpu == null || ram == null) {
                throw new IllegalArgumentException("CPU and RAM are required");
            }
            return new Computer(this);
        }
    }
}
