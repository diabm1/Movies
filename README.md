# Movie Management Application

This is a movie management application developed using Spring MVC. The application allows users to manage movies by performing CRUD operations.

## Getting Started

To get started with the application, follow the instructions below:

    1. Clone the repository to your local machine.
    2. Create a copy of the application.properties.template file located in the src/main/resources directory.
    3. Rename the copied file to application.properties.
    4. Open the application.properties file and fill in the necessary configuration values specific to your local environment.
        * Modify the spring.datasource.url property with the appropriate PostgreSQL connection URL.
        * Set the spring.datasource.username and spring.datasource.password properties with your database credentials.
    5. Build the project using Maven: mvn clean install.
    6. Run the application: mvn spring-boot:run or run the com.javaunit3.springmvc.SpringmvcApplication class directly from your IDE.
    7. Access the application in your web browser at http://localhost:8080.

## Usage

Once the application is up and running, you can use it to perform the following operations:

    * View a list of movies.
    * Add a new movie by providing the movie details.
    * Edit an existing movie by updating its information.
    * Delete a movie from the database.

Contributing

If you'd like to contribute to this project, please follow these guidelines:

    1. Fork the repository.
    2. Create a new branch for your feature or bug fix.
    3. Implement your changes.
    4. Test your changes thoroughly.
    5. Commit your changes and push them to your forked repository.
    6. Submit a pull request detailing your changes.

For summary of project please take a look at the summary-of-project file. Thank you.