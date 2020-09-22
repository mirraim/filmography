package mirraim.filmography.controller;

import mirraim.filmography.model.Film;
import mirraim.filmography.service.FilmService;
import mirraim.filmography.service.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/filmography")
public class FilmController {
    private FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/")
    public ModelAndView allFilms(){
        List<Film> films = filmService.allFilms();
        ModelAndView filmModelAndView = new ModelAndView();
        filmModelAndView.setViewName("films");
        filmModelAndView.addObject("filmsList", films);
        return filmModelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id){
        Film film = filmService.getByID(id);
         ModelAndView editModelAndView = new ModelAndView();
         editModelAndView.setViewName("editPage");
         editModelAndView.addObject("film",filmService.getByID(id));
         return editModelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editFilm(@ModelAttribute("film") Film film){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/filmography/");
        filmService.edit(film);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addFilm(@ModelAttribute("film") Film film){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/filmography/");
        filmService.add(film);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteilm(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/filmography/");
        Film film = filmService.getByID(id);
        filmService.delete(film);
        return modelAndView;
    }

}
