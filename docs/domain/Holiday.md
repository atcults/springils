# Holiday 

### **Overview -**

- A library need to configure the days on which the library remains closed. This will ensure that dates of return of items circulated will not fall on holidays.
- It is not simple CRUD operation.
- Holidays will be configured as per selected fiscal year. 
- There is two type of holiday. one is repeated holiday. i.e, sunday is holiday every week. Second type is specific holiday. i.e, 14th january - uttarayan festival.
- Duplicate holidays are disallowed.

**Note:**
 
 1. Request header should have authenticated hearer token. The user should have admin privilege.
 2. entry_id is patron code who has sent REST request. As of now we do not have any security implementation so we will pass default value from ApiBase. One interface is required to check if request needs entry_id like we pass library_id from client.
 3. holi_type, entry_id, entry_date will not expose outside domain. NOTE: Follow fiscal year entity.
 	- holi_type : 'R'	 
 	- entry_date : Current Time
 	- entry_library_id : libraryId
 
- **Table name** - adm_co_holiday

  1. library_id - integer - Required
  - This is Primary key. Library reference passed for entry holiday. 
  2. fiscal_year - integer - Optional
  - Holiday will set under fiscal year
  3. holiday - date - Required
  - This is primary key. This field set date for that particular holiday.
  4. holi_type - string - length: 1 - Optional
  - Holiday type stores 'R' or 'S' value. 
  5. note - string - Optional
  - Description for holiday.
  6. entry_id - integer - Optional
  - patron's id.
  7. entry_library_id - integer - Optional
  - patron's library id.
  8. entry_date - date - Optional
  - record created date.
  
### **Add Holiday**

- Holidays will be defined under fiscal year so start date and date will be set as per fiscal year. Fiscal year is reference key in holiday.
 
#### *Request*

- Request path - http://localhost:8087/api/holiday
- Request Method - Post
- Request Parameter - HolidayDto


1. libraryId - string - Required - Logged in library id will be passed. 
2. fiscalYearId - string - Required -  fiscal year for declare holiday.
3. startDate - string - Required - Fiscal year start date will be set or start date can be any of between fiscal year. DateFormatExample : "1991-01-01"
4. endDate - string - Required - Fiscal year end date will be set or end date can be any of between fiscal year. DateFormatExample : "1991-01-01"
5. type - string - length : 1 - Required 
 Holiday type is enum type. It has two value 'R' and 'S'. 
  - R: Repeated holiday. Used in specifying weekly off. "note" should be empty or null. Converter should set default note as Day name. For example setting all Sundays should set note as "Sunday". If user has passed any note then it should raise validation exception.
  - S: Specific holiday. Used in specifying dates as off. "note" should be present. In converter it should seek for note if type "S" is selected. 
  	- For example -  14th january is holiday as uttarayan festival. If user has passed null then it should throw exception.
  	- 12th feb to 15th feb is holiday, these holidays type will be 'S' and note = vacation
  	-  Passing start date 8 Feb 2016 and end date 12 Feb 2016 with type 'S' and note as "Vacation" should add all days including 8 Feb 2016 till 12 Feb 2016. Total rows expected are 5. Dates should be 8, 9, 10, 11, 12.
  	- If holiday type is other than 'R' or 'S' then throw exception for unsupported holiday type.

6. note - string - Optional - note will set null if holiday type is 'R', otherwise it will set specific holiday reason.

 
 #### *Response*
 
 **response type** - 
 
 Record inserted successfully, please check database for verify record.
 
 #### *Method Requirements:*
 
  1. Check all required fields value passed or not. if required fields not passed in request then throw appropriate exception for required field.
  2. startDate and endDate should in valid format. If not in valid format then throw exception.
  3. if startDate is earlier than current date and fiscal year start date and if End Date is later than fiscal year end date and if End Date is earlier than start date then throw exception with appropriate error message.
  4. If requested holiday type is 'R' then repeated day of week will add and note = specific day name. and if holiday is exists and requested holiday type is "R" then it should skip all overlaping holidays.
 5. If requested holiday type is 'S' then holidayDate = specific date and note = reason of holiday is required and If holiday is exists and requested holiday or block having type is "S" then existing record's note field should overrite with reason of holiday.
    NOTE: This will provide higher priority to note field having type is "S"
 6. Check duplication of fiscal year.    
 7. If all validation checked then record will process for add in database.
 

