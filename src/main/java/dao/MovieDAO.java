package dao;

import models.Movie;
import utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    public boolean addMovie(Movie movie) throws SQLException {
        String sql = "INSERT INTO movies (title, description, duration) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getDescription());
            stmt.setInt(3, movie.getDuration());
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Movie> getAllMovies() throws SQLException {
        String sql = "SELECT * FROM movies";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            List<Movie> movies = new ArrayList<>();
            while (rs.next()) {
                movies.add(new Movie(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getInt("duration")));
            }
            return movies;
        }
    }

    public boolean deleteMovie(int movieId) throws SQLException {
        String sql = "DELETE FROM movies WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, movieId);
            return stmt.executeUpdate() > 0;
        }
    }

}

