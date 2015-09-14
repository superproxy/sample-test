drop TABLE  Users if EXISTS ;
CREATE TABLE Users (
  name VARCHAR(20)   PRIMARY KEY ,
    password   VARCHAR(10) NOT NULL,
    age  int  DEFAULT  0
) ;