#### *Acceptance Criteria*

**Criteria 1:** Required Field

*Request:* If field left empty.

*Expected Response:* Required Field cannot be empty

*Example* -  fiscal year is not passed in request.

*Expected Rresponse:* Exception message - Fiscal year is required field.
    	
 *Request*: Fiscal year provide.
        - Expected Response: Success Message

**Criteria 2:** regular expression validation

If StartDate and endDate is violated.

*Expected Response -*  Validate value with regular expression properly. Incorrect format

**Criteria 3:** 

*Provided:*

*Current date is 3 Feb 2016*

*Library:*
LibraryId: 1

*Patron:*
PatronId: 1 
	
*Fiscal Year:*
	
FiscalYearId: 20152016

StartDate: 01-03-2015

EndDate: 28-02-2016

Passing start date 2 Feb 2016 and end date 29 Feb 2016 with type 'R' should respond with validation error. Check this validation in workflow.

*Request:*

```
{ 
	"fiscalYearId": "20152016"
	"startDate" : "2015-12-31",
	"endDate": "2016-02-28",
	"type" : "R",
    "note" : "",
    "libraryId" : "1"
}
```

Expected Response:
```
"Start Date should not earlier than current date."
```

**Criteria 4:** 
Provided details - please look in criteria 2 provided.

Passing start date 6 Feb 2016 and end date 3 March 2016 with type 'R' should respond with 406 validation error. Check this validation in workflow.

*Request:*
```
{ 
	"fiscalYearId": "20152016"
	"startDate" : "2016-02-06",
	"endDate": "2016-03-03",
	"type" : "R",
    "note" : "",
    "libraryId" : "1"
}
```
Expected Response:
```
End Date should not later than fiscal end date.
```
NOTE: Criteria 2 and Criteria 3 are general criteria and applied to all user stories share single activiti-process named as **"ValidateStartEndDateOfHolidayDelegate"**

**Criteria 5:** 

Passing start date 7 Feb 2016 and end date 29 Feb 2016 with type 'R' should add all sundays including 7 Feb 2016 till 28 Feb 2016. Total rows expected are 4. Dates should be 7, 14, 21, 28.

*Request:*
```
{ 
	"fiscalYearId": "20152016"
	"startDate" : "2016-02-f07",
	"endDate": "2016-02-28",
	"type" : "R",
    "note" : "",
    "libraryId" : "1"
}
```

Expected Response:
```
Record created successfully. Please check database for verify record.
```

**Criteria 6**: Passing start date 8 Feb 2016 and end date 12 Feb 2016 with type 'S' and note as null. it should throw exception.

Request: 

```
{ 
	"fiscalYearId: "20152016"
	"startDate" : "2016-02-08",
	"endDate: "2016-02-12",
	"type" : "S",
    "note" : "",
    "libraryId" : "1"
}
```

Expected Response:
```
Please add note for holidays.
```

**Scenario 7**: Passing start date 8 Feb 2016 and end date 12 Feb 2016 with type 'S' and note as "Vacation" should add all days including 8 Feb 2016 till 12 Feb 2016. Total rows expected are 5. Dates should be 8, 9, 10, 11, 12.

Request: 

```
{ 
	"fiscalYearId": "20152016"
	"startDate" : "2016-02-08",
	"endDate": "2016-02-12",
	"type" : "S",
    "note" : "Vacation",
    "libraryId" : "1"
}
```

