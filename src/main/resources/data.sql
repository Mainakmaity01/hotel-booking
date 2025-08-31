INSERT INTO users (name, email, password, role)
VALUES ('Admin User', 'admin@hotel.com', '$2a$10$encryptedPasswordHere', 'ADMIN');

INSERT INTO rooms (room_number, type, price, available)
VALUES ('101', 'Deluxe', 2500.00, TRUE),
       ('102', 'Standard', 1500.00, TRUE),
       ('201', 'Suite', 5000.00, TRUE);
