Our application is called Order
Management Systems (OMS), which is the one-stop
destination for buying and selling stocks. We are
developing the application using Angular Frontend,
Java Spring Backend, and MariaDB as the database.
The application performs basic activities like user
registration, user login/logoff, placing orders for
stocks, and canceling orders for stocks. Indian Stock
Exchange (NSE) works like this application, but here
the operations are mainly focused on keeping the
database in mind. We thought of using procedures in
Mariadb to perform all the operations. The procedures
in DB are responsible for executing the orders based
on order availability and timestamp of order creation
in a First Come First Serve (FCFS) manner.
