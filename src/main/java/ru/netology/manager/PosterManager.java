package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PosterManager {
    private Film[] films = new Film[0];
    private int filmsQuantity = 10;

    public PosterManager(int filmsQuantity) {
        this.filmsQuantity = filmsQuantity;
    }

    public void save(Film film) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Film[] findAll() {
        return films;
    }

    public Film[] findLast() {
        int resultLength = films.length;
        if (resultLength > filmsQuantity) {
            resultLength = filmsQuantity;
        }

        Film[] result = new Film[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
