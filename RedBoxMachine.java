import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class represents a Redbox Machine that allows users
 * to rent and return movies.
 * @author
 * @version 1.0
 */
public class RedBoxMachine
{
   //Create an instance variable to hold all of the DVDs.

   /** the list of DVDs */
   private ArrayList<DVD> movies;
   /** Constructs a Redbox Machine and fills it with DVDs
    *  Reads the file MovieList.txt so make sure that the
    *  file is in the same folder as the RedboxMachine.class
    *  file.
    */

   public RedBoxMachine()
   {
      // Complete the constructor.
      movies = new ArrayList<DVD>();
      // Leave this method. It will fill the machine with DVDs.
      fillMachine();
   }

   /** Searches for the movie with the provided title and returns
    *  the position of the DVD in the list if the DVD is found and
    *  -1 if the DVD is not in the list.
    *  @param title the title of the DVD being searched for.
    *  @return the index of the DVD in the list if present and
    *          -1 if the DVD is not in the list.
    */
   public int searchForMovie(String title)
   {
      // Complete the method to search for a movie.
      // If placement is -1, then the movie isn't there.
      // Find the index of i if the movie is there.
      // loop through arraylist for title
      for (DVD movie : movies)
      {
         // if already exists
         if (movie.getTitle().equals(title))
         {
            System.out.println(movie.toString());
            return movies.indexOf(movie);
         }
      }
      return -1;
   }

   /** Returns the titles of all available DVD's in
    *  the machine.
    *  @return an ArrayList of Strings containing the
    *          titles of all available movies.
    */
   public ArrayList<String> getAvailableMovies()
   {
      // Complete the method to get all available movie titles.
      ArrayList<String> titles = new ArrayList<String>();
      // loop through arraylist for title
      for (DVD movie : movies)
      {
         // add each title of movie to titles
         titles.add(movie.getTitle());
      }
      return titles;
   }

   /** Allows a customer to rent a movie. When the movie is rented, the number
    *  of available copies is reduced by 1. If there are 0 copies of the movie left
    *  after the transaction, the movie is removed from the list.
    *  @param title the title of the movie being rented.
    *  @return true if the movie was found and rented successfully, and false
    *  otherwise.
    */
   public boolean rent(String title)
   {
      // Complete the method to rent a movie.
      // loop through arraylist for title
      for (DVD movie : movies)
      {
         // if already exists
         if (movie.getTitle().equals(title))
         {
            // take away 1 copy
            movie.decrementCopies();
            // if 0, remove
            if (movie.getNumCopies() == 0)
            {
               movies.remove(movie);
            }
            return true;
         }
      }
         return false;
   }

   /** Allows a customer to return a movie. When the movie is returned, the number
    *  of available copies is increased by 1. If the movie was not already in the
    *  machine, then the DVD is added to the list.
    *  @param title the title of the movie being returned.
    *  @return the DVD that was returned by the customer.
    */
   public DVD returnMovie(String title)
   {
      // Complete the method to return a movie.
      // loop through arraylist for title
      for (DVD movie : movies)
      {
         // if already exists
         if (movie.getTitle().equals(title))
         {
            // add 1 copy
            movie.incrementCopies();
            return movie;
         }
      }
      // if doesn't exist, add to movies
      DVD testing = new DVD(title);
      movies.add(testing);

      return testing;
   }

   /** This method fills the machine with movies. You do not have
    *  to do anything to the code in this method.
    */
   private void fillMachine()
   {
      try{
         Scanner sn = new Scanner(new File("MovieList.txt"));
         while(sn.hasNextLine())
            returnMovie(sn.nextLine());

      }catch(FileNotFoundException e){
         String s = "File not found! Make sure that MovieList.txt ";
         s = s + "is in the same folder as the class.";
         System.out.println(s);
      }
   }
}
