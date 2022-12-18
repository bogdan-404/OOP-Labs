# OOP Lab 2: Pharmacy System

I decided to implement a basic **Pharmacy** system. It contains a total of 10 entities. Here is a quick overview of each entity.

## Customer Entity

Properties:

- Number of customers
- Id
- Name
- Robber or not
- The Id of visited pharmacy

Methods:

- Generate the id of the customer
- Create an order

## Doctor Entity

Properties:

- Id
- Name

Methods:

- Generate the id of the doctor
- Prescribe drug

## Drug Manufacturer Entity

Properties:

- Number of all drug manufacturers
- Id
- Name
- Number of products
- List of all products

Methods:

- Generate the id of the manufacturer
- Add product

## Financial Department Entity

Properties:

- Revenue
- Profit
- Number of sold products

Methods:

- Add statistics

## Order Entity

Properties:

- Id
- Amoumt of items
- Revenue
- Profit

Methods:

- Generate order id
- Add products to order
- Print statistics

## Pharmacits Entity

Properties:

- Id
- Id of the pharmacy
- Total number of sales

Methods:

- Generate pharmacist id
- Sell drugs

## Pharmacy Entity

Properties:

- Id
- Number of pharmacies

Methods:

- Generate pharmacy id

## Product Entity

Properties:

- Number of products
- Id
- Manufacturer
- Price
- Expenses
- Number in stock
- In stock or not
- Number of products to be supplied in case of out of stock
- Prescription needed or not

Methods:

- Generate product id
- Sell
- Supply stock

## Product Entity

Properties:

- Number of products
- Id
- Manufacturer
- Price
- Expenses
- Number in stock
- In stock or not
- Number of products to be supplied in case of out of stock
- Prescription needed or not

Methods:

- Generate product id
- Sell
- Supply stock

## Security Entity

Properties:

- Number of cars
- Number of arrests
- Id of the car

Methods:

- Generate car id
- Arrest robber

## Supply Delivery Entity

Properties:

- Number of cars
- Id of the car
- Id of destination pharmacy
- Id of the product to be delivered
- Amount of the product to be delivered

Methods:

- Generate delivery car id
- Deliver product
