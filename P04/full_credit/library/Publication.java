//modified 1:
package library;

import java.time.LocalDate;
import java.util.StringJoiner;

/**
 * Represents a publication, which can be a book or a video.
 */

public class Publication{
	private String title;
	private String author;
	private int copyright;
	private String loanedTo;
	private LocalDate dueDate;

	/**
     * Initializes a new publication with the given title, author, and copyright year.
     *
     * @param title     The title of the publication.
     * @param author    The author or creator of the publication.
     * @param copyright The copyright year of the publication.
     * @throws IllegalArgumentException If the copyright year is not within the valid range.
     */

	public Publication(String title, String author, int copyright){
		this.title = title;
        this.author = author;

        int currentYear = LocalDate.now().getYear();
        if (copyright < 1900 || copyright > currentYear) {
            throw new IllegalArgumentException("Error with the copyright. Year should be ranging between 1900 and " +currentYear);
        }

        this.copyright = copyright;
        this.loanedTo = null; 
        this.dueDate = null; 
	}
/*
	public String toString(){
		StringBuilder sb = new StringBuilder();

		sb.append("\"").append(title).append("\" by ").append(author);
        sb.append(", copyright ").append(copyright);

        if (loanedTo!= null && dueDate!= null) {
            sb.append("\n--> loaned to ").append(loanedTo);
            sb.append(" until ").append(dueDate);
        }

        return sb.toString();
	}
*/
////////////////
	//original toStringBuilder

	/**
     * Returns a string representation of the publication.
     *
     * @return The string representation of the publication.
     * @param pre Checks the stirng before
     * @param mid Checks the string afterwards
     */

	// protected String toStringBuilder(String pre, String mid) {
    //     StringJoiner joiner = new StringJoiner(mid, pre, "");
    //     joiner.add("\"" + title + "\" by " + author+ ", copyright " + copyright);
    //     // joiner.add("\"" + title + "\" by " + author);
    //     // joiner.add("copyright " + copyright);

    //     if (loanedTo != null && dueDate != null) {
    //         joiner.add(": loaned to " + loanedTo + " until " + dueDate);
    //     }

    //     return joiner.toString();
    // }

    protected String toStringBuilder(String pre, String mid) {
	    StringBuilder sb = new StringBuilder();

	    sb.append(pre); // Append the pre string

	    sb.append("\"").append(title).append("\" by ").append(author);
	    sb.append(", copyright ").append(copyright);

	    if (loanedTo != null && dueDate != null) {
	        sb.append(mid); // Append the mid string
	        sb.append(' ').append(' ').append(' ').append(' ').append(": loaned to ").append(loanedTo).append(" until ").append(dueDate);
	    }

	    return sb.toString();
	}



  	/**
     * Returns a string representation of the publication.
     *
     * @return The string representation of the publication.
     */

    // +toString()
    @Override
    public String toString() {
    	// //try to do publication 
    	// String publicationType= this instanceof Video ? "Video" : "Book";
    	// String pre= publicationType + "\"" + title + "\" by " + author + ", copyright " +copyright;
    	// String mid= "";
    	// //
    	String publicationType = this instanceof Video ? "Video" : "Book";
        String pre = publicationType + " ";
        
        return pre + toStringBuilder("", "\n");
    
    }

///////////////

    /**
     * Checks out the publication to a patron by specifying the patron's name.
     *
     * @param patron The name of the patron checking out the publication.
     */

	public void checkOut(String patron){
		this.loanedTo= patron;
		this.dueDate = LocalDate.now().plusDays(14);		
	}

	/**
     * Checks in the publication, making it available for borrowing.
     */

	public void checkIn(){
		this.loanedTo = null;
        this.dueDate = null;
	}
}
