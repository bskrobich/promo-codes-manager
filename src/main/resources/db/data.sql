INSERT INTO product (name, description, regular_price, currency) VALUES
('Laptop', 'Powerful laptop with high performance', 999.99, 'EUR'),
('Smartphone', 'Latest smartphone model with advanced features', 699.99, 'USD'),
('Headphones', NULL, 199.99, 'PLN');

INSERT INTO promo_code (code, expiration_date, discount_amount, currency, max_usages, number_of_usages) VALUES
('2E7bs56PYsSAne3GYr', '2024-06-30', 25.00, 'EUR', 100, 50),
('kY1R5UU74', '2024-08-31', 20.00, 'USD', 200, 150),
('vSQ2Tw', '2024-10-31', 15.00, 'PLN', 150, 100);

INSERT INTO purchase (date_of_purchase, regular_price, amount_of_discount, promo_code_id, product_id) VALUES
('2024-05-10', 999.99, 0.00, '2E7bs56PYsSAne3GYr', 1),
('2024-05-11', 699.99, 15.00, 'vSQ2Tw', 1),
('2024-05-12', 199.99, 20.00, 'kY1R5UU74', 2),
('2024-05-13', 999.99, 0.00, 'kY1R5UU74', 2),
('2024-05-14', 199.99, 15.00, 'vSQ2Tw', 3);



