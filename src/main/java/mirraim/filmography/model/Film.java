package mirraim.filmography.model;

public class Film {
    private int id;
    private String title;
    private int year;
    private String genre;
    private boolean watched;

    public Film(int id, String title, int year, String genre) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    @Override
    public String toString() {
        String watched = isWatched() ? "yes" : "no";
        return String.format("id: %d, title: %s, year: %d, genre: %s, watched: %s",
                                id, title, year, genre, watched);
    }
}
