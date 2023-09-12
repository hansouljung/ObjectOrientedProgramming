import java.util.Scanner;


public class LibraryManager{
	public static void main(String[] args){
		Library library= new Library("Hansoul's library \n");
		Publication b1= new Publication("The Hunger Games", "Suzanne Collins", 2008);
		Publication b2= new Publication("Harry Potter and the Goblet of Fire", "J. K. Rowling", 2000);
		Publication b3= new Publication("Breaking Dawn", "Stephenie Meyer", 2008);

		library.addPublication(b1);
        library.addPublication(b2);
        library.addPublication(b3);

        Scanner scanner = new Scanner(System.in);

        // Print the library before asking which book to check out
        System.out.println(library);

        System.out.print("Which book to check out? ");
        
        try{
            int publicationIndex = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Prompt the user for their name after selecting the book
            System.out.print("Enter your name: ");
            String patronName = scanner.nextLine(); // Read the patron's name
            
            library.checkOut(publicationIndex, patronName); // Pass the patron's name
        }

        catch (Exception e){
            System.err.println("Error with publication index.");
        }

        // Print the library again to verify the checked-out book
        System.out.println(library);

        // Close the scanner
        scanner.close();
	}
}