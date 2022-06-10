package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

public class PosterManagerTest {
    @Test
    void showAllAddedMovies() {
        Film first = new Film(1,"Бладшот", "боевик", true);
        Film second = new Film(2,"Вперёд", "мультфильм", false);
        Film third = new Film(3,"Отель «Белград»", "комедия", false);
        Film fourth = new Film(4,"Джентельмены", "боевик", false);
        Film fifth = new Film(5,"Человек-невидимка", "ужасы", true);
        Film sixth = new Film(6,"Тролли. Мировой тур", "мультфильм", false);
        Film seventh = new Film(7,"Номер один", "комедия", false);
        Film eighth = new Film(8,"Зверопой ", "комедия", false);
        Film ninth = new Film(9,"Бэтмен", "фэнтези", false);
        Film tenth = new Film(10,"Чужой", "фэнтези", false);

        PosterManager manager = new PosterManager();
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);
        manager.save(tenth);

        Film[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth,tenth};
        Film[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void showAllMoviesInReverseOrder() {
        Film first = new Film(1,"Бладшот", "боевик", true);
        Film second = new Film(2,"Вперёд", "мультфильм", false);
        Film third = new Film(3,"Отель «Белград»", "комедия", false);
        Film fourth = new Film(4,"Джентельмены", "боевик", false);
        Film fifth = new Film(5,"Человек-невидимка", "ужасы", true);
        Film sixth = new Film(6,"Тролли. Мировой тур", "мультфильм", false);
        Film seventh = new Film(7,"Номер один", "комедия", false);
        Film eighth = new Film(8,"Зверопой ", "комедия", true);
        Film ninth = new Film(9,"Бэтмен", "фэнтези", false);
        Film tenth = new Film(10,"Чужой", "фэнтези", false);

        PosterManager manager = new PosterManager();
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);
        manager.save(tenth);

        Film[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveNineFilms() {
        Film first = new Film(1,"Бладшот", "боевик", true);
        Film second = new Film(2,"Вперёд", "мультфильм", false);
        Film third = new Film(3,"Отель «Белград»", "комедия", false);
        Film fourth = new Film(4,"Джентельмены", "боевик", false);
        Film fifth = new Film(5,"Человек-невидимка", "ужасы", true);
        Film sixth = new Film(6,"Тролли. Мировой тур", "мультфильм", false);
        Film seventh = new Film(7,"Номер один", "комедия", false);
        Film eighth = new Film(8,"Зверопой ", "комедия", true);
        Film ninth = new Film(9,"Бэтмен", "фэнтези", false);

        PosterManager manager = new PosterManager();
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);

        Film[] expected = {ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldLeaveTenFilms() {
        Film first = new Film(1,"Бладшот", "боевик", true);
        Film second = new Film(2,"Вперёд", "мультфильм", false);
        Film third = new Film(3,"Отель «Белград»", "комедия", false);
        Film fourth = new Film(4,"Джентельмены", "боевик", false);
        Film fifth = new Film(5,"Человек-невидимка", "ужасы", true);
        Film sixth = new Film(6,"Тролли. Мировой тур", "мультфильм", false);
        Film seventh = new Film(7,"Номер один", "комедия", false);
        Film eighth = new Film(8,"Зверопой ", "комедия", true);
        Film ninth = new Film(9,"Бэтмен", "фэнтези", false);
        Film tenth = new Film(10,"Чужой", "фэнтези", false);
        Film eleventh = new Film(11,"Ежик в Тумане", "мультфильм", false);

        PosterManager manager = new PosterManager();
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);
        manager.save(tenth);
        manager.save(eleventh);

        Film[] expected = {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveInConstructorRange() {
        Film first = new Film(1,"Бладшот", "боевик", true);
        Film second = new Film(2,"Вперёд", "мультфильм", false);
        Film third = new Film(3,"Отель «Белград»", "комедия", false);
        Film fourth = new Film(4,"Джентельмены", "боевик", false);
        Film fifth = new Film(5,"Человек-невидимка", "ужасы", true);

        PosterManager manager = new PosterManager(3);
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);

        Film[] expected = {fifth, fourth, third};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneFilm() {
        Film first = new Film(11, "Ежик в Тумане", "мультфильм", true);

        PosterManager manager = new PosterManager();
        manager.save(first);

        Film[] expected = {first};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemainEmpty() {

        PosterManager manager = new PosterManager();
        manager.findAll();

        Film[] expected = {};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

}