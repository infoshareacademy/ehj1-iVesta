INSERT INTO drivers(ID, LAST_NAME,PHONE_NUMBER, LICENSE, NAME,AVAILABILITY)
VALUES ('9e01475a-c61e-11ec-9d64-0242ac120002', 'Sram', '123456789','A', 'Janusz','ACTIVE'),
       ('9e014a34-c61e-11ec-9d64-0242ac12000', 'Jachaś', '123456789','C_E', 'Domino','ACTIVE'),
       ('9e015b82-c61e-11ec-9d64-0242ac12000', 'Bomba', '123456789','B', 'Tytus','ACTIVE'),
       ('9e01598e-c61e-11ec-9d64-0242ac12000', 'Koczkodan', '123456789','A', 'Sniezny','ACTIVE'),
       ('9e01597e-c61e-11ec-9d64-0242ac12000', 'Bomba', '123456789','B', 'Bogdan','ACTIVE'),
       ('9b9b67fc-c61e-11ec-9d64-0242ac120002', 'Noomi', '123456789','B', 'Rapace','ACTIVE'),
       ('ad2d0fac-c61e-11ec-9d64-0242ac120002', 'Logan', '123456789','C', 'Marshall-Green','ACTIVE'),
       ('afb81afa-c61e-11ec-9d64-0242ac120002', 'Michael', '123456789','B', 'Fassbender','ACTIVE'),
       ('b1f999ba-c61e-11ec-9d64-0242ac120002', 'Charlize', '123456789','B', 'Theron','ACTIVE'),
       ('0cf1f588-c61f-11ec-9d64-0242ac120002', 'Sienna', '123456789','C', 'Miller','ACTIVE'),
       ('0e891a8e-c61f-11ec-9d64-0242ac120002', 'Tom', '123456789','B', 'Holland','ACTIVE'),
       ('13041ece-c61f-11ec-9d64-0242ac120002', 'Eddie', '123456789','B', 'Redmayne','ACTIVE'),
       ('149164a4-c61f-11ec-9d64-0242ac120002', 'Katherine', '123456789','B', 'Waterston','ACTIVE'),
       ('166196a0-c61f-11ec-9d64-0242ac120002', 'Alison', '123456789','B', 'Sudol','ACTIVE'),
       ('182c7e96-c61f-11ec-9d64-0242ac120002', 'Dan', '123456789','A', 'Fogler','ACTIVE'),
       ('19a6a4cc-c61f-11ec-9d64-0242ac120002', 'James', '123456789','B', 'McAvoy','ACTIVE'),
       ('1b8e4c90-c61f-11ec-9d64-0242ac120002', 'Anya', '123456789','A', 'Taylor-Joy','ACTIVE');

INSERT INTO vehicles(ID, VEHICLE_STATUS, BRAND, MODEL, NUMBER_OF_SEATS,LICENSE, VEHICLE_CATEGORY,FUEL_TYPE, WEIGHT_LIMIT)
VALUES ('56d60854-c621-11ec-9d64-0242ac120002','ACTIVE','Man', 'XYZ 9001', 3,'C' ,'Dostawczy','gasoline', 2000),
       ('59096968-c621-11ec-9d64-0242ac120002','ACTIVE','Man', 'XYZ 9002', 2, 'C','Dostawczy', 'gasoline',2000),
       ('5aae7452-c621-11ec-9d64-0242ac120002','ACTIVE','Man', 'XYZ 9003', 2, 'C' ,'Dostawczy', 'gasoline',2000),
       ('5c1f1d46-c621-11ec-9d64-0242ac120002','INACTIVE','Man', 'XYZ 9004', 2, 'C' ,'Dostawczy', 'gasoline',2000),
       ('604bdfbc-c621-11ec-9d64-0242ac120002','ACTIVE','Toyota', 'Super X Extra Mocny M', 8, 'C' ,'Osobowy', 'diesel',1500),
       ('619d1bce-c621-11ec-9d64-0242ac120002','ACTIVE','Toyota', 'Super X Extra Mocny L', 8, 'B' ,'Osobowy', 'gasoline',1500),
       ('633ab108-c621-11ec-9d64-0242ac120002','ACTIVE','Toyota', 'Super X Extra Mocny XL', 8, 'B' ,'Osobowy', 'gasoline',1500),
       ('82015ae2-c621-11ec-9d64-0242ac120002','INACTIVE','Volvo', 'Mocarny 100', 3, 'B' ,'Ciężarowy', 'gasoline',15000),
       ('84560de2-c621-11ec-9d64-0242ac120002','ACTIVE','Volvo', 'Mocarny 70', 3, 'C_E' ,'Ciężarowy', 'diesel',15000),
       ('8638c37a-c621-11ec-9d64-0242ac120002','ACTIVE','Volvo', 'Mocarny 60', 3, 'C_E' ,'Ciężarowy', 'gasoline',15000),
       ('87fc1c70-c621-11ec-9d64-0242ac120002','INACTIVE','Volvo', 'Mocarny 50', 3, 'C_E' ,'Ciężarowy', 'gasoline',15000);



INSERT INTO routes(ID, DATE, DESTINATION_ADDRESS, ROUTE_LENGTH, START_ADDRESS, TRANSPORT_TYPE, TRANSPORT_VOLUME,
                   DRIVER_ID, VEHICLE_ID)
VALUES ('0fc02df0-ca1d-11ec-9d64-0242ac120002', '2022-05-03', 'Kraków', 800, 'Sopot', 'PASSENGERS', 3,
        '19a6a4cc-c61f-11ec-9d64-0242ac120002', '56d60854-c621-11ec-9d64-0242ac120002'),
       ('0fc02fda-ca1d-11ec-9d64-0242ac120002', '2022-05-09', 'Gdynia', 100, 'Sopot', 'CARGO', 100,
        '1b8e4c90-c61f-11ec-9d64-0242ac120002', '59096968-c621-11ec-9d64-0242ac120002');

INSERT INTO routes(ID, DATE, DESTINATION_ADDRESS, ROUTE_LENGTH, START_ADDRESS, TRANSPORT_TYPE, TRANSPORT_VOLUME)
VALUES ('0fc030fc-ca1d-11ec-9d64-0242ac120002', '2022-05-08', 'Gdańsk', 200, 'Sopot', 'PASSENGERS', 2),
       ('0fc0321e-ca1d-11ec-9d64-0242ac120002', '2022-05-07', 'Wrocław', 1000, 'Sopot', 'CARGO', 544),
       ('0fc0348a-ca1d-11ec-9d64-0242ac120002', '2022-05-06', 'Warszawa', 500, 'Sopot', 'PASSENGERS', 5),
       ('0fc03598-ca1d-11ec-9d64-0242ac120002', '2022-05-05', 'Lublin', 700, 'Sopot', 'CARGO', 60),
       ('0fc0369c-ca1d-11ec-9d64-0242ac120002', '2022-05-04', 'Katowice', 1200, 'Sopot', 'PASSENGERS', 4);