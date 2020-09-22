package mirraim.filmography.service;

import mirraim.filmography.model.Film;

import java.util.List;

public interface FilmService {

    List<Film> allFilms();
    void add(Film film);
    void delete(Film film);
    void edit(Film film);
    Film getByID(int id);
}
