/*
package mdi;

import library.Library;
import library.Publication;
import library.Video;

import java.util.Scanner;

public class LibraryManager {
    private Library library;
    private Scanner scanner;

    public LibraryManager(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void listPublications() {
        
        System.out.println(library);
    }

    public void addPublication() {
        System.out.println("Add Publication");
        // Create an instance of Publication and call its methods to add a publication.
    }

    public void addVideo() {
        System.out.println("Add Video");
        // Create an instance of Video and call its methods to add a video.
    }

    public void checkOutPublication() {
        System.out.println("Check Out Publication");
        // Call methods on Library, Publication, and Video instances as needed
        // to check out a publication.
    }

    public void checkInPublication() {
        System.out.println("Check In Publication");
        // Call methods on Library, Publication, and Video instances as needed
        // to check in a publication.
    }

    public void run() {
        int choice;
        do {
            System.out.println("0) Exit");
            System.out.println("1) List Publications");
            System.out.println("2) Add Publication");
            System.out.println("3) Add Video");
            System.out.println("4) Check Out Publication");
            System.out.println("5) Check In Publication");
            System.out.print("\n\nSelection: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    listPublications();
                    break;
                case 2:
                    addPublication();
                    break;
                case 3:
                    addVideo();
                    break;
                case 4:
                    checkOutPublication();
                    break;
                case 5:
                    checkInPublication();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        System.out.println("==========Main menu");
        System.out.println("==========\n");

        //Library library = new Library("Hansoul’s library\n");
        System.out.println("Hansoul's library\n");


        // Initialize the list of publications and videos here
        library.addPublication(new Publication("The Hunger Games", "Suzanne Collins", 2008));
        library.addPublication(new Publication("Harry Potter and the Goblet of Fire", "J. K. Rowling", 2000));
        library.addPublication(new Publication("Breaking Dawn", "Stephenie Meyer", 2008));
        library.addPublication(new Video("Top Gun: Maverick", "Joseph Kosinski", 2022, 131));
        library.addPublication(new Video("The Greatest Showman", "Michael Gracey", 2017, 105));
        library.addPublication(new Video("The Chronicles of Narnia: The Lion, the Witch, and the Wardrobe", "Andrew Adamson", 2005, 150));

        LibraryManager manager = new LibraryManager(library);
        manager.run();
        manager.scanner.close();
    }
}


*/

/////////////////////////////////
package mdi;

import library.Library;
import library.Publication;
import library.Video;

import java.util.Scanner;

public class LibraryManager {
    private Library library;
    private Scanner scanner;

    public LibraryManager(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void listPublications() {
        System.out.println(library);
    }

    public void addPublication(String title, String author, int copyright) {
        library.addPublication(new Publication(title, author, copyright));
    }

    public void addVideo(String title, String author, int copyright, int runtime) {
        library.addPublication(new Video(title, author, copyright, runtime));
    }

    public void checkOutPublication(int publicationIndex, String patron) {
        library.checkOut(publicationIndex, patron);
    }

    public void checkInPublication(int publicationIndex) {
        library.checkIn(publicationIndex);
    }

    public void run() {
        int choice;
        do {
            
        

            System.out.println("0) Exit");
            System.out.println("1) List Publications");
            System.out.println("2) Add Publication");
            System.out.println("3) Add Video");
            System.out.println("4) Check Out Publication");
            System.out.println("5) Check In Publication");
            System.out.print("\n\nSelection: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    listPublications();
                    break;
                case 2:
                    System.out.print("Enter publication title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter copyright year: ");
                    int copyright = scanner.nextInt();
                    addPublication(title, author, copyright);
                    break;
                case 3:
                    System.out.print("Enter video title: ");
                    String videoTitle = scanner.nextLine();
                    System.out.print("Enter video author: ");
                    String videoAuthor = scanner.nextLine();
                    System.out.print("Enter video copyright year: ");
                    int videoCopyright = scanner.nextInt();
                    System.out.print("Enter video runtime (minutes): ");
                    int runtime = scanner.nextInt();
                    addVideo(videoTitle, videoAuthor, videoCopyright, runtime);
                    break;
                case 4:
                    System.out.println(library);
                    System.out.print("Enter publication index to check out: ");
                    int publicationIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter patron's name: ");
                    String patron = scanner.nextLine();
                    checkOutPublication(publicationIndex, patron);
                    break;
                case 5:
                    System.out.print("Enter publication index to check in: ");
                    int checkInIndex = scanner.nextInt();
                    checkInPublication(checkInIndex);
                    break;
                case 0:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        System.out.println("==========\nMain menu");
        System.out.println("==========\n");

        Library library = new Library("\nHansoul’s library\n");
        


        // Initialize the list of publications and videos here
        library.addPublication(new Publication("The Hunger Games", "Suzanne Collins", 2008));
        library.addPublication(new Publication("Harry Potter and the Goblet of Fire", "J. K. Rowling", 2000));
        library.addPublication(new Publication("Breaking Dawn", "Stephenie Meyer", 2008));
        library.addPublication(new Video("Top Gun: Maverick", "Joseph Kosinski", 2022, 131));
        library.addPublication(new Video("The Greatest Showman", "Michael Gracey", 2017, 105));
        library.addPublication(new Video("The Chronicles of Narnia: The Lion, the Witch, and the Wardrobe", "Andrew Adamson", 2005, 150));

        
        LibraryManager manager = new LibraryManager(library);
        

        manager.run();
        manager.scanner.close();
    }
}


