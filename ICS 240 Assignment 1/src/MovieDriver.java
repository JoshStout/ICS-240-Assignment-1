import java.util.Arrays;

public class MovieDriver {
	
	public static void main(String[] args) {
		
		//create 7 Movie objects 
		Movie movie1 = new Movie("The Program", "Betty", 1);
		Movie movie2 = new Movie("The Source Code" , "Sue", 0);
		Movie movie3 = new Movie("The Software", "Tom" , 2);
		Movie movie4 = new Movie("The Application", "Henry", 3);
		Movie movie5 = new Movie("The Assembler", "Jane", 3);
		Movie movie6 = new Movie("The Compiler", "Barb", 1);
		Movie movie7 = new Movie("The Interpreter", "John", 2);
		
		//create 2 Distributor objects
		Distributor distributor1 = new Distributor("Computer Film Distribution", "123-456-7890");
		Distributor distributor2 = new Distributor("Machine Pictures Distribution", "111-222-3333");
		
		//add 5 different movies to first distributor 
		distributor1.addMovie(movie1);
		distributor1.addMovie(movie2);
		distributor1.addMovie(movie3);
		distributor1.addMovie(movie4);
		distributor1.addMovie(movie5);
		
		//add a sixth movie to the same distributor and show the program
		//doesn't crash but operation does not succedd. 
		if(distributor1.addMovie(movie6)) {
			System.out.println("Movie 5 added to Computer Film Distribution.");
		}else {
			System.out.println("Failed to upload movie 6 to Computer Film Distribution.\n");
		}
		
		//add 2 movies to second distributor object
		distributor2.addMovie(movie6);
		distributor2.addMovie(movie7);
		
		//print the two distributors 
		System.out.println(distributor1.toString());
		System.out.println(distributor2.toString());
		
		//test all Movie class methods
		System.out.println("TESTING ALL MOVIE CLASS METHODS...");
		System.out.println("movie1.toString(): " + movie1.toString());
		System.out.println("movie1.getName(): " + movie1.getName());
		System.out.println("movie1.getDirectorName(): " + movie1.getDirectorName());
		System.out.println("movie1.addToEarnings(3.5) ");
		movie1.addToEarnings(3.5);
		System.out.println("movie1.getEarnings(): " + movie1.getEarnings());
		System.out.println("movie1.getGenre(): " + movie1.getGenre());
		System.out.println("movie1.setName(The Software) ");
		movie1.setName("The Software");
		System.out.println("movie1.setDirectorName(Tom) ");
		movie1.setDirectorName("Tom");
		System.out.println("movie1.setGenre(1) ");
		movie1.setGenre(2);
		System.out.println("movie1.equals(movie3): " + movie1.equals(movie3));
		System.out.println("movie1.toString(): " + movie1.toString());
		System.out.println("\n");
		
		//test all Distributor class methods
		System.out.println("TESTING ALL DISTRIBUTOR CLASS METHODS...");
		System.out.println("distributor1.toString()");
		System.out.println(distributor1.toString());
		System.out.println("distributor1.getName()" + distributor1.getName());
		System.out.println("distributor1.getPhone()" + distributor1.getPhone());
		System.out.println("distributor1.getMovies()");
		Movie[] copy = distributor1.getMovies();
		for(int i = 0; i < copy.length; i++) {
			if(copy[i] != null) {
				System.out.println(copy[i].toString());
			}
		}
		System.out.println();
		System.out.println("distributor2.getName(): " + distributor2.getName());
		System.out.println("distributor2.getNumMovies(): " + distributor2.getNumMovies());
		System.out.println("distributor2.addMove(Test Film, Joe, 1, 20): " + distributor2.addMovie("Test Film", "Joe", 1, 20));
		System.out.println("distributor2.getNumMovies(): " + distributor2.getNumMovies());
		System.out.println("distributor2.getMovies()");
		Movie[] copy2 = distributor2.getMovies();
		for(int i = 0; i < copy2.length; i++) {
			if(copy2[i] != null) {
				System.out.println(copy2[i].toString());
			}
		}
		System.out.println();
		System.out.println("distributor1.totalEarnings(): " + distributor1.totalEarnings());
		System.out.println("distributor1.comedyEarnings(): " + distributor1.comedyEarnings());
		System.out.println("distributor1.addEarnings(The Source Code, 2): " + distributor1.addEarnings("The Source Code", 2));
		System.out.println("distributor1.totalEarnings(): " + distributor1.totalEarnings());
		System.out.println("distributor1.comedyEarnings(): " + distributor1.comedyEarnings());
		System.out.println("distributor1.getNumGenre(2): " + distributor1.getNumGenre(2));
		System.out.println("distributor1.getNumGenre(4): " + distributor1.getNumGenre(4));
		System.out.println("distributor1.calculateTax(0.05, distributor1): " + distributor1.calculateTax(0.05, distributor1));
		System.out.println("distributor1.setName(Machine Pictures Distribution)"); 
		distributor1.setName("Machine Pictures Distribution");
		System.out.println("distributor2.equals(distributor1): " + distributor1.equals(distributor1));
	}
}
