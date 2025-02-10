## **Capstone project description**

PhoneBook application has the following endpoints:

* **GET** `/` - receive all phoneBook records
* **GET** `/{name}` - all phones for the given name
* **PUT** `/{name}` `phoneNumber` - add phone to existing name
* **POST** `/` `{"name":"YourName", "phoneNumber": "+79998887711"}`** - create a new record in the phoneBook
* **DELETE** `/{name}` - removes record by name completely (including associated phone numbers).

* Resources are located under `api/v1/contacts`.
* JSON is used as a request/response body.
* All records can be kept in memory.
* Exception are handled and reason is printed out as a JSON object.
* Appropriate HTTP status codes are returned for ALL methods.