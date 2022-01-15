# Cisco-GLS-Management-System
 A full-stack web application that simplifies the management process for racks and their IP addresses
 Software requirements: code editor, IDE (Netbean, Eclipse and etc. )

### Project set up for database
```
* install your PostgreSQL database
* create the tables with rack.sql under sql-scripts directory
```

### Project set up for backend (http://localhost:8080)

```
First, make sure you Java 8+ installed.
Open the IDE of your choice, then import and build the backend portion of this project
Open the application.properties file at backend-api\Cisco-GLS-management-system\src\main\resources\application.properties
* on line 5, change 'database_name' to the name of your database
* on line 8, change 'yourusername' to the username of your database
* on line 9, change 'yourpassword' to the password of your database

find PostgreSqlApplication.java under backend-api\Cisco-GLS-management-system\src\main\java\com\cisco
run the application as a Java project
```

## Project setup for frontend (Frontend)
### make sure Flask is installed
```
pip install flask
```

### Run the frontend under the frontend-ui folder (http://localhost:5000)
```
python main.py
```

> * The home page of this app
![image not found](./screen-shot/home.png)

> * Sample response for retrieving all records
![image not found](./screen-shot/home-sample-response.png)

> * The get page of this app
![image not found](./screen-shot/get.png)

> * Sample response for retrieving one record
![image not found](./screen-shot/get-sample-response.png)

> * The create page of this app
![image not found](./screen-shot/create.png)

> * Sample input for creating a record
![image not found](./screen-shot/create-sample-input.png)

> * Sample response for creating a record
![image not found](./screen-shot/create-sample-response.png)

> * The sample update page of this app
![image not found](./screen-shot/update-sample-input.png)

> * Retrieve data after update
> * Under Switch location, the field is updated from 'new switch location' to 'newly updated switch location'
![image not found](./screen-shot/get-after-update.png)

> * The delete page of this app
![image not found](./screen-shot/delete.png)

> * Sample input for delete page
![image not found](./screen-shot/delete-sample-input.png)

> * Sample response for delete page
![image not found](./screen-shot/delete-sample-response.png)

> * Now use the get page to retrieve a non-existed(deleted) record:
![image not found](./screen-shot/get-after-delete.png)

