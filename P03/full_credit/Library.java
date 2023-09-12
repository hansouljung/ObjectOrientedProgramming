import java.util.ArrayList;

public class Library{
	private String name;
	private ArrayList<Publication> publications;

	public Library(String name){
		this.name= name;
		this.publications= new ArrayList<>();
	}

	public void addPublication(Publication publication){
		publications.add(publication);
	}

	public void checkOut(int publicationIndex, String patron){
		if (publicationIndex >= 0 && publicationIndex < publications.size()) {
            Publication publication = publications.get(publicationIndex);
            publication.checkOut(patron);
        }
        else{
            throw new IndexOutOfBoundsException("Error on index for publication");
        }
	}

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