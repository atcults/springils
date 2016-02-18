# Course
 
- **Table name** - course

1. library_id - integer - **Required**
  
  - This is Primary key. Library reference is passed to enter course .

2. course_id - integer - **Required**
  
  - This is Primary key. It is auto generated key.
  
3. course_name - string- **Required**

  - Course name is passed by user.
 
4. hod_id - numeric - **Optional**

  - It will set default value.
 
5. entry_id - string- **Optional**

  - Patron id is passed.
  
6. entry_date - date - **Optional**

  - System generated date and time is passed.
  
7. p_course_id - integer - **Optional**

  - Course id is passed when promoted course is updated by user.


### **Add Course**

- Course will be used to add the details about course of library.

#### *Request*

**Request Parameter** : 

- Request path -  http://localhost:8087/api/course
- Request Method - Post
- Request parameter - CourseDto

1. libraryId - string - **Required** - Logged in library id will be passed.
2. courseName - string - **Required** - Course name will be passed which is provided by library.


#### *Response*
 
 **response type** - Integer
 
 Course inserted successfully. Please check database to verify record.

 
#### *Method Requirements:*

1. Check all required fields values are passed or not. if required fields are not passed in request then throw exception.
2. It will check the course data duplication. If course name is same then throw exception.


#### *Acceptance Criteria*

**Criteria 1:** Required field 

*Request:* Field left empty.

*Expected Response:* Required Field cannot be empty

*Example:* Course name is empty.

*Expected Response:* Exception message - Course name is required.

*Request:* Course name provided.

*Expected Response:* Course name inserted successfully.


**Criteria 2:** field validation

*Request:* If field does not provide valid character.

*Expected Response:* Invalid character is not allowed.

*Example:* Course name contains invalid character or symbol.

*Expected Response:* Exception message - Invalid characters are not allowed in Course Name.

*Request:* Valid course name is provided.

*Expected Response:* Course name inserted successfully.


**Criteria 3:** Duplicate field

*Request:* If field data is same.

*Expected Response:* Field data is duplicate.

*Example:* If course name is same.

*Expected Response:* Exception message - Course name is duplicate.

*Request:* Different course name is provided.

*Expected Response:* Course name inserted successfully.


### **Update Course**

- This method will be used to update the course and modify details about promoted course.

#### *Request*

- Request path -  http://localhost:8087/api/course/{library_id}/{course_id}
- Request Method - Put
- Request parameter - CourseDto

1. libraryId - string - **Required** - Logged in library id will be passed.
2. courseId - string - **Required** - It will auto increment
3. courseName - string - **Required** - It will update the course details
4. pCourseId - string - **Optional** - Course Id will be passed. It will use the existing    course reference for promoted course details. It will allow only existing course data      to insert as promoted course.

#### *Response*

**response type** - Integer

```
Course updated successfully. Please check database to verify record.
```

#### *Method Requirements:*

1. Check library id exists or not.
2. Check course id exists or not.
3. Check course name is passed or not. if course name is not passed in request then throw    exception.
4. Use the existing course reference for promoted course details. It will allow only        existing course data to insert as promoted course.
5. Course will modify with promoted course if it is required by admin.
6. Check course duplicaition. If same course name is provided then throw exception.



#### *Acceptance Criteria*


**Criteria 1:** Existing record

*Request:* Record is not exist.

*Expected Response:* Record must exist.

*Example:* Course name is not exists.

*Expected Response:* Exception message - Course name is not exist.

*Request:* Course name is provided.

*Expected Response:* Course name updated successfully.


**Criteria 2:** Required field 

*Request:* Field left empty.

*Expected Response:* Required Field cannot be empty

*Example:* Course name is empty.

*Expected Response:* Exception message - Course name is required.

*Request:* Course name provided.

*Expected Response:* Course name updated successfully.


**Criteria 3:** Duplicate field

*Request:* Field data is same.

*Expected Response:* Field data is duplicate.

*Example:* Course name is same.

*Expected Response:* Exception message - Course name is duplicate.

*Request:* Different course name is provided.

*Expected Response:* Course name updated successfully.


**Criteria 4:** Promoted course details

*Provided:* Course details are provided.

*Request:* Field is required.

*Expected Response:* Course reference is passed.

*Example:* Promoted course is required.

*Expected Response:* Course reference is passed.

*Request:* Course name is provided.

*Expected Response:* Promoted course updated successfully.




### **Delete Course**

- This method will be used to delete any existing course and promoted course.

#### *Request*

- Request path -  http://localhost:8087/api/course/{library_id}/{course_id}
- Request Method - delete
- Request parameter - integer

1. libraryId - string - **Required** - Logged in library id will be passed.
2. courseId - string - **Required** - It will auto generated.

#### *Response*

```
Course deleted successfully. Please check database to verify record.
```

#### *Method Requirements:*
 
1. Check library id exists or not.
2. Check course id exists or not.

#### *Acceptance Criteria*


**Criteria 1:** Existing Record

*Request:* Record is not exist.

*Expected Response:* Record must exist.

*Example:* Course name is not exists.

*Expected Response:* Exception message - Course name is not exist.

*Request:* Course name is provided.

*Expected Response:* Course name deleted successfully.



