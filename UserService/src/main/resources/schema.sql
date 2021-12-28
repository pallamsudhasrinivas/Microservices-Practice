DROP TABLE IF EXISTS TBL_EMPLOYEES;

CREATE TABLE TBL_EMPLOYEES (
                               id INT AUTO_INCREMENT  PRIMARY KEY,
                               emp_name VARCHAR(250) NOT NULL,
                               department VARCHAR(250) NOT NULL,
                               email VARCHAR(250) DEFAULT NULL,
                               company VARCHAR(250) DEFAULT NULL,
                               username VARCHAR(250) DEFAULT NULL,
                               password VARCHAR(250) DEFAULT NULL
);