
/**
 * The <CODE>Distributor</CODE> Java class for Distributor data type.
 * Represent a collection of Movie objects, including the distributor name,
 * phone, movie collection, and number of movies.
 * 
 */

import java.util.Arrays;


public class Distributor {
	private String name;
	private String phone;
	private Movie[] movies; 
	private int numMovies;
	
	/**
	 * Constructor for [Distributor] object.
	 * @param name The name of the movie distributor.
	 * @param phone The phone number of the movie distributor.
	 */
	public Distributor(String name, String phone) {
		this.name = name;
		this.phone = phone;
		this.movies = new Movie[5];
		numMovies = 0;
	}
	
	/**
	 * 
	 * @return A String representing the name of the distributor.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return A String representing the phone number of the distributor.
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * 
	 * @param name Assigns the name of the distributor.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @param Assigns the phone of the distributor.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * 
	 * @return An array of [Movie] objects in the distributor collection.
	 */
	public Movie[] getMovies() {
		return Arrays.copyOf(movies, numMovies);
	}
	
	
	/**
	 * Adds [Movie] object to distributor collection. If collection is full, the movie does not get 
	 * added the method returns false. 
	 * @param film The [Movie] object to add into the distributor collection.
	 * @precondition no more than five [Move] objects per distributor collection.
	 * @return A boolean value, true if the movie was successfully added to the distributor collection.
	 */
	public boolean addMovie(Movie film) {
		boolean output = false; //return false by default
		
		//if array is not full, add the film to the array and return true
		if(numMovies < 5) {
			movies[numMovies] = film;
			numMovies++;
			output = true;
		}
		return output;
	}
	
	
	/**
	 * Overload of the addMovie method. Add movie to distributor collection by creating a [Movie] 
	 * object using the input parameters. If collection is full, the movie does not get added and
	 * the method returns false.
	 * @param name The name of the movie.
	 * @param directorName The name of the movie director.
	 * @param genre Integer value representing the movie genre: Comedy = 0, Action = 1, Fiction = 2.
	 * @param earnings A double representing the amount of earning for the movie.
	 * @precondition No more than five [Movie] objects per distributor collection.
	 * @return A boolean value, true if the movie was successfully added to the distributor collection.
	 */
	public boolean addMovie(String name, String directorName, int genre, double earnings) {
		boolean output = false;
		
		//if array is not full, add the film to the array and return true
		if(numMovies < 5) {
			Movie film = new Movie(name, directorName, genre);
			film.addToEarnings(earnings);
			output = this.addMovie(film);
		}
		return output;
	}
	
	/**
	 * 
	 * @return An integer representing the number of movies in the distributor collection.
	 */
	public int getNumMovies() {
		return numMovies;
	}
	
	/**
	 * Computes the total earning of all movies in the distributor collection. 
	 * @return The total earning of all movies in the distributor collection. 
	 */
	public double totalEarnings() {
		double totalEarnings = 0;
		for(int i = 0; i < movies.length; i++) {
			if(this.movies[i] != null) {
				totalEarnings += this.movies[i].getEarnings();
			}
		}
		return totalEarnings;
	}
	
	
	/**
	 * Computes the total earnings for all comedy movies. 
	 * @return The total earnings for all comedy movies.
	 */
	public double comedyEarnings() {
		double comedyEarnings = 0;
		for(int i = 0; i < movies.length; i++) {
			if(movies[i].getGenre() == 0) {
				comedyEarnings += movies[i].getEarnings();
			}
		}
		return comedyEarnings;
	}
	
	
	/**
	 * Add earnings to a specific movie in the distributor collection.
	 * @param name A String representing the name of the movie to add its earnings.
	 * @param earnings A double representing the amount to be added to its earnings.
	 * @return A boolean value, true if the amount was successfully added to the movie's earnings. 
	 */
	public boolean addEarnings(String name, double earnings) {
		boolean output = false;
		for(int i = 0; i < movies.length; i++) {
			if(movies[i].getName().equals(name)) {
				movies[i].addToEarnings(earnings);
				output = true;
			}
		}
		return output;
	}
	
	
	/**
	 * Computes the amount of film genres in the distributor collection that matches 
	 * the genre passed. Genres are indicated by int values: Comedy (0), Action (1), Fiction (2).
	 * @param genre An integer representing the genre: Comedy (0), Action (1), Fiction (2).
	 * @return The amount of films in the distributor collection of the same genre. 
	 */
	public int getNumGenre(int genre) {
		int count = 0;
		for(int i = 0; i < movies.length; i++) {
			if(movies[i].getGenre() == genre) {
				count++;
			}
		}
		if(genre < 0 || genre > 2) {
			count = -1;
		}
		return count;
	}
	
	/**
	 * Computes the tax amount based on the tax rate (e.g., 0.05 for 5%) and the [Distributor] object
	 * passed to the method. It multiplies the distributor's total earnings by the tax rate. 
	 * @param taxRate A double that represents the tax rate (e.g., 0.05 for 5%)
	 * @param obj An object of [Distributor] type.
	 * @return A double representing the amount to be paid by the distributor. 
	 */
	public static double calculateTax(double taxRate, Distributor obj) {
		double rate = 0;
		Distributor distrib = (Distributor) obj;
		rate = distrib.totalEarnings() * taxRate;
		return rate;
	}
	
	/**
	 * Computes if two distributors are equal by comparing the distributor names. 
	 * @param obj The [Distributor] object to be compared. 
	 * @return A boolean value, true if the distributor equals the parameter distributor.
	 */
	public boolean equals(Object obj) {
		Distributor other = (Distributor) obj;
		return this.name.equalsIgnoreCase(other.name);		
	}
	
	/**
	 * @return A formatted String representation of the distributor, including all their movies.
	 */
	public String toString() {
		String output = "";
		output += "Name: ";
		output += this.name;
		output += "\tPhone: ";
		output += this.phone;
		output += "\tNumber of Movies: ";
		output += this.getNumMovies(); 
		output += "\n\n";
		for(Movie film : this.movies) {
			if(film != null) {
				output += film.toString();
				output += "\n";
			}
		}
		output += "Total Earnings: ";
		output += this.totalEarnings();
		output += "\n\n";
		return output;
	}
}
