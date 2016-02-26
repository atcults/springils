# Patron Category
- Patron category means various type of Patrons
- It is an Administration entity of Library 
- Some Patrons in Patron categories can be given special authorities

#### *AddRequest* 
- Request Path: http://localhost:8070/api/patronCategory
- Request Method - Post
- Request Parameter - PatronCategoryDto

	1. library_id - String **Required**
	- Library id is the Primary key in Patron Category and is foreign key having reference to the table Library.
	    
	2. patron_category_name - String **Required**
	- This will have the name of patron category. 
	
    *Note*: Patron category name cannot have duplicate value 
	

#### *Response* 
- *Response Type*: Integer 
	- patron_category_id in the database for the respective record will be recieved as a reponse

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
 	1. *Scenario 1*: If a new Patron category is requested to be added with existing name.
 		- *Expected Response*: Throw Appropriate Exception for duplication
	2. *Scenario 2*: New Patron with new Name.
		- *Expected Response*: Execute Successfully
	
### *Update Patron Category* 
* This will be used to update any existing record with new/corrected value
* To update a record, The requested record must exist

#### *Request*
- Request Path: http://localhost:8070/api/patronCategory
- Request Method - Put
- Request Parameter - PatronCategoryDto

	1. library_id - String **Required**
	- Libraryid is the Primary key hence it is required to be passed to update an existing data
	2. (Here we will give the Field Name and respective value for it that is to be updated. It can be one or more than one Fields. If it has a field which is under validation check, the content should satisfy the rule.)

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

### *Delete Patron Category*
* This method will be used to delete any existing record
* The record with the requested Id must exist in the database

#### *Request*
- Request Path: http://localhost:8070/api/patron/{libraryId}/{id}
- Request Method - Delete
- Request Parameter - PatronCategoryDto

	- Pass library Id and patron category id i.e. code into the path 
 	
#### *Response*  
- Record will be deleted from the database
- No data will be recieved as a response
```
204 - no content
```    

### Method Requirement

- Record with the library Id and patron category id passed in the path must exist in the database

### Acceptance Criteria
- *Criteria 1*: Passing the Library id and Patron category Id into the path to delete a data
 	1. *Scenario 1*: If the record with the passed id does not exist
		- *Expected Response*: Throw Appropriate Exception for No such record found
	2. *Scenario 2*: If record exists
		- *Expected Response*: Execute Successfully 
