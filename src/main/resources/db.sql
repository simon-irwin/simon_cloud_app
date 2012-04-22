create table PLAYER(id serial, username varchar, password varchar, fname varchar, sname varchar, club varchar, teamcolour varchar, primary key(id));
create table GAME(id serial, venue varchar, matchDate varchar, winner varchar, primary key(id));
create table users(username varchar_ignorecase(50) not null primary key, password varchar_ignorecase(50) not null, enabled boolean not null);
create table authorities(username varchar_ignorecase(50) not null, authority varchar_ignorecase(50) not null, constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);
INSERT INTO users VALUES ('simon', '42de08860cabc17a86260e70a95b03e5', true);
INSERT INTO authorities VALUES ('simon', 'ROLE_ADMIN');