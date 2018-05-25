package pl.mateusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mateusz.model.Movie;
import pl.mateusz.service.MovieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AddMovieController {

    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @RequestMapping(value="/saveMovie")
    public String addMovie(Model model, HttpServletRequest servletRequest){

       String name = servletRequest.getParameter("name");
       String rate =  servletRequest.getParameter("rate");

       int rateInt = Integer.parseInt(rate);
       movieServiceImpl.save(name, rateInt);

        List<Movie> allMovie = movieServiceImpl.findAllMovies();
        model.addAttribute("allMovie",allMovie);

        return "index";
    }

}
