-- create table commands
-- storage engine - MyISAM
-- no foreign key for decoupled the database tables

DROP TABLE IF EXISTS `employees`;
create table `employees`(
  `id` bigint(20) NOT NULL ,
  `birth_date` date NOT NULL,
  `first_name` varchar(50),
  `last_name` varchar(50),
  `gender` enum('M','F') NOT NULL,
  `hire_date` date ,
  primary key(id)
);

DROP TABLE IF EXISTS `departments`;
create table `departments`(
  `id` char(4) NOT NULL ,
  `name` varchar(30) not null,
  primary key(id)
);

DROP TABLE IF EXISTS `users`;
create table `users`(
  `emp_no` bigint(20) NOT NULL ,
  `username` varchar(30) not null,
  `password` varchar(80) not null
);

DROP TABLE IF EXISTS `authority`;
create table `authority` (
`id` bigint(20) NOT NULL ,
`role` VARCHAR (50) NOT NULL
 );

DROP TABLE IF EXISTS `salaries`;
create table `salaries` (
`emp_no` bigint(20) NOT NULL ,
`salary` double(15,3) NOT NULL ,
`from_date` date NOT NULL,
`to_date` date NOT NULL
);

DROP TABLE IF EXISTS `titles`;
create table `titles` (
`emp_no` bigint(20) NOT NULL ,
`title` varchar(50) NOT NULL ,
`from_date` date NOT NULL,
`to_date` date NOT NULL
);

DROP TABLE IF EXISTS `dept_manager`;
create table `dept_manager` (
`dept_no` char(4),
`emp_no` bigint(20) NOT NULL ,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
primary key(dept_no,emp_no)
);

DROP TABLE IF EXISTS `dept_emp`;
create table `dept_emp` (
`emp_no` bigint(20) NOT NULL ,
`dept_no` char(4),
`from_date` date NOT NULL,
`to_date` date NOT NULL,
primary key(dept_no,emp_no)
);
