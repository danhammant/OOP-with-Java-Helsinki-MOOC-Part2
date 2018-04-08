package reference.comparator;

import reference.domain.Film;
import reference.domain.Rating;

import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class FilmComparator implements Comparator<Film>{
    Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compare(Film o1, Film o2) {
        return averageRating(o2) - averageRating(o1);
    }

    private int averageRating(Film film) {
        int total = 0;

        for (Rating rating : ratings.get(film)) {
            total += rating.getValue();
        }

        return total / ratings.get(film).size();
    }
}
