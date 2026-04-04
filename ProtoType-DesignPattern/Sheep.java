public class Sheep implements Animal
{
	public Sheep()
	{
		System.out.println("Sheep is make");
	}

	public Animal makeCopy()
	{
		System.out.println("Sheep is being Made");

		Sheep sheepObject = null;

		try
		{
			sheepObject = (Sheep) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace(); // Error in case the Animal interface is not extends Clonable interface
		}

		return sheepObject;
	}

	public String toString()
	{
		return "This is the sheep";
	}
}
