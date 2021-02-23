package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    public Director(int id){
        this.id=id;
    }

    @OneToMany(mappedBy = "director", fetch=FetchType.EAGER,cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Movie> movies;

    public Director() {  }
    public Director(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
        movies=new ArrayList<Movie>();
    }

    public int getId(){ return id; }
    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public List<Movie> getMovies(){ return movies; }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public void addMovie(Movie movie){
    movie.setDirector(this);
    movies.add(movie);
    }

    @Override
    public String toString(){
        return firstName+ " "+ lastName;
    }
}
