CREATE TABLE product (
    product_id bigint auto_increment NOT NULL,
    name varchar(255)  NOT NULL,
    description varchar(255)  NULL,
    regular_price decimal(9,2)  NOT NULL,
    currency varchar(3)  NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (product_id)
);

CREATE TABLE promo_code (
    code varchar(24)  NOT NULL,
    expiration_date date  NOT NULL,
    discount_amount decimal(9,2) NOT NULL,
    currency varchar(3)  NOT NULL,
    max_usages int  NOT NULL,
    number_of_usages int  NULL,
    CONSTRAINT promo_code_pk PRIMARY KEY (code)
);

CREATE TABLE purchase (
    purchase_id bigint auto_increment NOT NULL,
    date_of_purchase date  NOT NULL,
    regular_price decimal(9,2)  NOT NULL,
    amount_of_discount decimal(9,2)  NULL,
    promo_code_id varchar(24)  NOT NULL,
    product_id int  NOT NULL,
    CONSTRAINT purchase_pk PRIMARY KEY (purchase_id)
);

ALTER TABLE purchase ADD CONSTRAINT purchase_product
    FOREIGN KEY (product_id)
        REFERENCES product(product_id);

ALTER TABLE purchase ADD CONSTRAINT purchase_promo_code
    FOREIGN KEY (promo_code_id)
        REFERENCES promo_code(code);