DROP TABLE IF EXISTS user;

CREATE TABLE user
(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   username VARCHAR(100) NOT NULL UNIQUE,
   password VARCHAR(100) NOT NULL,
   roles VARCHAR(100)
);
