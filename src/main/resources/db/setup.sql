-- User and Schema creation
CREATE schema usher authorization "usher_db_user";

-- Table creation

CREATE TABLE usher.user (
  email VARCHAR(40) NOT NULL,
  first_name VARCHAR(80),
  last_name VARCHAR(80),
  pin VARCHAR(10),
  created_by VARCHAR(40) DEFAULT '',
  created_date TIMESTAMP WITHOUT TIME ZONE DEFAULT clock_timestamp(),
  updated_by VARCHAR(40) DEFAULT '',
  updated_date TIMESTAMP WITHOUT TIME ZONE DEFAULT clock_timestamp(),
  CONSTRAINT user_PK PRIMARY KEY (email)
);
