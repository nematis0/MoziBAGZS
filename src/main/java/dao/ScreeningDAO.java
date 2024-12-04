package dao;

import models.Screening;
import utils.Database;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScreeningDAO {

    // Vetítés hozzáadása
    public boolean addScreening(Screening screening) throws SQLException {
        String sql = "INSERT INTO screenings (movie_id, room, max_seats, available_seats, time) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, screening.getMovieId());
            stmt.setString(2, screening.getRoom());
            stmt.setInt(3, screening.getMaxSeats());
            stmt.setInt(4, screening.getAvailableSeats());
            stmt.setString(5, screening.getTime().toString());
            return stmt.executeUpdate() > 0;
        }
    }

    // Vetítések listázása
    public List<Screening> getAllScreenings() throws SQLException {
        String sql = "SELECT * FROM screenings";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            List<Screening> screenings = new ArrayList<>();
            while (rs.next()) {
                screenings.add(new Screening(
                        rs.getInt("id"),
                        rs.getInt("movie_id"),
                        rs.getString("room"),
                        rs.getInt("max_seats"),
                        rs.getInt("available_seats"),
                        LocalDateTime.parse(rs.getString("time"))
                ));
            }
            return screenings;
        }
    }

    // Foglalás (egy hely csökkentése)
    public boolean bookSeat(int screeningId) throws SQLException {
        String sql = "UPDATE screenings SET available_seats = available_seats - 1 WHERE id = ? AND available_seats > 0";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, screeningId);
            return stmt.executeUpdate() > 0;
        }
    }

    // Vetítés törlése
    public boolean deleteScreening(int screeningId) throws SQLException {
        String sql = "DELETE FROM screenings WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, screeningId);
            return stmt.executeUpdate() > 0;
        }
    }
}
