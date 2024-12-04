package models;

import java.time.LocalDateTime;

public class Screening {
    private int id;
    private int movieId;
    private String room;
    private int maxSeats;
    private int availableSeats;
    private LocalDateTime time;

    public Screening() {}

    public Screening(int id, int movieId, String room, int maxSeats, int availableSeats, LocalDateTime time) {
        this.id = id;
        this.movieId = movieId;
        this.room = room;
        this.maxSeats = maxSeats;
        this.availableSeats = availableSeats;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
