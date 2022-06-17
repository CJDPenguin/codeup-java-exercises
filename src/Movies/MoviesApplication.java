package Movies;

import movies.MoviesArray;
import util.Input;

public class MoviesApplication {

    static Input in = new Input();

    static Movie[] boxOffice = MoviesArray.findAll();

static void movieList(String category, Movie[] array){
    for (Movie movie : array) {
        if(category.equals("all")){
            System.out.printf("%s --- %s\n", movie.getName(), movie.getCategory());
        } else if(movie.getCategory().equals(category.toLowerCase())) {
            System.out.printf("%s --- %s\n", movie.getName(), movie.getCategory());
        }
    }
}

static void question() {
    System.out.println("How may we be of service today? I can show you all movies, or filtered by genre. I am pre-programmed with the following genres: Drama, Musical, SciFi, Horror, Comedy, and Animated.");
    String genre = in.getString();
    if (genre.equals("all")){
        movieList(genre,boxOffice);
        question();
    } else if (genre.equalsIgnoreCase("drama") || genre.equalsIgnoreCase("musical") || genre.equalsIgnoreCase("scifi") || genre.equalsIgnoreCase("horror") || genre.equalsIgnoreCase("comedy") || genre.equalsIgnoreCase("animated")) {
            movieList(genre, boxOffice);
            question();
    } else {
        System.out.println("I apologize, I am unfamiliar with that category of movie. Would you like to try again?");
        boolean cont = in.yesNo();
        if (cont) {
            question();
        }
    }
}

    public static void main(String[] args) {

        System.out.println("Welcome to the Movies Collection, thank you for using our service ^^");
        question();

    }
}
