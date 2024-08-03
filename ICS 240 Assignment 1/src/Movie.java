
/**
 * 
 * The <CODE>Movie</CODE> Java class for Movie data type.
 * Represents a movie, including movie name, director name, movie earnings and genre.
 * 
 */
public class Movie {
	private String name;
	private String directorName;
	private double earnings;
	private int genre; //Comedy (0), Action (1), Fiction (2)
	
	/**
	 * Constructor for [Movie] object.
	 * @param name The name of the movie.
	 * @param directorName The name of the director.
	 * @param genre Integer value representing the movie genre: Comedy = 0, Action = 1, Fiction = 2.
	 */
	public Movie(String name, String directorName, int genre) {
		this.name = name;
		this.directorName = directorName;
		this.genre = genre;
	}
	
	/**
	 * 
	 * @return A String representing the name of the movie.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return A String representing the name of the director.
	 */
	public String getDirectorName() {
		return directorName;
	}
	
	/**
	 * 
	 * @return A double representing the amount of earnings for the movie.
	 */
	public double getEarnings() {
		return earnings;
	}
	
	/**
	 * 
	 * @return An int representing the genre of the movie: 1 = Comedy, 2 = Action, 3 = Fiction.
	 * 
	 */
	public int getGenre() {
		return genre;
	}
	
	
	/**
	 * 
	 * @param name Assigns the name of the movie.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @param directorName Assigns the name of the director of the movie.
	 */
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	
	/**
	 * 
	 * @param genre Assigns the genre of the movie using an int between 1-3: 1 = Comedy, 2 = Action, 3 = Fiction.
	 */
	public void setGenre(int genre) {
		this.genre = genre;
	}
	
	/**
	 * Takes as input and adds that amount to the movie's earnings.
	 * @param amount The amount to be added to the total earnings.
	 */
	public void addToEarnings(double amount) {
		this.earnings += amount;
	}
	
	/**
	 * 
	 * Computes if two movies are equal by comparing the name, director name, and genere.
	 * @param obj The [Movie] object to be compared.
	 * @return A boolean value, true if the movie equals the parameter movie.
	 */
	public boolean equals(Object obj) {
		Movie other = (Movie) obj;
		return this.name.equalsIgnoreCase(other.name) && 
				this.directorName.equalsIgnoreCase(other.directorName) &&
				this.genre == other.genre;
	}
		
	/**
	 * @return A formatted String description of the movie on a single line.
	 */
	@Override
	public String toString() {
		String output = "";
		output += "Movie: ";
		output += this.name;
		output += "\t\tDirector: ";
		output += directorName;
		output += "\t\tEarnings: ";
		output += this.earnings;
		output += "\t\tGenre: ";
		output += this.genre;
		return output;
	}
}
