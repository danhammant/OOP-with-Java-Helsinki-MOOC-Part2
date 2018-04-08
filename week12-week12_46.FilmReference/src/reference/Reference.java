package reference;


import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;

import java.util.*;

public class Reference {
    private RatingRegister ratingRegister;

    public Reference (RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;
    }

    public Film recommendFilm(Person person) {
        if (!ratingRegister.reviewers().contains(person)) {
            List<Film> films = new ArrayList<>(ratingRegister.filmRatings().keySet());
            Collections.sort(films, new FilmComparator(ratingRegister.filmRatings()));

            return films.get(0);

        } else {
            List<Person> haveSeenSameFilms = haveSeenSameFilms(person);
            Map<Person, Integer> similarityScores = similarityScores(person, sameFilmsSeen(person, haveSeenSameFilms));

            Collections.sort(haveSeenSameFilms, new PersonComparator(similarityScores));

            return filmToBeRecommended(person, haveSeenSameFilms.get(0));
        }
    }

    private List<Person> haveSeenSameFilms(Person person) {
        List<Person> otherPeople = new ArrayList<>();

        for (Person otherPerson : ratingRegister.reviewers()) {
            if (otherPerson == person) {
                continue;
            }

            for (Film film : ratingRegister.getPersonalRatings(person).keySet()) {
                if (otherPeople.contains(otherPerson)) {
                    continue;
                }

                if (!ratingRegister.getPersonalRatings(otherPerson).containsKey(film)) {
                    continue;
                }

                otherPeople.add(otherPerson);
            }
        }

        return otherPeople;
    }

    private Map<Person, List<Film>> sameFilmsSeen(Person person, List<Person> haveSeenSameFilms) {
        Map<Person, List<Film>> sameFilmsSeen = new HashMap<>();

        for (Person otherPerson : haveSeenSameFilms) {
            sameFilmsSeen.put(otherPerson, new ArrayList<>());

            for (Film film : ratingRegister.getPersonalRatings(person).keySet()) {
                if (ratingRegister.getPersonalRatings(otherPerson).containsKey(film)) {
                    sameFilmsSeen.get(otherPerson).add(film);
                }
            }
        }

        return sameFilmsSeen;
    }

    private Map<Person, Integer> similarityScores(Person person, Map<Person, List<Film>> sameFilmsSeen) {
        Map<Person, Integer> similarityScores = new HashMap<>();

        for (Person otherPerson : sameFilmsSeen.keySet()) {
            int similarityScore = 0;

            for (Film film : sameFilmsSeen.get(otherPerson)) {
                int firstRating = ratingRegister.getPersonalRatings(person).get(film).getValue();
                int secondRating = ratingRegister.getPersonalRatings(otherPerson).get(film).getValue();

                similarityScore += firstRating - secondRating;
            }

            similarityScores.put(otherPerson, similarityScore);
        }

        return similarityScores;
    }

    private Film filmToBeRecommended (Person person1, Person person2) {
        for (Film film : ratingRegister.getPersonalRatings(person2).keySet()) {
            if (ratingRegister.getPersonalRatings(person1).containsKey(film)) {
                continue;
            }

            if (ratingRegister.getPersonalRatings(person2).get(film).getValue() < 3) {
                continue;
            }

            return film;
        }

        return null;
    }
}
