package pl.mateusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mateusz.model.Movie;
import pl.mateusz.service.MovieServiceImpl;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @RequestMapping(value="/")
    public String index(Model model){

        List<Movie> allMovie = movieServiceImpl.findAllMovies();
        model.addAttribute("allMovie",allMovie);

        return "index";
    }

    @RequestMapping(value="addMovie")
    public String addMovie(){
        return "addMovie";
    }
}
