### Add Patron 
 * Patron means Users of Library
 * It is an Administration entity of Library 
 * Using this we will add a new patron into the database
 * Before Adding a new patron, it is essential to define a set of Patron categories and departments as part of the system configuration operations
 * For Academic Environments, it is necessary to define Courses as a part of the system configuration operations	

#### *Request* 
- Request Path: http://localhost:8070/api/patron
- Request Method - Post
- Request Parameter - PatronDto

	1. library_id - String **Required**

	- Library id is the Primary key in Patron and is foreign key having reference to the table Library.
    
	2. patron_id - String **Required**

	- Patron id is the Primary key of patron which holds the Id of Patron. Patron Id cannot be changed.

	3. patron_category_id - String **Required**

	- Patron Category Id is the foreign key referencing to the table Patron Category.

	4. created_on - String **Optional**

	- In this field, the date on which the patron was created will be stored. 
		- e.g. DATE_FORMAT_EXAMPLE ="1991/01/01"

	5. patron_type - String **Optional**

	- This stores the type of user, Staff of library or Patron.
    
	6.  dept_id - String **Required**

	- Department Id is the foreign key which refers to the Department table

	7. fname - String **Optional**

	- This field stores the First name of Patron.

  	8. mname - String **Optional**

	- This field stores the Middle Name of Patron.

	9. lname - String **Optional**

	- This field stores the Last Name of Patron.

	10.  address1 - String **Optional**

	- Address1 stores the room no/flat no, colony and obviously it does not include City, 	State, ZIP, Country.

	11. address2 - String **Optional**

	- Adress2 includes the street/Landmark

	12. city - String **Optional**

 	- Name of the City

	13. state - String **Optional**

	- Name of the State

 	14.  country - String **Optional**

	- Name of the Country

	15. pin - String **Optional**

	- Pincode or zip code

	16. phone1 - String **Optional**

	- Primary Phone number
		- e.g.  PHONE_FORMAT_EXAMPLE = "+91-9876543210"

	17. phone2 - String **Optional**

	- Secondary Phone number
		- e.g.  PHONE_FORMAT_EXAMPLE = "+91-9876543210"

	18. fax - String **Optional**

	- Fax Number. This has to be validated with the phone format.
		- e.g.  PHONE_FORMAT_EXAMPLE = "+91-9876543210"

	19. email - String **Optional**

	- Email Id.
		- e.g. EMAIL_FORMAT_EXAMPLE = "megh@yahoo.com or megh.94@yahoo.com"

	20. paddress1 - String **Optional**

	- Permanent address1

	21. paddress2 - String **Optional**

	- Permanent address2

	22.  pcity - String **Optional**

	- Permanent City Name

	23. pstate - String **Optional**

	- Permanent State Name

	24. pcountry - String **Optional**

	- Permanent Country Name

	25. ppin - String **Optional**

	- Permanent Pincode/Zipcode

	26.  pphone1 - String **Optional**

	- Permanent Primary Phone number
		- PHONE_FORMAT = "^\\+(\\d{2})-(\\d{10})$"
		- e.g.  PHONE_FORMAT_EXAMPLE = "+91-9876543210"

	27. pphone2 - String **Optional**

	- Permanent Secondary Phone number
		- e.g.  PHONE_FORMAT_EXAMPLE = "+91-9876543210"

	28. pfax - String **Optional**

	- Permanent fax number. This has to be validated with the phone format.
		- e.g.  PHONE_FORMAT_EXAMPLE = "+91-9876543210"

	29. pemail - String **Optional**

	- Permanent Email Id. 
		- e.g. EMAIL_FORMAT_EXAMPLE = "megh@yahoo.com or megh.94@yahoo.com"

	30.  membership_start_date - String **Optional**

  	- Starting Date of membership.
  		- e.g. DATE_FORMAT_EXAMPLE ="1991/01/01"

	31.  membership_expiry_date - String **Optional**

	- Expiry date of membership.
		- e.g. DATE_FORMAT_EXAMPLE ="1991/01/01"

	32. delinquency_reason - String **Optional**

	- In this value can be Null

	33.  entry_date - String **Optional**

	- Date of entry patron.
		- e.g. DATE_FORMAT_EXAMPLE ="1991/01/01"

	34. user_password - String **Optional**

	- Password of user stored

	35. course_id - String **Optional**

	- It is a foreign id referencing Course table

	36. privilege - String **Optional**

	- Add a text in this if any special right/authority given to that patron

	37. twitter_id - String **Optional**

	- This field can be null

	38. facebook_id - String **Optional**

	- This field can be null

	39. sub_location_id - String **Optional**

	- This takes the value from catalogue sublocation

	40. login_id - String **Optional**

	- This is the Login id of patron. 
	
	*Note*: The value of Login Id must be Unique.

	41. authenticate_localdatabase - String **Optional**

	- Value stored if checkbox checked or unchecked. 'A' for True/Checked and 'B' for False/Unchecked.

