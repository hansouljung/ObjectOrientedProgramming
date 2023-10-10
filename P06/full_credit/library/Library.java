package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.IOException;

/**
 * Models a library containing various publications.
 *
 * @author             Professor George F. Rice
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
 public class Library {
    private String name;
    private ArrayList<Publication> publications;


    /**
     * Creates a Library instance.
     *
     * @param name         the name of the library
     * @since              1.0
     */
    public Library(String name) {
        this.name = name;
        this.publications = new ArrayList<>();
    }


    /**
     * Adds a publication to this library instance.
     *
     * @param publication  the publication to add to the library
     * @since              1.0
     */
    public void addPublication(Publication publication) {
        publications.add(publication);
    }
    /**
     * Checks out a publication from this library instance.
     *
     * The due date will be set to 2 weeks from the current date.
     *
     * @param publicationIndex  the index as shown by toString()
     * @param patron            identification of the borrower
     * @since                   1.0
     */
    public void checkOut(int publicationIndex, String patron) {
        try {
            publications.get(publicationIndex).checkOut(patron);
        } catch(Exception e) {
            System.err.println("\nUnable to check out publication #" + publicationIndex 
                + ": " + e.getMessage() + "\n");
        }
    }

//-------------------------- change 1 P05
    /**
     * Checks in a publication in this library instance.
     *
     * @param publicationIndex  the index of the publication to check in
     * @since                   1.1
     */
    public void checkIn(int publicationIndex) {
        try {
            publications.get(publicationIndex).checkIn();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("\nInvalid publication index: " + publicationIndex + "\n");
        }
    }

//------------------------------------



    /**
     * Lists all publications in this library instance.
     *
     * The index shown in the resulting String may be used 
     * to check out a publication using the checkOut() method.
     *
     * @returns     the string representation of all library publications
     * @since       1.0
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + "\n\n");
        for(int i=0; i<publications.size(); ++i)
            sb.append("" + i + ") " + publications.get(i).toString() + "\n");
        return sb.toString();
    }


    public void save(BufferedWriter bw) throws IOException {
        bw.write(name); // Write the library name to the file
        bw.newLine(); // Write a newline character

        // Write the number of publications in the library
        bw.write(publications.size() + "");
        bw.newLine();

        // Iterate over the publications and save each one
        for (Publication publication : publications) {
            if (publication instanceof Video) {
                bw.write("video");
            } else {
                bw.write("publication");
            }
            bw.newLine();
        }
    }

     public Library(BufferedReader br) throws IOException {
        name = br.readLine(); // Read the library name from the file

        publications = new ArrayList<>();
        int size = Integer.parseInt(br.readLine()); // Read the number of publications
        for (int i = 0; i < size; i++) {
            String type = br.readLine(); // Read "publication" or "video" to determine the type
            Publication publication;
            if (type.equals("publication")) {
                publication = new Publication(br); // Create a new Publication object
            } else {
                publication = new Video(br); // Create a new Video object
            }
            publications.add(publication);
        }
    }  

//     public Library(BufferedReader br) throws IOException {
//     name = br.readLine(); // Read the library name from the file
// }
 





}