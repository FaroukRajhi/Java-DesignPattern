public interface Chair
{
	void sitOn();
	boolean hasLegs();

}


public interface Sofa
{
	void lieOn();
	int getSeatingCapacity();
}

public interface Table
{
	void placeItems();
	String getMaterial();
}

// Modern style products
public class ModernChair implements chair
{
	@Override
	public void sitOn()
	{
		System.out.println("Sitting on a modern chair with sleek design");
	}

	@Override
	public boolean hasLegs()
	{
		return false;
	}

}

class ModernSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a modern, minimalist sofa");
    }

    @Override
    public int getSeatingCapacity() {
        return 3;
    }
}

class ModernTable implements Table {
    @Override
    public void placeItems() {
        System.out.println("Placing items on a glass modern table");
    }

    @Override
    public String getMaterial() {
        return "Glass and Steel";
    }
}

// ============ VICTORIAN STYLE PRODUCTS ============
class VictorianChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on an elegant Victorian chair with ornate carvings");
    }

    @Override
    public boolean hasLegs() {
        return true; // Victorian chairs have decorative legs
    }
}

class VictorianSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a luxurious Victorian sofa with velvet upholstery");
    }

    @Override
    public int getSeatingCapacity() {
        return 2;
    }
}

class VictorianTable implements Table {
    @Override
    public void placeItems() {
        System.out.println("Placing items on a wooden Victorian table");
    }

    @Override
    public String getMaterial() {
        return "Mahogany Wood";
    }
}



// Abstract Factory
//
public interface FurnitureFactory
{
	Chair createChair();
	Sofa  createSofa();
	Table createTable();
}

// ============ CONCRETE FACTORIES ============

class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}

class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }
}

// ============ CLIENT CODE ============
class FurnitureStore {
    private Chair chair;
    private Sofa sofa;
    private Table table;

    public FurnitureStore(FurnitureFactory factory) {
        this.chair = factory.createChair();
        this.sofa = factory.createSofa();
        this.table = factory.createTable();
    }

    public void displayFurniture() {
        System.out.println("\n=== Furniture Set ===");
        chair.sitOn();
        System.out.println("Chair has legs: " + chair.hasLegs());

        sofa.lieOn();
        System.out.println("Sofa capacity: " + sofa.getSeatingCapacity() + " seats");

        table.placeItems();
        System.out.println("Table material: " + table.getMaterial());
    }
}

