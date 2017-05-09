CREATE TABLE User
(
  user_id VARCHAR(12) PRIMARY KEY NOT NULL,
  display_nm VARCHAR(60) NOT NULL,
  password_tx VARCHAR(20) NOT NULL,
  role_cd VARCHAR(12) DEFAULT 'user' NOT NULL
);

CREATE TABLE Collection
(
  collection_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  User_user_id VARCHAR(12) NOT NULL,
  display_nm VARCHAR(45) NOT NULL,
  description_tx VARCHAR(128),
  note_tx VARCHAR(128),
  price_at DECIMAL(9,2),
  card_qy INT(11) DEFAULT '0' NOT NULL,
  CONSTRAINT Collection_fk FOREIGN KEY (User_user_id) REFERENCES User (user_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE UNIQUE INDEX collection_id_UNIQUE ON Collection (collection_id);
CREATE INDEX fk_Collection_User_idx ON Collection (User_user_id);


CREATE TABLE CardItem
(
  universal_card_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  multiverseId INT(11),
  artist VARCHAR(128),
  type VARCHAR(128),
  types VARCHAR(128),
  supertypes VARCHAR(128),
  subtypes VARCHAR(128),
  colors VARCHAR(128),
  setName VARCHAR(128),
  printings VARCHAR(128),
  imageUrl VARCHAR(128),
  flavor VARCHAR(1024),
  power VARCHAR(12),
  toughness VARCHAR(12),
  id VARCHAR(128),
  manaCost VARCHAR(128),
  cmc DOUBLE,
  rarity VARCHAR(32),
  layout VARCHAR(128),
  price DECIMAL(9,2),
  cardName VARCHAR(128),
  cardSet VARCHAR(128),
  cardText VARCHAR(1024),
  originalText VARCHAR(1024)
);
CREATE UNIQUE INDEX CardItem_id_uindex ON CardItem (id);
CREATE UNIQUE INDEX CardItem_multiverseId_uindex ON CardItem (multiverseId);
CREATE UNIQUE INDEX CardItem_universal_card_id_uindex ON CardItem (universal_card_id);
CREATE INDEX CardItem_name_index ON CardItem (cardName);

CREATE TABLE Card
(
  Collection_collection_id INT(11) NOT NULL,
  universal_card_id INT(11) NOT NULL,
  owned_qy INT(11) NOT NULL,
  wishlist_qy INT(11) NOT NULL,
  note_tx VARCHAR(128),
  price_at DECIMAL(9,2),
  card_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  CONSTRAINT Card_fk FOREIGN KEY (Collection_collection_id) REFERENCES Collection (collection_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE UNIQUE INDEX Card_universal_card_id_Collection_collection_id_uindex ON Card (universal_card_id, Collection_collection_id);
CREATE INDEX fk_Card_Collection1_idx ON Card (Collection_collection_id);
