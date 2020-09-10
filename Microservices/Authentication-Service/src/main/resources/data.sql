-- AUTHORITIES
INSERT INTO authority (name) VALUES ('ROLE_ADMIN');
INSERT INTO authority (name) VALUES ('ROLE_NORMAL_USER');
INSERT INTO authority (name) VALUES ('ROLE_AGENT');

-- ADMINS
INSERT INTO admin (username, password, first_name, last_name, email)
VALUES ('admin1', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'Admin1', 'Adminic1', 'admin1@gmail.com');
INSERT INTO admin (username, password, first_name, last_name, email)
VALUES ('admin2', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'Admin1', 'Adminic1', 'admin1@gmail.com');
INSERT INTO admin (username, password, first_name, last_name, email)
VALUES ('admin3', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'Admin1', 'Adminic1', 'admin1@gmail.com');
INSERT INTO admin_authority (admin_id, authority_id) VALUES (1, 1);
INSERT INTO admin_authority (admin_id, authority_id) VALUES (2, 1);
INSERT INTO admin_authority (admin_id, authority_id) VALUES (3, 1);


-- AGENTS
INSERT INTO agent (username, password, first_name, last_name, email, address, business_registration_number, company_name, is_banned)
VALUES ('agent1', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'Agent1', 'Agentic1', 'agent1@gmail.com', 'Brown St. 1', '123456789', 'FTN', false);
INSERT INTO agent (username, password, first_name, last_name, email, address, business_registration_number, company_name, is_banned)
VALUES ('agent2', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'Agent1', 'Agentic1', 'agent1@gmail.com', 'Brown St. 1', '123456789', 'FTN', false);
INSERT INTO agent (username, password, first_name, last_name, email, address, business_registration_number, company_name, is_banned)
VALUES ('agent3', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'Agent1', 'Agentic1', 'agent1@gmail.com', 'Brown St. 1', '123456789', 'FTN', false);

INSERT INTO agent_authority (agent_id, authority_id) VALUES (1, 3);
INSERT INTO agent_authority (agent_id, authority_id) VALUES (2, 3);

INSERT INTO agent_authority (agent_id, authority_id) VALUES (3, 3);


-- NORMAL USERS
INSERT INTO normal_user (username, password, first_name, last_name, email, country, phone_number, address, city, number_of_ads, is_banned,rank)
VALUES ('user1', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'User1', 'Useric1', 'user1@gmail.com', 'Serbia', '+38112345678', 'Neka Adresa St. 1', 'Novi Sad', 0, false,0);
INSERT INTO normal_user (username, password, first_name, last_name, email, country, phone_number, address, city, number_of_ads, is_banned,rank)
VALUES ('user2', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'User1', 'Useric1', 'user1@gmail.com', 'Serbia', '+38112345678', 'Neka Adresa St. 1', 'Novi Sad', 0, false,4);
INSERT INTO normal_user (username, password, first_name, last_name, email, country, phone_number, address, city, number_of_ads, is_banned)
VALUES ('user3', '$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi', 'User1', 'Useric1', 'user1@gmail.com', 'Serbia', '+38112345678', 'Neka Adresa St. 1', 'Novi Sad', 0, false);

--AGENCIES
INSERT INTO agency (agency_name,agency_leader_id)
VALUES ('Agencija1',2);
INSERT INTO agency (agency_name)
VALUES ('Agencija2');

INSERT INTO transportation_vehicle(brand,model,type)
VALUES ('BRAND1','MODEL1',1);

INSERT INTO normal_user_authority (normal_user_id, authority_id) VALUES (1, 2);
INSERT INTO normal_user_authority (normal_user_id, authority_id) VALUES (2, 2);
INSERT INTO normal_user_authority (normal_user_id, authority_id) VALUES (3, 2);
