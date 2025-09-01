CREATE TABLE Client (
                        id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                        name VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3)
);

CREATE TABLE Planet (
                        id VARCHAR(100) PRIMARY KEY NOT NULL CHECK (id REGEXP '^[A-Z0-9]+$') ,
                        name VARCHAR(500) NOT NULL CHECK (LENGTH(name) >= 1)
);

CREATE TABLE ticket (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        client_id BIGINT NOT NULL,
                        from_planet_id VARCHAR(100) NOT NULL,
                        to_planet_id VARCHAR(100) NOT NULL,

                        CONSTRAINT fk_ticket_client
                            FOREIGN KEY (client_id) REFERENCES client(id)
                                ON DELETE CASCADE ON UPDATE CASCADE,

                        CONSTRAINT fk_ticket_from_planet
                            FOREIGN KEY (from_planet_id) REFERENCES planet(id)
                                ON DELETE RESTRICT ON UPDATE CASCADE,

                        CONSTRAINT fk_ticket_to_planet
                            FOREIGN KEY (to_planet_id) REFERENCES planet(id)
                                ON DELETE RESTRICT ON UPDATE CASCADE
);