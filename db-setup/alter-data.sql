-- alter commands to dapartments table
-- change column to int auto_increment

update `departments` set `id`=1 where id='d001';
update `departments` set `id`=2 where id='d002';
update `departments` set `id`=3 where id='d003';
update `departments` set `id`=4 where id='d004';
update `departments` set `id`=5 where id='d005';
update `departments` set `id`=6 where id='d006';
update `departments` set `id`=7 where id='d007';
update `departments` set `id`=8 where id='d008';
update `departments` set `id`=9 where id='d009';

alter table `departments` modify column id int auto_increment;

alter table `dept_manager` modify column dept_no int;

-- add status column to employee
alter table `employees` add column status enum('ACTIVE','INACTIVE') NOT NULL default 'ACTIVE';

-- make employees id to auto_increment
alter table `employees` modify column id bigint auto_increment;

-- add sample users and authority
insert into `users` values (1,'admin','12345'); -- admin user
insert into `users` values (2,'hr','12345'); -- hr user
insert into `users` values (10001,'georgi','1234'); -- regular user
insert into `users` values (10002,'bazael','1234'); -- regular user

-- roles
-- Regular employee - ROLE_VIEW_PROFILE,ROLE_SEARCH,ROLE_LOGIN,ROLE_CHANGE_PASSWORD
-- HR Ex -  Re Em + ROLE_UPDATE_PROFILE, ROLE_CREATE_PROFILE
-- admin - Hr Ex + ROLE_CREATE_DEPARTMENT,ROLE_USER_ACCOUNT_CREATION , ROLE_ADMIN_LOGIN
insert into `authority` values(1,'ROLE_ADMIN_LOGIN','ADMIN_USER');
insert into `authority` values(1,'ROLE_CREATE_USER_ACCOUNT','ADMIN_USER');
insert into `authority` values(1,'ROLE_CREATE_DEPARTMENT','ADMIN_USER');
insert into `authority` values(1,'ROLE_UPDATE_PROFILE','ADMIN_USER');
insert into `authority` values(1,'ROLE_CREATE_PROFILE','ADMIN_USER');
insert into `authority` values(1,'ROLE_VIEW_PROFILE','ADMIN_USER');
insert into `authority` values(1,'ROLE_SEARCH','ADMIN_USER');
insert into `authority` values(1,'ROLE_CHANGE_PASSWORD','ADMIN_USER');

insert into `authority` values(2,'ROLE_HR_LOGIN','HR_EXECUTIVE');
insert into `authority` values(2,'ROLE_UPDATE_PROFILE','HR_EXECUTIVE');
insert into `authority` values(2,'ROLE_CREATE_PROFILE','HR_EXECUTIVE');
insert into `authority` values(2,'ROLE_VIEW_PROFILE','HR_EXECUTIVE');
insert into `authority` values(2,'ROLE_SEARCH','HR_EXECUTIVE');
insert into `authority` values(2,'ROLE_CHANGE_PASSWORD','HR_EXECUTIVE');

insert into `authority` values(10001,'ROLE_USER_LOGIN','NORMAL_USER');
insert into `authority` values(10001,'ROLE_VIEW_PROFILE','NORMAL_USER');
insert into `authority` values(10001,'ROLE_SEARCH','NORMAL_USER');
insert into `authority` values(10001,'ROLE_CHANGE_PASSWORD','NORMAL_USER');