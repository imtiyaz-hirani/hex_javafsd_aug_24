use ecom; 
show tables; 

insert into category(name,seq) values 
('mobiles', 2),
('laptop',1); 

insert into vendor(name,city) values 
('ABC Electronics', 'mumbai'),
('XYZ Electronics', 'chennai');

insert into address(city,country,street_details)
values ('mumbai','india','andheri(w)'),
('pune','india','hi-tech'),
('delhi','india','Cannught place');

insert into customer(name,contact,address_id) values 
('harry potter', '90909',1),
('ronald weasley', '55895',1),
('hermione granger', '8889650',2),
('draco malfoy', '55656',3);
 
insert into product(title,price,discount,stock_quantity,vendor_id,category_id ) values 
('Oppo A12', 17500, 1000,5,1,1),
('One Plus 3G Nord', 19500, 900,7,2,1),
('Apple IPhone 7', 77500, 3000,4,2,1),
('HP Envy', 71000, 2500,2,1,2),
('Macook M2 Air', 110000, 5000,3,2,2);  

insert into customer_product(customer_id,product_id,date_of_purchase,time_of_purchase,qty,total_amount) values
(1,2,'2024-03-02','11.55',1,0),
(1,5,'2024-03-05','13.50',2,0),
(2,1,'2024-03-10','10.55',1,0),
(3,3,'2024-03-22','17.15',2,0),
(3,5,'2024-04-12','21.00',1,0),
(4,4,'2024-05-02','22.55',2,0);
 
/* Display all customers having bought products that belong to category 'MOBILES'*/
   
select  c.* , a.city
from  customer c 
JOIN customer_product cp ON c.id = cp.customer_id
JOIN product p ON cp.product_id = p.id 
JOIN category cat ON p.category_id=cat.id 
JOIN address a ON c.address_id = a.id
where cat.name='LAPTOP'; 
 
/* Display the quantity of the products sold for each category  
category_name    Qty_SOLD
-------------    --------
*/
 
 select cat.name, SUM(cp.qty) as "Qty_SOLD"
 from customer_product cp 
 JOIN product p ON cp.product_id = p.id 
 JOIN category cat ON p.category_id=cat.id  
 group by cat.name; 
 
/*
Display products that satisfy following requirements 
1. It must belong to vendor that has sold more than 3 products [2,3,5]
2. It must be bought by customer that has purchased atleast 1 'mobile' and 'laptop' [2,5,3]
3. Must have more than or equal to 2 qty in stock [5,3,4]
*/ 
 
 select *
 from product 
 where id IN ( select p.id
				 from product p JOIN vendor v ON p.vendor_id = v.id
				 where v.ID IN (select v.id 
				 from product p JOIN vendor v ON p.vendor_id = v.id
				 JOIN customer_product cp ON cp.product_id = p.id 
				 group by v.id
				 having SUM(cp.qty) >3)) 
  AND id IN (select product_id
				 from customer_product  
				 where  qty >= 2)
  AND id IN (select DISTINCT cp.product_id 
			 from customer c JOIN customer_product cp ON c.id = cp.customer_id
			 where c.id IN (select c.id 
							 from customer c JOIN customer_product cp ON c.id = cp.customer_id
							 JOIN product p ON cp.product_id = p.id 
							 JOIN category cat ON p.category_id=cat.id  
							 where cat.name='mobiles') 
			AND c.id IN (select c.id  
							 from customer c JOIN customer_product cp ON c.id = cp.customer_id
							 JOIN product p ON cp.product_id = p.id 
							 JOIN category cat ON p.category_id=cat.id  
							 where cat.name='laptop')) ;
 
 -- It must belong to vendor that has sold more than 3 products
 select p.id
 from product p JOIN vendor v ON p.vendor_id = v.id
 where v.ID IN (select v.id 
 from product p JOIN vendor v ON p.vendor_id = v.id
 JOIN customer_product cp ON cp.product_id = p.id 
 group by v.id
 having SUM(cp.qty) >3);
  
 -- It must be bought by customer that has purchased atleast 1 'mobile' and 'laptop'
 
 select DISTINCT cp.product_id 
 from customer c JOIN customer_product cp ON c.id = cp.customer_id
 where c.id IN (select c.id 
				 from customer c JOIN customer_product cp ON c.id = cp.customer_id
				 JOIN product p ON cp.product_id = p.id 
				 JOIN category cat ON p.category_id=cat.id  
				 where cat.name='mobiles') 
	  AND c.id IN (select c.id  
				 from customer c JOIN customer_product cp ON c.id = cp.customer_id
				 JOIN product p ON cp.product_id = p.id 
				 JOIN category cat ON p.category_id=cat.id  
				 where cat.name='laptop');
                 
  -- Must have more than 2 qty in stock 
 select product_id
 from customer_product  
 where  qty >= 2;
 
 
 