drop TABLE  Users if EXISTS ;
CREATE TABLE Users (
  name VARCHAR(20)     ,
    password   VARCHAR(10),
    age  int  DEFAULT  0
) ;

