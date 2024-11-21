use kayanapi_db;
CREATE TABLE users
(
  id BIGINT NOT NULL,
  fname VARCHAR(25) NOT NULL,
  lname VARCHAR(25) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  country VARCHAR(30) NOT NULL,
  city VARCHAR(30) NOT NULL,
  street VARCHAR(40) NOT NULL,
  sid VARCHAR(14),
  email VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  job_title VARCHAR(50) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (phone),
  UNIQUE (sid),
  UNIQUE (email)
);

CREATE TABLE contact_us
(
  id BIGINT NOT NULL,
  message_type VARCHAR(100) NOT NULL,
  message_content LONGTEXT NOT NULL,
  user_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE products
(
  id BIGINT NOT NULL,
  name VARCHAR(255) NOT NULL,
  description LONGTEXT NOT NULL,
  is_available CHAR(5) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (name)
);

CREATE TABLE askfor
(
  product_id BIGINT NOT NULL,
  user_id BIGINT NOT NULL,
  PRIMARY KEY (product_id, user_id),
  FOREIGN KEY (product_id) REFERENCES products(id),
  FOREIGN KEY (user_id) REFERENCES users(id)
);
