-- FUEL TYPES
insert into fuel_type (type) values ('Gasoline');
insert into fuel_type (type) values ('Diesel');

-- TRANSMISSION TYPES
insert into transmission_type (type) values ('Manual');
insert into transmission_type (type) values ('Automatic');

-- VEHICLE TYPES
insert into vehicle_type (type) values ('SUV');
insert into vehicle_type (type) values ('Caravan');

-- VEHICLES
insert into vehicle (brand, model, fuel_type_id, transmission_type_id, vehicle_type_id, price, travelled_mileage, planned_mileage_to_travel, is_mileage_unlimited, has_collision_damage_waiver, number_of_seats, grade, available, vehicle_discount, insurance_price)
values ('Mercedes', 'C klasa', 1, 1, 1, '15000', '2323', '232', 'false', 'false', '5', '5', 'true', '10', '300');
