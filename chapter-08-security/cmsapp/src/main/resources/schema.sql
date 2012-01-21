
--CREATE TABLE security_users (id INTEGER IDENTITY, username VARCHAR(50), password VARCHAR(50), enabled BOOLEAN );

--CREATE TABLE security_authorities (id INTEGER IDENTITY, authority VARCHAR(50) );

--CREATE TABLE security_role_assignments (id INTEGER IDENTITY, user_id VARCHAR(50), role_id INTEGER);


--CREATE TABLE security_users (username VARCHAR(50), password VARCHAR(50), enabled BOOLEAN );

--CREATE TABLE security_authorities (username VARCHAR(50), authority VARCHAR(50) );


CREATE TABLE security_principals (username VARCHAR(10), password VARCHAR(20), enabled BOOLEAN );

CREATE TABLE security_authorities (roleId VARCHAR(10), authority VARCHAR(10) );

CREATE TABLE security_role_assignments (username VARCHAR(10), roleId VARCHAR(10) );

