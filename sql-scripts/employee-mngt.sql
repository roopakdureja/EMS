CREATE DATABASE  IF NOT EXISTS `employee_db`;
USE `employee_db`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL UNIQUE,
    `department` VARCHAR(50) NOT NULL,
    `salary` DOUBLE NOT NULL,
    `date_of_joining` DATE NOT NULL, 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Insert 5 sample employee records
INSERT INTO `employee` (`name`, `email`, `department`, `salary`, `date_of_joining`) VALUES
('Roopak Dureja', 'roopak08@example.com', 'IT', 75000, '2022-06-01'),
('Ritik Sharma', 'ritik08@example.com', 'Marketing', 58000, '2021-09-15'),
('Satish Mehta', 'satish03@example.com', 'Finance', 82000, '2020-01-20'),
('Sunita Rao', 'sunita19@example.com', 'HR', 64000, '2019-11-10'),
('Ajay Kumar', 'ajay15@example.com', 'IT', 71000, '2023-03-25');