CREATE TABLE brand (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  slug varchar(500),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE product (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  short_description varchar(500),
  price bigint(20),
  stock int(11),
  sold int(11),
  brand_id int(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (brand_id) REFERENCES brand(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE review (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(100) NOT NULL,
  short_description varchar(500),
  rating int(11) NOT NULL,
  product_id int(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;