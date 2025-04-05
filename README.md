# John's Computer Shop - Web Application

This is a web-based application for John's Computer Shop, an (fake) online store specializing in computer parts and custom-built PCs. The project includes functionalities such as a product catalog, customer purchase options, and an inventory management system with validation for inventory limits.

## Project Features

### 1. **UI Customization**
   - The main page now includes the shop name, "John's Computer Shop", along with an updated interface for better user experience.
   - The user interface is styled with custom CSS to center-align key elements and ensure consistency across the application.
   - The page displays a clear product and part inventory layout.

### 2. **About Page**
   - Added a dedicated "About" page to describe the company and its services to potential customers.
   - Navigation links have been added to allow users to easily switch between the main screen and the "About" page.

### 3. **Sample Inventory**
   - A sample inventory of parts and products has been added for the store. This includes:
     - **Parts**: Various RAM, GPU, CPU, and speakers with pricing and stock levels.
     - **Products**: Different pre-configured PCs, such as Gaming PCs, Server PCs, and Media PCs.
   - The inventory is managed in a way that prevents duplicate items using a "multi-pack" feature for part listings.

### 4. **"Buy Now" Button**
   - A "Buy Now" button has been added to the product list. Clicking the button:
     - Decreases the product inventory by one.
     - Displays a success or failure message based on inventory availability.
     - **Note**: This does not affect the inventory of associated parts.

### 5. **Inventory Management**
   - New fields for minimum and maximum inventory have been added to parts, and validation checks ensure that inventory levels stay within these bounds.
   - When adding or updating inventory, the application validates that the inventory does not exceed the set maximum or fall below the minimum thresholds.

### 6. **Form Validation**
   - Custom validation annotations ensure that the inventory levels are within the acceptable range defined by the minimum and maximum values.
   - Error messages are displayed when inventory is insufficient or exceeds the maximum capacity.

### 7. **Unit Testing**
   - Unit tests have been written to validate the minimum and maximum inventory logic for parts. These tests help ensure the integrity of the inventory management system.

### 8. **Refactoring and Code Clean-Up**
   - Unused validators have been removed from the codebase to keep it clean and maintainable.

## Project Setup

### Prerequisites
To run this project locally, ensure you have the following installed:

- **Java** (version 8 or above)
- **Spring Boot** (for running the application)
- **Maven** (for building the project)
- **H2 Database** (for local database storage)

### Installation

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/yourusername/johns-computer-shop.git
    ```

2. Navigate to the project directory:

    ```bash
    cd johns-computer-shop
    ```

3. Build and run the application:

    ```bash
    mvn spring-boot:run
    ```

4. The application will be available at `http://localhost:8080/` in your web browser.

### Database Configuration

- The project uses an H2 database, which is configured to save the data locally in the file system.
- The database file is located at: `src/main/resources/spring-boot-h2-db102`.

## Application Screenshots

![Main Screen](screenshot-main-screen.png)
*Main Screen showing the product catalog and inventory management.*

![About Page](screenshot-about-page.png)
*About page describing the company.*

## Technologies Used

- **Spring Boot**: For building the backend of the application.
- **Thymeleaf**: Template engine for rendering HTML pages.
- **H2 Database**: Lightweight database for local development.
- **Java 8+**: For backend programming.

## Contributors

- **John McGinnes**: Developer and project lead.
