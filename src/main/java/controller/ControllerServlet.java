package controller;

import model.*;
import services.DirectorService;
import services.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/"})
public class ControllerServlet extends HttpServlet {

    private MovieService movieService;
    private DirectorService directorService;

    public void init() {
        movieService = new MovieService();
        directorService = new DirectorService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("Method doPost\n");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        response.getWriter().write("Method doGet\n");
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertMovie(request, response);
                    break;
                case "/delete":
                    deleteMovie(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateMovie(request, response);
                    break;
                default:
                    listMovie(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listMovie(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Movie> listMovie = movieService.listAllObjects();
        List<Director> listDirector = directorService.getAllDirectors();

        request.setAttribute("listDirector", listDirector);
        request.setAttribute("listMovie", listMovie);
        RequestDispatcher dispatcher = request.getRequestDispatcher("MoviePage.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("MovieForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Movie existingMovie = movieService.get(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("MovieForm.jsp");
        request.setAttribute("movie", existingMovie);
        dispatcher.forward(request, response);
    }

    private void insertMovie(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String title = request.getParameter("title");
        int year = Integer.parseInt(request.getParameter("year"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        Director director = new Director(firstName, lastName);
        Movie newMovie = new Movie(title, year);
        List<Director> dir = directorService.getDirectorByName(firstName, lastName);

        if (dir != null) {
            newMovie.setDirector(dir.get(0));
            movieService.insert(newMovie);
        } else if (dir == null) {
            newMovie.setDirector(director);
            movieService.insert(newMovie);
        }
        response.sendRedirect("list");
    }

    private void updateMovie(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String title = request.getParameter("title");
        int year = Integer.parseInt(request.getParameter("year"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int id = Integer.parseInt(request.getParameter("id"));

        Movie movie = movieService.get(id);
        movie.setTitle(title);
        movie.setYear(year);
        movie.getDirector().setLastName(lastName);
        movie.getDirector().setFirstName(firstName);
        movieService.update(movie);
        directorService.update(movie.getDirector());

        response.sendRedirect("list");
    }

    private void deleteMovie(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Movie movie = new Movie(id);
        movieService.delete(movie);
        response.sendRedirect("list");
    }
}

