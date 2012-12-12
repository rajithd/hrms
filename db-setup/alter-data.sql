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

-- add status column to employee
alter table `employees` add column status enum('ACTIVE','INACTIVE') NOT NULL default 'ACTIVE';

-- make employees id to auto_increment
alter table `employees` modify column id bigint auto_increment;

-- add sample users and authority
insert into `users` values (10001,'georgi','1234');
insert into `users` values (10002,'bazael','1234');