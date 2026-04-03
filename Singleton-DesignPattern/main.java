// the singleton class

class GameManager
{
	// 1. Static variable to hold the single instance
	private static GameManager instance;

	// 2. Private constructor (prevents creating new instances)
	
	private GameManager()
	{
		System.out.println("Game Manager Created!");
	}

	// 3. Public method to get the single instance
	
	public static GameManager getInstance()
	{
		if(instance == null)
		{
			instance = new GameManager();
		}

		return instance;
	}

	// Example method
	//
	public void startGame()
	{
		System.out.println("Game Started!");
	}

}

public class main
{
	public static void main(String[] args)
	{
		// get the singleton instance (first time - create it)

		GameManager manager1 = GameManager.getInstance();
		manager1.startGame();

		// Get the singleton instance again (returns existing instance)
		 GameManager manager2 = GameManager.getInstance();

                 // Check if both variables point to the SAME object
                 System.out.println("Same instance? " + (manager1 == manager2));
                // Output: Same instance? true
	}
}
