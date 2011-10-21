
-- INSERT INTO security_users (username, password, enabled) VALUES ('admin', 'test', true);

-- insert into security_users(username, password, enabled) values
-- 		('admin','admin',true);
-- insert into security_authorities(username,authority) values
-- 	('admin','ROLE_USER');
-- insert into security_authorities(username,authority) values
-- 	('admin','ROLE_ADMIN');

-- insert into security_users(username, password, enabled) values
-- 	('guest','guest',true);
-- insert into security_authorities(username,authority) values
-- 	('guest','ROLE_USER');
-- commit;

insert into security_principals(username, password, enabled) values
		('admin','admin',true);

insert into security_authorities(roleId,authority) values
	('USER','ROLE_USER');
insert into security_authorities(roleId,authority) values
	('ADMIN','ROLE_ADMIN');

insert into security_principals(username, password, enabled) values
	('guest','guest',true);

insert into security_role_assignments(username, roleId) values
	('admin','ADMIN');

	insert into security_role_assignments(username, roleId) values
	('guest','USER');

commit;
