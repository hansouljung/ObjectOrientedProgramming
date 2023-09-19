//modified 1:
package mdi;
import java.util.Scanner;


import library.Library;
import library.Publication;
import library.Video;


public class LibraryManager{
	public static void main(String[] args){
		Library library= new Library("Hansoul's library \n");
		Publication b1= new Publication("The Hunger Games", "Suzanne Collins", 2008);
		Publication b2= new Publication("Harry Potter and the Goblet of Fire", "J. K. Rowling", 2000);
		Publication b3= new Publication("Breaking Dawn", "Stephenie Meyer", 2008);

        Video v1 = new Video("Top Gun: Maverick", "Joseph Kosinski", 2022, 131);
        Video v2 = new Video("The Greatest Showman", "Michael Gracey", 2017, 105);
        Video v3 = new Video("The Chronicles of Narnia: The Lion, the Witch, and the Wardrobe", "Andrew Adamson", 2005, 150);

        //this part is modified

		library.addPublication(b1);
        library.addPublication(b2);
        library.addPublication(b3);

        library.addPublication(v1);
        library.addPublication(v2);
        library.addPublication(v3);

        Scanner scanner = new Scanner(System.in);

        // Print the library before asking which book to check out
        System.out.println(library);

        System.out.print("Which book to check out? ");
        
        try{
            int publicationIndex = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Prompt the user for their name after selecting the book
            System.out.print("Who are you: ");
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