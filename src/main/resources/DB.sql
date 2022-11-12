CREATE TABLE pokemon (

    id SERIAL PRIMARY KEY,
    name VARCHAR(255) unique not null ,
    image_front TEXT NOT NULL ,
    image_back TEXT not null ,
    quantity INTEGER DEFAULT 0


);