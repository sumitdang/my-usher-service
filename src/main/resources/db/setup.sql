-- User and Schema creation
CREATE schema usher authorization "usher_db_user";

-- Table creation

CREATE TABLE usher.user (
  email VARCHAR(45) NOT NULL,
  first_name VARCHAR(45),
  last_name VARCHAR(45),
  pin VARCHAR(15),
  active Boolean DEFAULT true,
  created_by VARCHAR(45) DEFAULT '',
  created_date TIMESTAMP WITHOUT TIME ZONE DEFAULT clock_timestamp(),
  updated_by VARCHAR(45) DEFAULT '',
  updated_date TIMESTAMP WITHOUT TIME ZONE DEFAULT clock_timestamp(),
  CONSTRAINT user_PK PRIMARY KEY (email)
);
