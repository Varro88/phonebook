## **Capstone project description**

Create Spring MVC Maven project.
Take PhoneBook application as an example and create Spring MVC (REST) application as follow:

* **GET** - receive all phoneBook records
* **GET/{name}** - all phones for the given name
* **PUT/{name}; phoneNumber** - add phone to existing name
* **POST/; {“name”:”YourName”, “phoneNumber”: “+79998887711”}** - create a new record in the phoneBook
* **DELETE/{name}** - removes record by name completely (including associated phone numbers).

Rest resources must be located under api/v1/contacts.

Use JSON as a request/response body.
All records can be kept in memory.

**DELETE/{name}** - must throw an exception if there is no such phone in the
PhoneBook. Exception must be handled and reason must be printed out as a JSON object.
Ensure that appropriate HTTP status codes are returned for ALL methods.

Java configuration of Spring MVC is a must.
