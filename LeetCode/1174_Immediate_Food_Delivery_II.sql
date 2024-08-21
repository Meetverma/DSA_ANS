
with firstOrders as(
    select customer_id, 
    min(order_date) as fo_date
    from Delivery
    group by customer_id
),
firstOrderDetails as(
    select 
        f.customer_id,
        d.delivery_id,
        d.order_date,
        d.customer_pref_delivery_date
        from 
            firstOrders f
            join 
            Delivery d
            on f.customer_id = d.customer_id AND f.fo_date = d.order_date
)
select 
    round(100.0 * sum(case when order_date = customer_pref_delivery_date then 1 else 0 end)/count(*)
    ,2
    ) as immediate_percentage
    from firstOrderDetails
;
