package com.assignment.kafka.resources;

public class MovieDetails
{
    private String movieName;
    private int movieYear;
    private String actorName;
    private String movieGenre;

    public MovieDetails(String movieName, int movieYear, String actorName, String movieGenre) {
        this.movieName = movieName;
        this.movieYear = movieYear;
        this.actorName = actorName;
        this.movieGenre = movieGenre;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    @Override
    public String toString() {
        return "MovieDetails{" +
                "movieName='" + movieName + '\'' +
                ", movieYear=" + movieYear +
                ", actorName='" + actorName + '\'' +
                ", movieGenre='" + movieGenre + '\'' +
                '}';
    }
}
