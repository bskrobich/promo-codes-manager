# Promo Codes Manager

This application provides a backend solution for managing promo codes for sales or promotions. It offers a REST API for creating, updating, and retrieving products, promo codes, and simulating purchases.

## Features

1. **Product Management**
   - Create, retrieve, and update product data.
   - Each product has a name, description (optional), and regular price with currency.

2. **Promo Code Management**
   - Create and retrieve promo codes.
   - Promo codes are alphanumeric strings with a specific length, expiration date, discount amount, currency, maximum usage limit, and usage counter.

3. **Discount Calculation**
   - Calculate the discount price for a product using a promo code.
   - Various scenarios are considered, such as expired codes, mismatched currencies, or reaching the maximum usage limit.

4. **Purchase Simulation**
   - Simulate a purchase transaction and store relevant information in the database.
   - Records include the purchase date, regular price, applied discount (if any), the purchased product, and the promo code.

## Implementation Details

- **Backend**: Implemented in Java using the Spring framework.
- **Database**: Utilizes a relational in-memory database (e.g., H2).
- **API**: Exposes a RESTful API for interacting with the application.
- **Security**: No authentication or authorization mechanisms are implemented.
- **Build Tool**: Utilizes either Maven or Gradle for project management.

## Instructions

## Building and Running the Application
1. **Clone the repository from GitHub:**
   ```bash
   git clone https://github.com/bskrobich/promo-codes-manager.git 
2. **Navigate to the project directory:**
   ```bash
   cd promo-codes-manager
3. **Build the project using Maven Wrapper:**
   ```bash
   ./mvnw clean install
4. **Run the application:**
   ```bash
   java -jar target/promo-codes-manager.jar
  - The application will start a server exposing the REST API.

## Accessing REST Services

- Use tools like cURL, Postman, or a web browser to interact with the API.
- Below are the endpoint URLs along with sample queries:

1. **Create a new product:**
   - Endpoint: `POST /products`
   - Sample Request Body:
     ```json
     {
       "name": "Product Name",
       "description": "Product Description",
       "regularPrice": 99.99,
       "currency": "USD"
     }
     ```

2. **Get all products:**
   - Endpoint: `GET /products`

3. **Update product data:**
   - Endpoint: `PUT /products/{productId}`
   - Sample Request Body:
     ```json
     {
       "name": "Updated Product Name",
       "description": "Updated Product Description",
       "regularPrice": 109.99,
       "currency": "USD"
     }
     ```

4. **Create a new promo code:**
   - Endpoint: `POST /promo-codes`
   - Sample Request Body:
     ```json
     {
       "code": "ABC123",
       "expirationDate": "2024-12-31",
       "discountAmount": 10,
       "currency": "USD",
       "maxUsages": 100
     }
     ```

5. **Get all promo codes:**
   - Endpoint: `GET /promo-codes`

6. **Get one promo code's details by providing the promo code:**
   - Endpoint: `GET /promo-codes/{promoCode}`

7. **Get the discount price by providing a product Id and a promo code:**
   - Endpoint: `GET /discount-price?productId={productId}&promoCode={promoCode}`

8. **Simulate purchase:**
   - Endpoint: `POST /purchase?productId={productId}&promoCode={promoCode}`