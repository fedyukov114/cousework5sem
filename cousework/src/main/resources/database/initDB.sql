CREATE TABLE IF NOT EXISTS people
(
    scorebookNumber INTEGER PRIMARY KEY ,
    fullName varchar(200) NOT NULL ,
    groupNumber varchar(200) NOT NULL
);
CREATE SEQUENCE people_id_seq START WITH 6 INCREMENT BY 1;
CREATE TABLE IF NOT EXISTS philosophy
(
    scorebookNumber INTEGER PRIMARY KEY  ,
    mark int ,
    subject varchar(200) NOT NULL
);
CREATE TABLE IF NOT EXISTS economy
(
    scorebookNumber INTEGER PRIMARY KEY  ,
    mark int ,
    subject varchar(200) NOT NULL
);
CREATE TABLE IF NOT EXISTS literature
(
    scorebookNumber INTEGER PRIMARY KEY  ,
    mark int ,
    subject varchar(200) NOT NULL
)