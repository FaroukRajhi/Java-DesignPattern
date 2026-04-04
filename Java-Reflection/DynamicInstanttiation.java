import java.lang.reflect.*;
import java.util.*;

// Creating objects at run-time
public class DynamicInstantiation {
    public static void main(String[] args) throws Exception {
        
        // Method 1: Using newInstance() (deprecated)
        Class<?> personClass = Person.class;
        Person person1 = (Person) personClass.getDeclaredConstructor().newInstance();
        System.out.println("Default constructor: " + person1);
        
        // Method 2: Using Constructor with parameters
        Constructor<Person> constructor = Person.class.getConstructor(String.class, int.class);
        Person person2 = constructor.newInstance("John Doe", 30);
        System.out.println("Parameterized constructor: " + person2);
        
        // Method 3: Accessing private constructor
        Constructor<Person> privateConstructor = Person.class.getDeclaredConstructor(String.class);
        privateConstructor.setAccessible(true); // Bypass private access
        Person person3 = privateConstructor.newInstance("Jane Smith");
        System.out.println("Private constructor: " + person3);
        
        // Method 4: Dynamic class loading
        String className = "java.util.ArrayList";
        Class<?> dynamicClass = Class.forName(className);
        Object arrayList = dynamicClass.getDeclaredConstructor().newInstance();
        System.out.println("Created: " + arrayList.getClass().getSimpleName());
    }
}
