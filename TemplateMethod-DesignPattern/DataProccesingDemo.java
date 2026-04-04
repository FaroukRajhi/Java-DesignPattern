// Abstract Class with Template Method
abstract class DataProcessor {
    
    // Template method - defines algorithm skeleton
    public final void process() {
        loadData();
        validateData();
        processData();
        saveData();
        cleanup();
    }
    
    // Primitive operations - must be implemented by subclasses
    protected abstract void loadData();
    protected abstract void processData();
    protected abstract void saveData();
    
    // Common implementation (can be overridden)
    protected void validateData() {
        System.out.println("Validating data...");
        System.out.println("Data validation passed");
    }
    
    // Hook method - optional override
    protected void cleanup() {
        System.out.println("Performing cleanup...");
    }
}

// Concrete Class 1: CSV Data Processor
class CSVProcessor extends DataProcessor {
    private String fileName;
    
    public CSVProcessor(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    protected void loadData() {
        System.out.println("Loading CSV file: " + fileName);
        System.out.println("Parsing CSV format...");
    }
    
    @Override
    protected void processData() {
        System.out.println("Processing CSV data...");
        System.out.println("Calculating statistics from CSV...");
    }
    
    @Override
    protected void saveData() {
        System.out.println("Saving processed CSV data to database");
    }
    
    @Override
    protected void cleanup() {
        System.out.println("Closing CSV file handles");
        System.out.println("Releasing memory");
    }
}

// Concrete Class 2: XML Data Processor
class XMLProcessor extends DataProcessor {
    private String xmlFile;
    
    public XMLProcessor(String xmlFile) {
        this.xmlFile = xmlFile;
    }
    
    @Override
    protected void loadData() {
        System.out.println("Loading XML file: " + xmlFile);
        System.out.println("Parsing XML with XPath...");
    }
    
    @Override
    protected void processData() {
        System.out.println("Processing XML data...");
        System.out.println("Extracting nodes and transforming...");
    }
    
    @Override
    protected void saveData() {
        System.out.println("Saving XML data to NoSQL database");
    }
    
    // Override validation for XML-specific validation
    @Override
    protected void validateData() {
        System.out.println("Validating XML against schema...");
        System.out.println("XML validation passed");
    }
}

// Concrete Class 3: JSON Data Processor
class JSONProcessor extends DataProcessor {
    private String jsonData;
    
    public JSONProcessor(String jsonData) {
        this.jsonData = jsonData;
    }
    
    @Override
    protected void loadData() {
        System.out.println("Loading JSON data from API...");
        System.out.println("Parsing JSON structure...");
    }
    
    @Override
    protected void processData() {
        System.out.println("Processing JSON data...");
        System.out.println("Mapping to objects and filtering...");
    }
    
    @Override
    protected void saveData() {
        System.out.println("Saving JSON data to cache...");
    }
    
    // No need to override cleanup - uses default
}

// Client
public class DataProcessingDemo {
    public static void main(String[] args) {
        System.out.println("=== Template Method: Data Processing ===\n");
        
        // Process CSV
        System.out.println("--- Processing CSV File ---");
        DataProcessor csvProcessor = new CSVProcessor("data.csv");
        csvProcessor.process();
        
        System.out.println("\n--- Processing XML File ---");
        DataProcessor xmlProcessor = new XMLProcessor("config.xml");
        xmlProcessor.process();
        
        System.out.println("\n--- Processing JSON Data ---");
        DataProcessor jsonProcessor = new JSONProcessor("{\"name\":\"John\"}");
        jsonProcessor.process();
    }
}
