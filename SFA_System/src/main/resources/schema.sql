CREATE TABLE IF NOT EXISTS Clientlist (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  client_name varchar(255),
  company_name varchar(255),
  location varchar(255),
  mail varchar(255),
  phone_number real,
  capital real,
  --industry varchar(255),
  --employees real,
  --representative varchar(255),
  --person_in_charge varchar(255),
  --remarks varchar(255),
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE IF NOT EXISTS Productlist (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  product_name varchar(255),
  category varchar(255),
  regular_price real,
  unit varchar(255),
  maker varchar(255),
  product_specification varchar(255),
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS Dailyreport (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  dateandtime DATE,
  person_in_charge varchar(255),
  activitytime varchar(255),
  activityconent varchar(255),
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;