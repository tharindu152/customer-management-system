/* DB Scripts */
/* Table Creation */
CREATE TABLE customer (
      user_id INT NOT NULL IDENTITY(1,1),
      created_on DATETIME2(6) NOT NULL,
      email NVARCHAR(50) NOT NULL,
      first_name NVARCHAR(20) NOT NULL,
      is_active BIT NOT NULL,
      last_name NVARCHAR(20) NOT NULL,
      user_name NVARCHAR(30) NOT NULL,
      CONSTRAINT PK_customer PRIMARY KEY (user_id)
);

CREATE TABLE [order] (
        order_id INT NOT NULL IDENTITY(1,1),
        is_active BIT NOT NULL,
        order_status INT NOT NULL,
        order_type INT NOT NULL,
        ordered_on DATETIME2(6) NOT NULL,
        shipped_on DATETIME2(6) NOT NULL,
        order_by INT NOT NULL,
        product_id INT NOT NULL,
        CONSTRAINT PK_order PRIMARY KEY (order_id)
);

CREATE TABLE product (
         product_id INT NOT NULL IDENTITY(1,1),
         created_on DATETIME2(6) NOT NULL,
         is_active BIT NOT NULL,
         product_name NVARCHAR(50) NOT NULL,
         unit_price DECIMAL(19,2) NOT NULL,
         supplier_id INT NOT NULL,
         CONSTRAINT PK_product PRIMARY KEY (product_id)
);

CREATE TABLE supplier (
      supplier_id INT NOT NULL IDENTITY(1,1),
      created_on DATETIME2(6) NOT NULL,
      is_active BIT NOT NULL,
      supplier_name NVARCHAR(50) NOT NULL,
      CONSTRAINT PK_supplier PRIMARY KEY (supplier_id)
);

/* Table Relationships */
ALTER TABLE [order]
ADD CONSTRAINT FK_order_customer
FOREIGN KEY (order_by)
REFERENCES customer (user_id);

ALTER TABLE [order]
ADD CONSTRAINT FK_order_product
FOREIGN KEY (product_id)
REFERENCES product (product_id);

ALTER TABLE product
ADD CONSTRAINT FK_product_supplier
FOREIGN KEY (supplier_id)
REFERENCES supplier (supplier_id);

/* Insert data */
INSERT INTO supplier (created_on, is_active, supplier_name) VALUES (?, ?, ?);
INSERT INTO product (created_on, is_active, product_name, supplier_id, unit_price) VALUES (?, ?, ?, ?, ?)
INSERT INTO customer (created_on, email, first_name, is_active, last_name, user_name) VALUES (?, ?, ?, ?, ?, ?)
INSERT INTO `order` (order_by, is_active, order_status, order_type, ordered_on, product_id, shipped_on) VALUES (?, ?, ?, ?, ?, ?, ?)

/* Retrieve Data*/
SELECT * FROM customer;
SELECT `order`.order_id, p.product_name, `order`.is_active, c.user_name
FROM `order`
    INNER JOIN customer c   ON `order`.order_by = c.user_id
    INNER JOIN product p    ON `order`.product_id = p.product_id
WHERE `order`.is_active = true AND c.user_id = ?;

/* Update Customer */
UPDATE customer
SET email=?, first_name=?, is_active=?, last_name=?, user_name=?
WHERE user_id=?;

/* Delete Customer */
DELETE FROM customer WHERE user_id=?



