package reference;

import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class RatingRegister {
    private Map<Film, List<Rating>> filmRatings;
    private Map<Person, Map<Film, Rating>> personRatings;
    private List<Person> reviewers;

    public RatingRegister() {
        this.filmRatings = new HashMap<>();
        this.personRatings = new HashMap<>();
        this.reviewers = new ArrayList<>();
    }

    public void addRating (Film film, Rating rating) {
        if (filmRatings.containsKey(film)) {
            filmRatings.get(film).add(rating);
        } else {
            filmRatings.put(film, new ArrayList<>());
            filmRatings.get(film).add(rating);
        }

    }

    public void addRating(Person person, Film film, Rating rating) {
        if (personRatings.containsKey(person)) {
            personRatings.get(person).put(film, rating);
            addRating(film, rating);
        } else {
            personRatings.put(person, new HashMap<>());
            personRatings.get(person).put(film, rating);
            reviewers.add(person);
            addRating(film, rating);
        }
    }

    public List<Rating> getRatings(Film film) {
        return filmRatings.get(film);
    }

    public Rating getRating(Person person, Film film) {
        if (personRatings.get(person).containsKey(film)) {
            return personRatings.get(person).get(film);
        } else {
            return Rating.NOT_WATCHED;
        }
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (!personRatings.containsKey(person)) {
            return new HashMap<>();
        }

        return personRatings.get(person);
    }

    public Map<Film, List<Rating>> filmRatings() {
        return filmRatings;
    }

    public List<Person> reviewers() {
        return reviewers;
    }
}
