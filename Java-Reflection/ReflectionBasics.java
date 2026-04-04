import java.lang.reflect.*;
import java.util.*;
// Getting Class Information
public class ReflectionBasics {
    
    // Different ways to get a Class object
    public static void main(String[] args) throws ClassNotFoundException {
        
        // Method 1: Using .class
        Class<String> stringClass = String.class;
        
        // Method 2: Using getClass() method
        String str = "Hello";
        Class<?> strClass = str.getClass();
        
        // Method 3: Using Class.forName()
        Class<?> dynamicClass = Class.forName("java.util.ArrayList");
        
        System.out.println("Class name: " + dynamicClass.getName());
        System.out.println("Simple name: " + dynamicClass.getSimpleName());
        System.out.println("Package: " + dynamicClass.getPackage());
        System.out.println("Is interface: " + dynamicClass.isInterface());
        System.out.println("Superclass: " + dynamicClass.getSuperclass());
    }
}
