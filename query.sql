1. select * from products where title='ACADEMY ADAPTATION'
2. select * from products where category = '8' and price ='9.99' order by category, price  
3. select * from products where category = '8' or category = '15'
4. select * from products where price between 10 and 20
5. select * from orders where orderdate between date('2004-01-27') and date('2004-02-27')
6. select customerid, count(customerid) from orders group by customerid
7. select sum(totalamount) from orders group by customerid, orderdate having sum(totalamount) > 100
8. select c.firstname, c.lastname, p.title, os.orderdate from customers as c
join orders as o on c.customerid = o.customerid 
join orderlines as os on o.orderid = os.orderid
join products as p on os.prod_id = p.prod_id