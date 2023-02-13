INSERT INTO region(id,country) VALUES(1,'EU');
INSERT INTO region(id,country) VALUES(2,'USA');
INSERT INTO region(id,country) VALUES(3,'UK');


INSERT INTO game(id,name,description,external_id,active) VALUES(1,'BakeIt','Funny Game Who Likes Food',323435,true);
INSERT INTO game(id,name,description,external_id,active) VALUES(2,'NinjaMaster','For Ninjas in Pyjamas',223435,true);
INSERT INTO game(id,name,description,external_id,active) VALUES(3,'CrushCandy','Sweet like Winning ',123435,true);


INSERT INTO player(id,name) VALUES(1,'William');
INSERT INTO player(id,name) VALUES(2,'Jefferson');
INSERT INTO player(id,name) VALUES(3,'Alex');
INSERT INTO player(id,name) VALUES(4,'Ryan');

INSERT INTO register(id,player_id,game_id,region_id,player_level) VALUES(1,1,1,1,1);
INSERT INTO register(id,player_id,game_id,region_id,player_level) VALUES(2,1,2,1,3);
INSERT INTO register(id,player_id,game_id,region_id,player_level) VALUES(3,1,3,1,2);
INSERT INTO register(id,player_id,game_id,region_id,player_level) VALUES(4,2,3,2,2);
INSERT INTO register(id,player_id,game_id,region_id,player_level) VALUES(5,3,1,2,2);
