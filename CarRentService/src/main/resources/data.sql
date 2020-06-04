---- AUTHORITIES
--INSERT INTO authority (name) VALUES ('ROLE_ADMIN');
--INSERT INTO authority (name) VALUES ('ROLE_NORMAL_USER');
--INSERT INTO authority (name) VALUES ('ROLE_AGENT');
--
---- NORMAL USERS
--INSERT INTO normal_user (username, password, first_name, last_name, email, country, phone_number, address, city, number_of_ads, is_banned)
--VALUES ('user1', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'User1', 'Useric1', 'user1@gmail.com', 'Serbia', '+38112345678', 'Neka Adresa St. 1', 'Novi Sad', 2, false);
--INSERT INTO normal_user_authority (normal_user_id, authority_id) VALUES (1, 2);
--
---- ADMINS
--INSERT INTO admin (username, password, first_name, last_name, email)
--VALUES ('admin1', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'Admin1', 'Adminic1', 'admin1@gmail.com');
--INSERT INTO admin_authority (admin_id, authority_id) VALUES (1, 1);
--
---- AGENTS
--INSERT INTO agent (username, password, first_name, last_name, email, company_name, business_registration_number, address, pricelist_id, entity_type, is_banned)
--VALUES ('agent1', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'Agent1', 'Agentic1', 'agent1@gmail.com', 'FTN', '123-45-678', 'Hollywood St. 3', null, 'AGENT', false);
--INSERT INTO agent_authority (agent_id, authority_id) VALUES (1, 3);
--
--INSERT INTO agent (username, password, first_name, last_name, email, company_name, business_registration_number, address, pricelist_id, entity_type, is_banned)
--VALUES ('agent2', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'Agent2', 'Agentic2', 'agent2@gmail.com', 'FBI', '234-56-789', 'New York St. 5', null, 'AGENT', false);
--INSERT INTO agent_authority (agent_id, authority_id) VALUES (2, 3);
--
--INSERT INTO agent (username, password, first_name, last_name, email, company_name, business_registration_number, address, pricelist_id, entity_type, is_banned)
--VALUES ('company1', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'Company1', 'Companic1', 'companic1@gmail.com', 'NSA', '345-67-890', 'Washington Blvd. 4', null, 'COMPANY', false);
--INSERT INTO agent_authority (agent_id, authority_id) VALUES (3, 3);



insert into vehicle (brand, model, fuel_type, transmission_type, vehicle_type, price, travelled_mileage, planned_mileage_to_travel, is_mileage_unlimited, has_collision_damage_waiver, number_of_seats, grade, available, vehicle_discount, insurance_price)
values ('Mercedes', 'C klasa', 'GASOLINE', 'MANUAL', 'SEDAN', '15000', '2323', '232', 'false', 'false', '5', '5', 'true', '10', '300');

insert into vehicle (brand, model, fuel_type, transmission_type, vehicle_type, price, travelled_mileage, planned_mileage_to_travel, is_mileage_unlimited, has_collision_damage_waiver, number_of_seats, grade, available, vehicle_discount, insurance_price)
values ('Fiat', 'Punto', 'GASOLINE', 'MANUAL', 'SEDAN', '15000', '2323', '232', 'false', 'false', '5', '5', 'true', '10', '300');

insert into vehicle (brand, model, fuel_type, transmission_type, vehicle_type, price, travelled_mileage, planned_mileage_to_travel, is_mileage_unlimited, has_collision_damage_waiver, number_of_seats, grade, available, vehicle_discount, insurance_price)
values ('Peugeot', '207', 'GAS', 'AUTOMATIC', 'TRUCK', '15000', '2323', '232', 'false', 'false', '5', '5', 'true', '10', '300');


