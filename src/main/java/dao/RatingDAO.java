package dao;

public class RatingDAO {
    private int id;
    private int movieId;
    private int userId;
    private int rating; // 1-től 5-ig
    private boolean approved;

    // Konstruktorok
    public RatingDAO() {}

    public RatingDAO(int id, int movieId, int userId, int rating, boolean approved) {
        this.id = id;
        this.movieId = movieId;
        this.userId = userId;
        this.rating = rating;
        this.approved = approved;
    }

    // Getterek és setterek
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getMovieId() { return movieId; }
    public void setMovieId(int movieId) { this.movieId = movieId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }
}

