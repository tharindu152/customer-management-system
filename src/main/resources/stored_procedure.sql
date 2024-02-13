
/* Stored Procedure for 6.E in MS SQL*/

CREATE PROCEDURE GetActiveOrdersByCustomer
    @UserId INT
AS
BEGIN
    SELECT o.order_id,
           p.product_name,
           o.is_active,
           c.user_name
    FROM [order] o
             INNER JOIN customer c  ON o.order_by = c.user_id
             INNER JOIN product p   ON o.product_id = p.product_id
    WHERE o.is_active   = 1
      AND c.user_id     = @UserId;
END;

