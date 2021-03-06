CREATE TABLE ITEM (ITEMID INTEGER NOT NULL, DESCRIPTION VARCHAR(255), IMAGEURL VARCHAR(255), PRICE DOUBLE, TITLE VARCHAR(255), TYPE VARCHAR(255), USERID INTEGER, OWNER_USERID INTEGER, PRIMARY KEY (ITEMID))
CREATE TABLE USER (USERID INTEGER NOT NULL, CODEPOSTAL INTEGER, EMAIL VARCHAR(255), FNAME VARCHAR(255), LNAME VARCHAR(255), PASSWORD VARCHAR(255), USERNAME VARCHAR(255), PRIMARY KEY (USERID))
CREATE TABLE USER_ITEM (User_USERID INTEGER NOT NULL, Items_ITEMID INTEGER NOT NULL, PRIMARY KEY (User_USERID, Items_ITEMID))
ALTER TABLE ITEM ADD CONSTRAINT FK_ITEM_OWNER_USERID FOREIGN KEY (OWNER_USERID) REFERENCES USER (USERID)
ALTER TABLE USER_ITEM ADD CONSTRAINT FK_USER_ITEM_User_USERID FOREIGN KEY (User_USERID) REFERENCES USER (USERID)
ALTER TABLE USER_ITEM ADD CONSTRAINT FK_USER_ITEM_Items_ITEMID FOREIGN KEY (Items_ITEMID) REFERENCES ITEM (ITEMID)