Expected Response:
```
Records created successfully. Please check database for verify record.
```
**Criteria 8:**

Passing start date 8 Feb 2016 and end date 8 Feb 2016 with type 'S' and note as "Holiday"  should add one holiday with provided date.

*Request:*

```
{ 
	"fiscalYearId": "20152016",
	"startDate" : "2016-02-08",
	"endDate: "2016-02-08",
	"type" : "S",
    "note" : "Holiday",
    "libraryId" : "1"
}
```

Expected Response:
```
Record created successfully. Please check database for verify record.
```


### **Delete Holiday**

- This method will be used to delete any existing holiday.

#### *Request*

*Path:* http://localhost:8087/api/holiday/{libraryId}/{fiscalYearId}/{startDate}/{endDate}/{type}
*Method:* Delete
1. libraryId - string - Required - Logged in library id will be passed. 
2. fiscalYearId - string - Required -  fiscal year for declare holiday.
3. startDate - string - Required - Fiscal year start date will be set or start date can be any of between fiscal year. DateFormatExample : "1991-01-01"
4. endDate - string - Required - Fiscal year end date will be set or end date can be any of between fiscal year. DateFormatExample : "1991-01-01"
5. type - string - length : 1 - Required - Its value can be 'R' or 'S'. R means repeated holidays and S means specific holidays

#### *Response*

```
Record deleted successfully. Please check database for verify.
```

 #### *Method Requirements:*
 
 1. Check holiday exists or not.
 2. Check all required fields value passed or not. if required fields not passed in request then throw exception.
 3. If date should pass in valid format. If dates not passed in valid format then throw wxception for date validation.
4. If type != 'R' or type != 'S' then throw exception for unsupported holiday type
5. If all record of request is validated then delete record from database.

#### *Acceptance Criteria*

**Criteria 1:**

delete any one day of weekly holiday start with specific day and ends at particular date. 

*Request:*
```
http://localhost:8087/api/holiday/1/2016-02-07/2016-02-29/R
```
Expected Response:
```
Exception - Fiscal year is required.
```

**Criteria 2:**

delete any one day of weekly holiday start with specific day and ends at particular date. 

Passing start date 7 Feb 2016 and end date 29 Feb 2016 with type 'R' should delete all sundays including 7 Feb 2016 till 28 Feb 2016. Total rows expected are 4. Dates 7, 14, 21, 28 should delete.

*Request:*
```
http://localhost:8087/api/holiday/1/20152016/7-2-2016/29-2-2016/R
```
Expected Response:
```
Exception - incorrect date format.
```
**Criteria 3:**

delete any one day of weekly holiday start with specific day and ends at particular date. 

Passing start date 7 Feb 2016 and end date 29 Feb 2016 with type 'R' should delete all sundays including 7 Feb 2016 till 28 Feb 2016. Total rows expected are 4. Dates 7, 14, 21, 28 should delete.

*Request:*
```
http://localhost:8087/api/holiday/1/20152016/2016-02-01/2016-02-29/R
```
Expected Response:
```
record deleted successfully. Please check database to verify process
```

**Criteria 4:**

delete holiday of same start and end date.

Passing start date 8 Feb 2016 and end date 8 Feb 2016 with type 'S' should delete one holiday.

*Request:*
```
http:localhost:8087/api/holiday/1/20152016/2016-02-08/2016-02-08/S
```
Expected Response:
```
Record deleted successfully. Please check database to verify process
```

**Criteria 5:**

delete holiday range from start and end date.

Passing start date 8 Feb 2016 and end date 12 Feb 2016 with type 'S' delete all days including 8 Feb 2016 till 12 Feb 2016. Total rows expected are 5. Dates should be 8, 9, 10, 11, 12 should delete.

*Request:*
```
http:localhost:8087/api/holiday/1/20152016/2016-02-08/2016-02-12/S
```
Expected Response:
```
Record deleted successfully. Please check database to verify process
```