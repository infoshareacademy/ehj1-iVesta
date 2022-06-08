INSERT INTO drivers(ID, STATUS, LAST_NAME, LICENSE, NAME)
VALUES ('9e01475a-c61e-11ec-9d64-0242ac120002', 'ACTIVE', 'Sram', 'A', 'Janusz'),
       ('9e014a34-c61e-11ec-9d64-0242ac12000', 'ACTIVE', 'Jachaś', 'C+E', 'Domino'),
       ('9e015b82-c61e-11ec-9d64-0242ac12000', 'INACTIVE', 'Bomba', 'B', 'Tytus'),
       ('9e01598e-c61e-11ec-9d64-0242ac12000', 'ACTIVE', 'Koczkodan', 'A', 'Sniezny'),
       ('9e01597e-c61e-11ec-9d64-0242ac12000', 'ACTIVE', 'Bomba', 'B', 'Bogdan'),
       ('9b9b67fc-c61e-11ec-9d64-0242ac120002', 'ACTIVE', 'Noomi', 'B', 'Rapace'),
       ('ad2d0fac-c61e-11ec-9d64-0242ac120002', 'INACTIVE', 'Logan', 'C', 'Marshall-Green'),
       ('afb81afa-c61e-11ec-9d64-0242ac120002', 'ACTIVE', 'Michael', 'B', 'Fassbender'),
       ('b1f999ba-c61e-11ec-9d64-0242ac120002', 'ACTIVE', 'Charlize', 'B', 'Theron'),
       ('0cf1f588-c61f-11ec-9d64-0242ac120002', 'ACTIVE', 'Sienna', 'C', 'Miller'),
       ('0e891a8e-c61f-11ec-9d64-0242ac120002', 'ACTIVE', 'Tom', 'B', 'Holland'),
       ('13041ece-c61f-11ec-9d64-0242ac120002', 'INACTIVE', 'Eddie', 'B', 'Redmayne'),
       ('149164a4-c61f-11ec-9d64-0242ac120002', 'INACTIVE', 'Katherine', 'B', 'Waterston'),
       ('166196a0-c61f-11ec-9d64-0242ac120002', 'ACTIVE', 'Alison', 'B', 'Sudol'),
       ('182c7e96-c61f-11ec-9d64-0242ac120002', 'ACTIVE', 'Dan', 'A', 'Fogler'),
       ('19a6a4cc-c61f-11ec-9d64-0242ac120002', 'ACTIVE', 'James', 'B', 'McAvoy'),
       ('1b8e4c90-c61f-11ec-9d64-0242ac120002', 'INACTIVE', 'Anya', 'A', 'Taylor-Joy');

INSERT INTO vehicles(ID, BRAND, MODEL, NUMBER_OF_SEATS, LICENSE, WEIGHT_LIMIT)
VALUES ('56d60854-c621-11ec-9d64-0242ac120002', 'Man', 'XYZ 9001', 3, 'C', 2000),
       ('59096968-c621-11ec-9d64-0242ac120002', 'Man', 'XYZ 9002', 2, 'C', 2000),
       ('5aae7452-c621-11ec-9d64-0242ac120002', 'Man', 'XYZ 9003', 2, 'C', 2000),
       ('5c1f1d46-c621-11ec-9d64-0242ac120002', 'Man', 'XYZ 9004', 2, 'C', 2000),
       ('604bdfbc-c621-11ec-9d64-0242ac120002', 'Toyota', 'Super X Extra Mocny M', 8, 'B', 1500),
       ('619d1bce-c621-11ec-9d64-0242ac120002', 'Toyota', 'Super X Extra Mocny L', 8, 'B', 1500),
       ('633ab108-c621-11ec-9d64-0242ac120002', 'Toyota', 'Super X Extra Mocny XL', 8, 'B', 1500),
       ('82015ae2-c621-11ec-9d64-0242ac120002', 'Volvo', 'Mocarny 100', 3, 'C+E', 15000),
       ('84560de2-c621-11ec-9d64-0242ac120002', 'Volvo', 'Mocarny 70', 3, 'C+E', 15000),
       ('8638c37a-c621-11ec-9d64-0242ac120002', 'Volvo', 'Mocarny 60', 3, 'C+E', 15000),
       ('87fc1c70-c621-11ec-9d64-0242ac120002', 'Volvo', 'Mocarny 50', 3, 'C+E', 15000);



INSERT INTO routes(ID, DATE, DESTINATION_ADDRESS, ROUTE_LENGTH, START_ADDRESS, TRANSPORT_TYPE, TRANSPORT_VOLUME,
                   DRIVER_ID, VEHICLE_ID)
VALUES ('0fc02df0-ca1d-11ec-9d64-0242ac120002', '2022-05-03', 'Kraków', 800, 'Sopot', 'PASSENGERS', 3,
        '19a6a4cc-c61f-11ec-9d64-0242ac120002', '56d60854-c621-11ec-9d64-0242ac120002'),
       ('0fc02fda-ca1d-11ec-9d64-0242ac120002', '2022-05-09', 'Gdynia', 100, 'Sopot', 'CARGO', 100,
        '1b8e4c90-c61f-11ec-9d64-0242ac120002', '59096968-c621-11ec-9d64-0242ac120002');

INSERT INTO routes(ID, DATE, DESTINATION_ADDRESS, ROUTE_LENGTH, START_ADDRESS, TRANSPORT_TYPE, TRANSPORT_VOLUME,
                   DRIVER_ID)
VALUES ('0fc030fc-cb1d-11ec-9d64-0242ac120002', '2022-05-10', 'Warszawa', 300, 'Sopot', 'PASSENGERS', 2,
        '0e891a8e-c61f-11ec-9d64-0242ac120002');

INSERT INTO routes(ID, DATE, DESTINATION_ADDRESS, ROUTE_LENGTH, START_ADDRESS, TRANSPORT_TYPE, TRANSPORT_VOLUME,
                   VEHICLE_ID)
VALUES ('0fc030fc-cc1d-11ec-9d64-0242ac120002', '2022-05-12', 'Gdańsk', 200, 'Olsztyn', 'PASSENGERS', 2,
        '8638c37a-c621-11ec-9d64-0242ac120002');

INSERT INTO routes(ID, DATE, DESTINATION_ADDRESS, ROUTE_LENGTH, START_ADDRESS, TRANSPORT_TYPE, TRANSPORT_VOLUME)
VALUES ('0fc030fc-ca1d-11ec-9d64-0242ac120002', '2022-05-08', 'Gdańsk', 200, 'Sopot', 'PASSENGERS', 2),
       ('0fc0321e-ca1d-11ec-9d64-0242ac120002', '2022-05-07', 'Wrocław', 1000, 'Sopot', 'CARGO', 544),
       ('0fc0348a-ca1d-11ec-9d64-0242ac120002', '2022-05-06', 'Warszawa', 500, 'Sopot', 'PASSENGERS', 5),
       ('0fc03598-ca1d-11ec-9d64-0242ac120002', '2022-05-05', 'Lublin', 700, 'Sopot', 'CARGO', 60),
       ('0fc0369c-ca1d-11ec-9d64-0242ac120002', '2022-05-04', 'Katowice', 1200, 'Sopot', 'PASSENGERS', 4);