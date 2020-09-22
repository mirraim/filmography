package mirraim.filmography.dao;

import mirraim.filmography.model.Film;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class FilmDAOImpl implements FilmDAO{
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Film> films = new HashMap<>();

    static {
       films.put(AUTO_ID.incrementAndGet(),
               new Film(AUTO_ID.get(), "Inception", 2010, "sci-fi"));
        films.put(AUTO_ID.incrementAndGet(),
                new Film(AUTO_ID.get(), "The Gentlemen", 2019, "comedy"));
        films.put(AUTO_ID.incrementAndGet(),
                new Film(AUTO_ID.get(), "Gladiator", 2000, "drama"));
    }

    @Override
    public List<Film> allFilms() {
        return new ArrayList<>(films.values());
    }

    @Override
    public void add(Film film) {
        film.setId(AUTO_ID.incrementAndGet());
        films.put(AUTO_ID.get(), film);
    }

    @Override
    public void delete(Film film) {
        films.remove(film.getId());
    }

    @Override
    public void edit(Film film) {
        films.put(film.getId(), film);
    }

    @Override
    public Film getByID(int id) {
        return films.get(id);
    }
}
