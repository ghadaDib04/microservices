

CREATE TABLE orders (
                        id BIGINT(20) NOT NULL AUTO_INCREMENT,
                        order_number VARCHAR(255) DEFAULT NULL,
                        sku_code VARCHAR(255),
                        order_status VARCHAR(255),
                        price DECIMAL(10,2),
                        quantity INT(11),
                        customer_name VARCHAR(255),
                        PRIMARY KEY (id)
);
