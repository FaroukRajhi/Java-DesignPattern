public class Singleton
{
	private static Singleton firstInstance = null; //is going to hold the one and the only instance for the class Singleton
        
	private Singleton()
	{
		// private constructor to ensure that is to make only instance for the class
		//

	}

	public static Singleton getInstance()
	{
		if(firstInstance == null)
		{
			firstInstance = new Singleton(); // Lazy instantiation
		}

		return firstInstance;
	}
}
