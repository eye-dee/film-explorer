CREATE TABLE films
(
  id BIGSERIAL PRIMARY KEY,
  label VARCHAR(255) NOT NULL,
  description VARCHAR(10000) NOT NULL,
  release_date TIMESTAMP NOT NULL
);

