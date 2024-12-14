-- Create Customers Table
CREATE TABLE customers (
    customer_id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(255),
    phone VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample data into customers table
INSERT INTO customers (first_name, last_name, email, phone) VALUES
('John', 'Doe', 'john.doe@example.com', '123-456-7890'),
('Jane', 'Smith', 'jane.smith@example.com', '987-654-3210'),
('Alice', 'Johnson', 'alice.johnson@example.com', '555-666-7777');

-- Create Products Table
CREATE TABLE products (
    product_id BIGSERIAL PRIMARY KEY,
    product_name VARCHAR(255),
    description TEXT,
    price DECIMAL(10, 2),
    stock_quantity INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample data into products table
INSERT INTO products (product_name, description, price, stock_quantity) VALUES
('Laptop', '15 inch laptop with 8GB RAM', 799.99, 50),
('Smartphone', '5.5 inch smartphone with 4GB RAM', 299.99, 200),
('Headphones', 'Wireless Bluetooth headphones', 99.99, 150);

-- Create Orders Table
CREATE TABLE orders (
    order_id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT,
    order_date TIMESTAMP,
    status VARCHAR(50),
    total_amount DECIMAL(10, 2),
    shipping_address VARCHAR(255),
    billing_address VARCHAR(255),
    payment_status VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Insert sample data into orders table
INSERT INTO orders (customer_id, order_date, status, total_amount, shipping_address, billing_address, payment_status) VALUES
(1, '2024-12-10 10:30:00', 'Pending', 899.98, '123 Elm St, Springfield, IL', '123 Elm St, Springfield, IL', 'Paid'),
(2, '2024-12-11 14:00:00', 'Shipped', 599.99, '456 Oak St, Chicago, IL', '456 Oak St, Chicago, IL', 'Paid'),
(3, '2024-12-12 16:15:00', 'Delivered', 99.99, '789 Pine St, Los Angeles, CA', '789 Pine St, Los Angeles, CA', 'Pending');

-- Create Order_Items Table
CREATE TABLE order_items (
    order_item_id BIGSERIAL PRIMARY KEY,
    order_id BIGINT,
    product_id BIGINT,
    quantity INT,
    price DECIMAL(10, 2),
    total_price DECIMAL(10, 2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- Insert sample data into order_items table
INSERT INTO order_items (order_id, product_id, quantity, price, total_price) VALUES
(1, 1, 1, 799.99, 799.99),
(1, 2, 1, 99.99, 99.99),
(2, 3, 2, 299.99, 599.98),
(3, 1, 1, 799.99, 799.99);

-- Create Order_Status_History Table
CREATE TABLE order_status_history (
    status_history_id BIGSERIAL PRIMARY KEY,
    order_id BIGINT,
    status VARCHAR(50),
    status_date TIMESTAMP,
    comments TEXT,
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);

-- Insert sample data into order_status_history table
INSERT INTO order_status_history (order_id, status, status_date, comments) VALUES
(1, 'Pending', '2024-12-10 10:30:00', 'Order placed, awaiting payment confirmation'),
(2, 'Shipped', '2024-12-11 14:00:00', 'Order has been shipped and is on the way'),
(3, 'Delivered', '2024-12-12 16:15:00', 'Order delivered successfully');

-- Query to check data
SELECT * FROM customers;
SELECT * FROM products;
SELECT * FROM orders;
SELECT * FROM order_items;
SELECT * FROM order_status_history;
