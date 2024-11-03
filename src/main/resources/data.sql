CREATE TABLE coin(
    NAME VARCHAR(100),
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    DATETIME TIMESTAMP,
    PRICE NUMERIC(20 ,2),
    QUANTITY NUMERIC(20,10)
);