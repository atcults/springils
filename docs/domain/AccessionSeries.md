# AccessionSeries
 
**Table name** - accession_series

1. series_name - string - Required
  - This is Primary key. Accession series name is passed by user.
2. library_id - integer - Required
  - This is Primary key. Library reference is passed to enter series.
3. max_number - integer - Optional
  - Max Number is the accession number from which the series begins. It should be numeric.
4. max_zero - integer - Optional
  - how many leading zero in series will be passed. It should be numeric. i.e - Some libraries like to use a fixed length accession number by padding the front with leading zeros, e.g., 00001, 00002 ... 01000, 01001, etc. In such a case the library expects that the maximum accession number will not exceed 99999. In such a case, the maximum number of leading zeros will be 4. This text box is not required to be filled if the accession number is a variable length number.
5. entry_library_id - integer - Optional
  - Entry library id is passed which is referenced by referenced patron's Library id.
6. entry_id - string- Optional
  - Patron id is passed.
7. entry_date - date - Optional
  - Record inserted date.
8. prefix - string - Optional
  - It stores the prefix for series name.
9. fixed_variable - string - Required
  - Accession series type is passed. Value can be Variale or fixed.

### **Add AccessionSeries**

- This method is defined to add accession series name and set the prifix for series. 

#### *Request*

**Request Parameter** : 

- Request Path -  http://localhost:8087/api/accessionSeries
- Request Method - Post
- Request parameter - Dto

1. libraryId - string - Required - Logged in library id will be passed.
2. code - string - Required - Accession series name will be passed by user.
3. prefix - string - Optional - Prefix value for series name will be passed.
4. maxNumber - string - Optional - Number value for series start will be passed. It should be numeric.
5. maxZero - string - Optional - Maximum number of leading zero in series will be passed. It should be numeric.
6. typeName - string - Required - Accession series type is passed. Type is Variable or fixed. Depending on whether the accession numbers (the numeric part is fixed in length or variable) check the appropriate radio button. For instance if accession numbers begin with 1 and go on continuously, then the correct radio button to check is Variable.

#### *Response*
 
**Response type** - String
 
Accession series data inserted successfully. Please check database to verify record.

#### *Method Requirements:*

1. Check required field is passed or not. if it is not passed in request then throw exception.
2. Check library exist or not.
3. Check maxNumber and maxZero field value. It should not be less than 0.
4. Check accession series type value. It should be Fixed or Variable.
5. Check for series name duplication. If series name is duplicated then throw exception.

#### *Acceptance Criteria*

**Criteria 1:** Required field 

*Request:* Field left empty.

*Expected Response:* Required Field cannot be empty

*Example:* Series name is empty.

*Expected Response:* Exception message - Series name is required.

*Request:* Series name id provided.

*Expected Response:* Accession series record inserted successfully.

**Criteria 2:** Duplicate field

*Request:* Field value is same.

*Expected Response:* Field value is duplicated.

*Example:* Series name is same.

*Expected Response:* Exception message - Series name is duplicate.

*Request:* Different series name is provided.

*Expected Response:* Accession series inserted successfully.


### **Update AccessionSeries**

- This method is used to update the existing record of accession series.

#### *Request*

- Request Path -  http://localhost:8087/api/accessionSeries
- Request Method - Put
- Request parameter - Dto

1. libraryId - string - Required - Logged in library id will be passed.
2. code - string - Required - Accession series name will be passed by user.
3. prefix - string - Optional - Prefix value for series name will be passed.
4. maxNumber - string - Optional - Number value for series start will be passed. Value should be numeric.
5. maxZero - string - Optional - Maximum number of leading zero in series will be passed. Value should be numeric.
6. typeName - string - Required - Accession series type is passed. Type is fixed or Variable. Depending on whether the accession numbers (the numeric part is fixed in length or variable) check the appropriate radio button. For instance if accession numbers begin with 1 and go on continuously, then the correct radio button to check is Variable.


#### *Response*
 
 **Response type** - String
 
 Accessin series data updated successfully. Please check database to verify record.

#### *Method Requirements:*

1. Check library id exists or not.
2. Check accession series exists or not.
3. Check required fields passed or not. 
4. Check maxNumber and maxZero field value. It should not be less than 0.
5. Check accession series type value. It should be Fixed or Variable.
6. Check for series name duplication. 

#### *Acceptance Criteria*

**Criteria 1:** Existing record

*Request:* Record is not exist.

*Expected Response:* Record must exist.

*Example:* Series name is not exists.

*Expected Response:* Exception message - Series name is not exist.

*Request:* Series name is provided.

*Expected Response:* Series name is updated successfully.

**Criteria 1:** Required field 

*Request:* Field left empty.

*Expected Response:* Required Field cannot be empty

*Example:* Series name is empty.

*Expected Response:* Exception message - Series name is required.

*Request:* Series name id provided.

*Expected Response:* Series name is updated successfully.

**Criteria 2:** Duplicate field

*Request:* Field value is same.

*Expected Response:* Field value is duplicate.

*Example:* Series name is same.

*Expected Response:* Exception message - Series name is duplicate.

*Request:* Different series name is provided.

*Expected Response:* Series name is updated successfully.


### **Delete Course**

- This method is used to delete existing accession series.

#### *Request*

- Request Path -  http://localhost:8087/api/accessionSeries/{series_name}
- Request Method - delete

1. series_name - string - Required - Existiong series name is passed.

#### *Response*

Accessin series data deleted successfully. Please check database to verify record.

#### *Method Requirements:*
 
1. Check series name exists or not.
2. Check valid series name passed or not.

#### *Acceptance Criteria*

**Criteria 1:** Existing Record

*Request:* Record is not exist.

*Expected Response:* Record must exist.

*Example:* Series name is not exists.

*Expected Response:* Exception message - String name is not exist.

*Request:* Series name is provided.

*Expected Response:* Series name deleted successfully.
