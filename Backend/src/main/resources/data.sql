-- AUTHORITIES
INSERT INTO authority (name) VALUES ('ROLE_ADMIN');
INSERT INTO authority (name) VALUES ('ROLE_NORMAL_USER');

-- ADMINS
INSERT INTO admin (username, password, first_name, last_name, email)
VALUES ('admin1', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'Admin1', 'Adminic1', 'admin1@gmail.com');

-- NORMAL USERS
INSERT INTO normal_user (username, password, first_name, last_name, email, country, phone_number, address, city, number_of_ads, is_banned)
VALUES ('user1', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'User1', 'Useric1', 'user1@gmail.com', 'Serbia', '+38112345678', 'Neka Adresa St. 1', 'Novi Sad', 2, false);

-- INSERT INTO authority (name)
-- SELECT 'ROLE_ADMIN'
-- WHERE NOT EXISTS (SELECT name FROM authority WHERE name = 'ROLE_ADMIN');
--
-- INSERT INTO authority (name)
-- SELECT 'ROLE_USER'
-- WHERE NOT EXISTS (SELECT name FROM authority WHERE name = 'ROLE_USER');
