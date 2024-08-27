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
   call display_product_by_vendor_stockqty_limit('XYZ Electronics',2,2,1);
   
   /* Create a Prodecure that returns number of products bought by given_customer 
       int num = no_of_products_by_customer_id(customer_id)
   */
   -- create or replace procedure --- in oracle 
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
   -- dbms_output.put_line('') -- in oracle
   
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
   
   /* LOOPS : While loop 
   CAP to display first n number 
   */
   
   DELIMITER $$
   create procedure iterate_numbers(IN n INT)
   BEGIN
		DECLARE i INT default 1; 
        DECLARE result_string TEXT default ''; 
        
		WHILE i <=n DO 
			SET result_string = concat(result_string,i,' ');
            SET i = i+1; 
        END WHILE ;
        select result_string;
   END 
   $$ 
   CALL iterate_numbers(10);
   
   /*
   Loop : Basic Loop 
   CAP to display first n number 
   */
   DELIMITER $$ 
   create procedure display_numbers(IN n INT)
   BEGIN
   DECLARE i INT default 1; 
	   my_loop:
       LOOP 
			select i as 'Present_Number';
            -- increment i 
            SET i = i+1; 
       -- EXIT criteria 
       IF i > n THEN 
		 LEAVE my_loop; 
       END IF; 
	   END LOOP ;
   END
   $$
   
   CALL display_numbers(3);
   drop procedure display_numbers
   
   -- cap to fetch all ids of products 
   DELIMITER $$
   create procedure fetch_product_ids()
   BEGIN
		declare length_tbl INT default 0; 
        declare i INT default 0; 
           
		select count(id) into length_tbl from product; 
        WHILE i<length_tbl DO
			select id from product order by id ASC limit i,1; 
            SET i = i+1;  -- i:= i+1 -- in oracle 
        END WHILE; 
   END
   $$
   
   CALL fetch_product_ids();
   drop procedure fetch_product_ids
   
   -- CAP to do following task: For a given vendor, you have to increment the price of all products of that vendor by given_percent 
	
   delimiter $$
   create procedure update_product_price(IN ivendor_name varchar(255), IN ipercent double)
   BEGIN
		DECLARE percent_val double default 0; 
        DECLARE vid INT; 
        -- fetch id of vendor by name 
        select id into vid
        from vendor
        where name=ivendor_name;
                
        -- use this vendor id here 
		update product 
        SET price = price + (price*(ipercent/100))
        where vendor_id = vid ;
   END
   $$
   call update_product_price('ABC Electronics',5);
   drop procedure update_product_price;
   /*
   2 / 100 = 0.02    price = price + (price*0.02)
   */
   
   -- CAP that decreases the price of all products by given_percent. 
   
   DELIMITER $$
   create procedure price_update_product(IN ipercent double)
   BEGIN 
	DECLARE length_tbl INT default 0 ;
    DECLARE i INT default 1; 
    
    select MAX(id) into length_tbl from product;  
    
    WHILE i<= length_tbl DO
		update product
		SET price = price - (price*(ipercent/100)) 
		where id = i;
        
        SET i = i+1;
    END WHILE;
   END; 
   $$
   
   CALL price_update_product(2);
   drop procedure price_update_product;
   
   
   
   DELIMITER $$
   create procedure price_update_product_v2(IN ipercent double)
   BEGIN 
	  	update product  -- X(lock)
		SET price = price - (price*(ipercent/100)) 
        where id = (select id from product); 
   END; 
   $$
   
   CALL price_update_product_v2(3);
   
   -- update,delete,insert : pstmt.executeUpdate()
   -- select : pstmt.executeQuery()
   
    DELIMITER $$
   create procedure price_update_product_v3(IN ipercent double)
   BEGIN 
	  	update product   
		SET price = price - (price*(ipercent/100)) 
        where id >0 ; 
   END; 
   $$
   
   CALL price_update_product_v3(2);
   
   -- CURSOR 
   -- CAP to display all customer records using cursor 
    DELIMITER $$
   create procedure fetch_customer_cur() 
   BEGIN
	   declare cust_id INT; 
	   declare cust_name TEXT;
	   declare done INT default 0; -- handler of cursor 
       
   -- save query into cursor 
   DECLARE customer_cur CURSOR FOR  -- open_cur  handler(done) LOOP fetch into variables   EXIT(handler)  END LOOP  close_cur  
		select id,name from customer;
	
    -- declare a handler to set the 'done'(0/1) flag when cursor reaches to the end of the records and no more records are there to be read
	declare continue handler FOR NOT FOUND SET done =1; 
    
  -- Open the cursor 
	OPEN customer_cur;
		
        my_loop: 
		LOOP 
			FETCH customer_cur INTO cust_id,cust_name;
        
        -- exit the loop if no more rows are to be fetched 
        IF done THEN 
			LEAVE my_loop;
		END IF; 
        -- display the values of id and name 
        select cust_id, cust_name; 
        
        END LOOP; 
   -- close the cursor 	
    CLOSE customer_cur; 
   END
   $$
   
   CALL fetch_customer_cur();
   
   
   
   
   
   
   
   
   
   
   
   
   
   