#### *Response* 
- *Response Type*:  String 
	- patron_id in the database for the respective record will be recieved as a reponse


### Method Requirement

1. Check whether all Validations are satisfied or not
2. If any of the validations are violated then Throw respective EXCEPTION	        
3. If all the requirements are validated, execute successfully

### Acceptance Criteria
- *Criteria 1*: Required Field
	1. *Scenario 1*: If Required Field is left empty.
		- *Expected Response*: Throw Appropriate Exception for required field
	2. *Scenario 2*: If correct input provided.
		- *Expected Response*: Execute Successfully

- *Criteria 2*: Duplication Check
 	1. *Scenario 1*: If a new Patron is requested to be added with existing id.
 		- *Expected Response*: Throw Appropriate Exception for duplication
	2. *Scenario 2*: New Patron with new Id.
		- *Expected Response*: Execute Successfully
	
- *Criteria 3*: Regular Expression Validation
	1. *Scenario 1*: If regular expression validation is violated.
		- *Expected Response*: Throw Appropriate Exception for violating validation
	2. *Scenario 2*: Validated Regular expressions.
		- *Expected Response*: Execute Successfully


### Update Patron 
* This will be used to update any existing record with new/corrected value
* To update a record, The requested record must exist

#### *Request*
- Request Path: http://localhost:8070/api/patron
- Request Method - Put
- Request Parameter - PatronDto

	1. library_id - String **Required**

	- Libraryid is the Primary key hence it is required to be passed to update an existing data
	2. patron_id - String **Required**

	- Patron id is the Primary key of patron hence it is required to be passed to get an existing data to be updated
	
    3. (Here onwards we will give the Field Name and respective value for it that is to be updated. It can be one or more than one Fields. If it has a field which is under validation check, the content should satisfy the rule.)

#### *Response*    
- Value will be updated into the database
- No data will be recieved as a response
```
204 - no content
```    

### Method Requirement

- Check all required fields value exists or not
- The record with the requested Id must exist in the database

### Acceptance Criteria
- Criteria are similar to that of ADD method

### Delete Patron 
* This method will be used to delete any existing data
* The record with the requested Id must exist in the database

#### *Request*
- Request Path: http://localhost:8070/api/patron/{libraryId}/{code}
- Request Method - Delete
- Request Parameter - PatronDto

	- Pass library Id and patron id i.e. code into the path 
    	
#### *Response*  
- Record will be deleted from the database
- No data will be recieved as a response

### Method Requirement

- Record with the library Id and patron id passed in the path must exist in the database

### Acceptance Criteria
- *Criteria 1*: Passing the Library id and Patron Id into the path to delete a data
 	1. *Scenario 1*: If the record with the passed id does not exist
		- *Expected Response*: Throw Appropriate Exception for No such record found
	2. *Scenario 2*: If record exists
		- *Expected Response*:Execute Successfully 

### Search Patron 
* This method will be used to search any record from existing records

#### *Request*
- Request Path: http://localhost:8070/api/patron/?{libraryId=value}
	- *Note*: In url, any parameter can be passed in the place of library id
- Request Method - Get
- Request Parameter - PatronDto
	1. patron_id - String **Required**

	- Patron id is the Primary key of patron, hence passing this will allow find unique record

	2. login_id - String **Optional**

	- This is the Login id of patron, which is unique hence can be passed to get expected record

	3. fname - String **Optional**

	- This field stores the First name of Patron.

* Any one of the above fields value can be passed to fetch the record
  	    	
#### *Response*  
- Record will be fetched from the database
- Records fulfilling the categories will be displayed
    

### Method Requirement

- Either of the following values have to be passed
	1. Department Name
	2. Course
	3. Patron Category
	4. Patron Type
	5. Sub Location
- If no value passed manually, By Default the value in the above fields are 'Any'
- Value can be passed in more than one field, that will provide more appropiate result 	

### Acceptance Criteria
- *Criteria 1*: Passing the values to filter the records from the database
 	1. *Scenario 1*: If No record matches the passed value
		- *Expected Response*: Throw Appropriate Exception for No such record found
	2. *Scenario 2*: If record exists
		- *Expected Response*: Display all the records after filtering the database 



