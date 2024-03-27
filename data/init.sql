INSERT INTO air_company (name, company_type, founded_at)
VALUES ('Ukraine International Airlines', 'International', '1992-10-01'),
       ('SkyUp Airlines', 'Domestic', '2016-06-05'),
       ('Windrose Airlines', 'Domestic', '2003-08-28'),
       ('Lufthansa', 'International', '1955-01-01'),
       ('British Airways', 'International', '1974-04-01'),
       ('Air France', 'International', '1933-10-07'),
       ('Ryanair', 'Low-cost', '1984-07-28'),
       ('EasyJet', 'Low-cost', '1995-11-10'),
       ('Turkish Airlines', 'International', '1933-05-20'),
       ('Emirates', 'International', '1985-03-25');

INSERT INTO airplane (name, factory_serial_number, air_company_id, number_of_flights, flight_distance, fuel_capacity,
                      type, created_at)
VALUES ('Boeing 737', '12345', 1, 100, 5000.0, 25000.0, 'Passenger', '2021-01-15T10:30:00'),
       ('Airbus A320', '67890', 1, 200, 4000.0, 20000.0, 'Passenger', '2020-07-20T14:45:00'),
       ('Embraer E190', '11223', 2, 50, 2500.0, 15000.0, 'Passenger', '2019-05-10T09:15:00'),
       ('Boeing 777', '44556', 3, 150, 7000.0, 35000.0, 'Cargo', '2022-03-05T11:00:00'),
       ('Airbus A380', '77888', 4, 300, 8000.0, 40000.0, 'Passenger', '2018-08-15T16:20:00'),
       ('Boeing 787', '99001', 5, 180, 6500.0, 32000.0, 'Passenger', '2020-02-10T12:45:00'),
       ('Airbus A319', '22334', 6, 80, 3200.0, 17000.0, 'Passenger', '2017-04-05T08:00:00'),
       ('Boeing 737 MAX', '45677', 7, 220, 5000.0, 25000.0, 'Passenger', '2019-11-20T09:30:00'),
       ('Airbus A321', '67899', 8, 110, 4200.0, 21000.0, 'Passenger', '2021-06-15T14:00:00'),
       ('Embraer E195', '11224', 9, 60, 2700.0, 16000.0, 'Passenger', '2018-03-10T10:15:00');

INSERT INTO flight (flight_status, air_company_id, airplane_id, departure_country, destination_country, distance,
                    estimated_flight_time, created_at)
VALUES ('ON_TIME', 1, 1, 'Ukraine', 'Germany', 1200.0, 180, '2022-03-10T10:00:00'),
       ('DELAYED', 1, 2, 'Ukraine', 'France', 1500.0, 210, '2022-03-11T14:30:00'),
       ('ON_TIME', 2, 3, 'Ukraine', 'Turkey', 1000.0, 150, '2022-03-12T09:45:00'),
       ('DELAYED', 3, 4, 'Ukraine', 'USA', 6000.0, 720, '2022-03-13T12:15:00'),
       ('ON_TIME', 4, 5, 'Germany', 'USA', 4000.0, 480, '2022-03-14T15:00:00'),
       ('DELAYED', 5, 6, 'UK', 'France', 500.0, 60, '2022-03-15T11:30:00'),
       ('ON_TIME', 6, 7, 'France', 'Italy', 700.0, 90, '2022-03-16T13:45:00'),
       ('DELAYED', 7, 8, 'Spain', 'Portugal', 300.0, 40, '2022-03-17T10:00:00'),
       ('ON_TIME', 8, 9, 'Turkey', 'Greece', 400.0, 50, '2022-03-18T16:15:00'),
       ('DELAYED', 9, 10, 'UAE', 'India', 2000.0, 240, '2022-03-19T09:30:00');
