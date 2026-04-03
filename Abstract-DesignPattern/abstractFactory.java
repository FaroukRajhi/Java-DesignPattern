// Usage 
//
public class AbstractFactory {
    public static void main(String[] args) {
        System.out.println("Creating Modern Furniture Set:");
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        FurnitureStore modernStore = new FurnitureStore(modernFactory);
        modernStore.displayFurniture();
        
        System.out.println("\nCreating Victorian Furniture Set:");
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        FurnitureStore victorianStore = new FurnitureStore(victorianFactory);
        victorianStore.displayFurniture();
    }
}
