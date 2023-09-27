package ru.netology.poster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    @Test
    public void shouldAddZeroPoster() {
        PosterManager manager = new PosterManager();
        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOnePoster() {
        PosterManager manager = new PosterManager();
        manager.addPoster("Film 01");
        String[] expected = {"Film 01"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSomePosters() {
        PosterManager manager = new PosterManager();
        manager.addPoster("Film 01");
        manager.addPoster("Film 02");
        manager.addPoster("Film 03");
        manager.addPoster("Film 04");

        String[] expected = {"Film 01", "Film 02", "Film 03", "Film 04"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastPostersIfLessDefaultLimit() {
        PosterManager manager = new PosterManager();
        manager.addPoster("Film 01");
        manager.addPoster("Film 02");
        manager.addPoster("Film 03");
        manager.addPoster("Film 04");

        String[] expected = {"Film 04", "Film 03", "Film 02", "Film 01"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastPostersIfDefaultLimit() {
        PosterManager manager = new PosterManager();
        manager.addPoster("Film 01");
        manager.addPoster("Film 02");
        manager.addPoster("Film 03");
        manager.addPoster("Film 04");
        manager.addPoster("Film 05");
        manager.addPoster("Film 06");

        String[] expected = {"Film 06", "Film 05", "Film 04", "Film 03", "Film 02"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastPostersIfNewLimit() {
        PosterManager manager = new PosterManager(3);

        manager.addPoster("Film 01");
        manager.addPoster("Film 02");
        manager.addPoster("Film 03");

        String[] expected = {"Film 03", "Film 02", "Film 01"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastPostersIfLessNewLimit() {
        PosterManager manager = new PosterManager(3);
        manager.addPoster("Film 01");
        manager.addPoster("Film 02");

        String[] expected = {"Film 02", "Film 01"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastPostersIfMoreNewLimit() {
        PosterManager manager = new PosterManager(3);
        manager.addPoster("Film 01");
        manager.addPoster("Film 02");
        manager.addPoster("Film 03");
        manager.addPoster("Film 04");
        manager.addPoster("Film 05");
        manager.addPoster("Film 06");

        String[] expected = {"Film 06", "Film 05", "Film 04"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}

