public class CloneFactory
{
	public Animal getClone(Animal animalSample)
	{
		return animalSample.makeCopy(); // means clone the super type of this animal and then cast it into being whatever it is

	}

}
