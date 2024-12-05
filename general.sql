-- Adatbázis létrehozása
CREATE DATABASE IF NOT EXISTS mozijegyfoglalo;

-- Az adatbázis használata
USE mozijegyfoglalo;

-- Users tábla
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'USER') NOT NULL
);

-- Movies tábla
CREATE TABLE IF NOT EXISTS movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    genre VARCHAR(50),
    duration INT, -- Percekben
    rating DOUBLE DEFAULT NULL,
    image_path VARCHAR(255) -- Kép elérési útja
);

-- Screenings tábla
CREATE TABLE IF NOT EXISTS screenings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT NOT NULL,
    room VARCHAR(5),
    start_time DATETIME,
    available_seats INT,
    FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE
);

-- Reservations tábla
CREATE TABLE IF NOT EXISTS reservations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    screening_id INT NOT NULL,
    reserved_seats INT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (screening_id) REFERENCES screenings(id) ON DELETE CASCADE
);

-- Ratings tábla
CREATE TABLE IF NOT EXISTS ratings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    movie_id INT NOT NULL,
    rating DOUBLE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE
);

-- Minta adatok hozzáadása (opcionális)
-- Felhasználók
INSERT INTO users (username, password, role) VALUES 
('admin', 'admin123', 'ADMIN'),
('user1', 'user123', 'USER');

-- Filmek
INSERT INTO movies (title, genre, duration, rating, image_path) VALUES 
('Inception', 'Sci-Fi', 148, 8.8, '/images/inception.jpg'),
('The Dark Knight', 'Action', 152, 9.0, '/images/the_dark_knight.jpg');

-- Vetítések
INSERT INTO screenings (movie_id, room, start_time, available_seats) VALUES 
(1, 'A', '2024-12-05 18:00:00', 50),
(2, 'B', '2024-12-05 20:00:00', 100);

-- Foglalások
INSERT INTO reservations (user_id, screening_id, reserved_seats) VALUES 
(2, 1, 2);

-- Értékelések
INSERT INTO ratings (user_id, movie_id, rating) VALUES 
(2, 1, 4.5),
(2, 2, 5.0);

