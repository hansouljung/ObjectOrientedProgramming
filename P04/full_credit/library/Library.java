//modified 1:
package library;

import java.util.ArrayList;

/**
 * Represents a library that stores a collection of publications.
 */

public class Library{
	private String name;
	private ArrayList<Publication> publications;

	/**
     * Initializes a new library with the given name.
     *
     * @param name The name of the library.
     */

	public Library(String name){
		this.name= name;
		this.publications= new ArrayList<>();
	}

	/**
     * Adds a publication to the library's collection.
     *
     * @param publication The publication to be added.
     */

	public void addPublication(Publication publication){
		publications.add(publication);
	}


	/**
     * Checks out a publication from the library by specifying its index and patron's name.
     *
     * @param publicationIndex The index of the publication to check out.
     * @param patron           The name of the patron checking out the publication.
     * @throws IndexOutOfBoundsException If the specified publication index is out of bounds.
     */

	public void checkOut(int publicationIndex, String patron){
		if (publicationIndex >= 0 && publicationIndex < publications.size()) {
            Publication publication = publications.get(publicationIndex);
            publication.checkOut(patron);
        }
        else{
            throw new IndexOutOfBoundsException("Error on index for publication");
        }
	}
	/**
     * Returns a string representation of the library, including its name and a list of publications.
     *
     * @return The string representation of the library.
     */

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");

        for (int i=0; i<publications.size(); i++) {
            sb.append(i).append(") ").append(publications.get(i)).append("\n");
        }

        return sb.toString();
	}
}