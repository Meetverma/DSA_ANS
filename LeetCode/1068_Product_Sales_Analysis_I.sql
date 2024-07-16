
select product_name, year, price
from Sales natural join Product 
group by sale_id;
