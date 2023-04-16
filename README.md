# ProductOrderDetail_Application
### This is a sample Spring Boot application with Maven that includes entities for products and sales orders. The application exposes APIs to create, update, and list products, as well as to add and list sales orders.

## Technologies Useed
  ### Java , Spring Boot, Maven
  ### MYSQL ,JPA/Hibernate
  ### Lombok
  ### Swager_Ui

## EndPoints
### Products
<li><b>POST /api/products:</b> Create a new product</li>
<li><b>PATCH /api/products/{id}{qty}:</b> Update the stock quantity of a product</li>
<li><b>GET /api/products:</b> List all products</li>

### Sales Orders
<li><b>POST /api/sales-orders:</b> Add a new sales order</li>
<li><b>GET /api/sales-orders:</b> List all sales orders</li>

## Request Examples
#### Create a new prudcuts
Post /api/products/add<br>
{<br>
    "name": "Product 1",<br>
    "description": "This is a test product",<br>
    "brandName": "Brand A",<br>
    "salePrice": 100.0,<br>
    "stockQuantity": 10<br>
}<br>
#### Update the stock quantity of a product<br>
PATCH /api/products/1/5<br>

#### list all products
  GET /api/products/all<br>
#### Add new Sales order
  POST /api/salesOrder/add <br>
  {<br>
  "sales_Id": 0,<br>
  "customer": "string",<br>
  "timeStamp": "2023-04-16T07:51:06.344Z",<br>
  "orderDetails": [<br>
    {<br>
      "orderDet_Id": 0,<br>
      "product": {<br>
        "productId": 0,<br>
        "description": "string",<br>
        "brandName": "string",<br>
        "salePrice": 0,<br>
        "stockQuantity": 0,<br>
        "name": "string"<br>
      },<br>
      "saleQuantity": 0,<br>
      "discount": 0<br>
    }<br>
  ]<br>
}<br>
