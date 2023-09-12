import java.time.LocalDate;

public class Publication{
	private String title;
	private String author;
	private int copyright;
	private String loanedTo;
	private LocalDate dueDate;

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

	public void checkOut(String patron){
		this.loanedTo= patron;
		this.dueDate = LocalDate.now().plusDays(14);		
	}

	public void checkIn(){
		this.loanedTo = null;
        this.dueDate = null;
	}
}