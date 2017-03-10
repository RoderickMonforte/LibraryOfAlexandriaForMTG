CREATE TABLE Card
(
  Collection_collection_id INT(11) NOT NULL,
  universalCardId VARCHAR(32) NOT NULL,
  owned_qy INT(11) NOT NULL,
  wishlist_qy INT(11) NOT NULL,
  note_tx VARCHAR(128),
  CONSTRAINT `PRIMARY` PRIMARY KEY (Collection_collection_id, universalCardId),
  CONSTRAINT Card_Collection_collection_id_fk FOREIGN KEY (Collection_collection_id) REFERENCES Collection (collection_id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX card_id_UNIQUE ON Card (universalCardId);
CREATE INDEX fk_Card_Collection1_idx ON Card (Collection_collection_id);
CREATE TABLE Collection
(
  collection_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  User_user_id VARCHAR(12) NOT NULL,
  display_nm VARCHAR(45) NOT NULL,
  description_tx VARCHAR(128),
  note_tx VARCHAR(128),
  price_at DECIMAL(9,2),
  CONSTRAINT fk_Collection_User FOREIGN KEY (User_user_id) REFERENCES User (user_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE UNIQUE INDEX collection_id_UNIQUE ON Collection (collection_id);
CREATE INDEX fk_Collection_User_idx ON Collection (User_user_id);
CREATE TABLE User
(
  user_id VARCHAR(12) PRIMARY KEY NOT NULL,
  display_nm VARCHAR(60) NOT NULL,
  password_tx VARCHAR(20) NOT NULL,
  role_cd VARCHAR(12) DEFAULT 'user' NOT NULL
);