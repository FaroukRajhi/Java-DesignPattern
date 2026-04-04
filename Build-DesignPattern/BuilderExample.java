public class BuilderExample
{
	public static void main(String[] args)
	{
		// E.g 1 : Basic computer with only required configs
		Computer basicComputer = new Computer.Builed("AMD","16GB");

		System.out.println("Basic Computer:");
		System.out.println(basicComputer);


		// E.g 2: Gaming computer with custom parameters
		Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .storage("1TB NVMe SSD")
                .graphicsCard("NVIDIA RTX 4080")
                .bluetooth(true)
                .wifi(true)
                .operatingSystem("Windows 11 Pro")
                .build();

                System.out.println("\nGaming Computer:");
                System.out.println(gamingComputer);

        // Example 3: Development workstation
        Computer devWorkstation = new Computer.Builder("AMD Ryzen 9", "64GB")
                .storage("2TB SSD")
                .graphicsCard("NVIDIA RTX 4070")
                .operatingSystem("Ubuntu 22.04")
                .bluetooth(true)
                .build();

        System.out.println("\nDevelopment Workstation:");
        System.out.println(devWorkstation);

        // Example 4: Home office computer
        Computer officeComputer = new Computer.Builder("Intel i7", "16GB")
                .storage("512GB SSD")
                .graphicsCard("Intel Iris Xe")
                .wifi(true)
                .build();

        System.out.println("\nOffice Computer:");
        System.out.println(officeComputer);
	}
}
