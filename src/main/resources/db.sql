create table PLAYER(id serial, username varchar, password varchar, fname varchar, sname varchar, club varchar, teamcolour varchar, primary key(id));
create table GAME(id serial, venue varchar, matchDate varchar, winner varchar, primary key(id));
create table GAMEPLAYERS(id serial, gameID int, playerID int, primary key(id));
