use ecom; 
/* Create a procedure to fetch employee data from the db */
DELIMITER $$
create procedure fetch_customer_data()
BEGIN
	select * from customer;   
END
$$ 

-- list out all procedures 
show procedure status;

-- call fetch_customer_data
CALL fetch_customer_data();

-- display customer record based on given city 
DELIMITER $$
create procedure fetch_customer_by_city(IN pcity varchar(255))  -- IN parameter 
BEGIN
	select c.* 
    from customer c 
		JOIN address a ON c.address_id = a.id 
	where a.city=pcity;
END
$$  

-- calling fetch_customer_by_city
call fetch_customer_by_city('mumbai');

-- drop procedure if needed
drop procedure fetch_customer_by_city;

/* display products that belong to given vendor having atleast 
   given stock quantity and restrict the 
   result set to given limit 
   
   display_product_by_vendor_stockqty_limit('vendor_name',2,1,2) 
   
   1 2 3 4 5 6 7 8 9 
   
   proc(1,3) : 123 
   proc(4,3) : 456
   proc(7,3) : 789 
   
   proc(3):123 
   */
   
	DELIMITER $$ 
	create procedure display_product_by_vendor_stockqty_limit(
    IN ivendor_name varchar(45),
    IN istock_count int,
    IN ioffset int,
    IN isize int)
    BEGIN
		select p.* 
        from product p JOIN vendor v ON p.vendor_id = v.id 
        where v.name=ivendor_name AND p.stock_quantity >= istock_count
        limit ioffset,isize;
    END
    $$ 
    
    -- call display_product_by_vendor_stockqty_limit
   call display_product_by_vendor_stockqty_limit('XYZ Electronics',2,1,2);
   
   /* Create a Prodecure that returns number of products bought by given_customer 
       int num = no_of_products_by_customer_id(customer_id)
   */
   DELIMITER $$
   create procedure no_of_products_by_customer_id(IN icustomer_id int, OUT ocount int)
   BEGIN
		select count(*) into ocount
        from customer_product 
        where customer_id= icustomer_id; 
   END
   $$
   
   CALL no_of_products_by_customer_id(1,@num);
   select @num; 
   
   drop procedure no_of_products_by_customer_id;
   
   /* 
   CAP to compute discount of the product based on following inputs 
   if category="mobiles" and stock_quantity > 5 : discount=8% 
	  if category="laptop" and stock_quantity > 3 : discount=6% 	
   */
   DELIMITER $$
   create procedure update_product_discount(IN icategory varchar(255), IN istock_qty int)
   BEGIN
   if icategory = "mobiles" then
	   update product 
       SET discount = (price*0.08)
       where stock_quantity >= istock_qty AND category_id IN (select id from category where name=icategory);
   ELSEIF icategory = "laptop" then
	   update product 
       SET discount = (price*0.06)
       where stock_quantity >= istock_qty AND category_id IN (select id from category where name=icategory);
   end if;
   END 
   $$
   CALL update_product_discount('mobiles',5);
   CALL update_product_discount('laptop',3);
   drop procedure update_product_discount;
   
   
   
   