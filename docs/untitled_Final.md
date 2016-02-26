# Holiday 

- It is not simple CRUD operation.
- In UI it should set like calender view. All months of selected fiscal year will set.
```
                                          	 2016 
                                          JANUARY
                        S	M	T	W	T	F	S
                        					1	2
                        3	4	5	6	7	8	9
                        10	11	12	13	14	15	16
                        17	18	19	20	21	22	23
                        24	25	26	27	28	29	30
                        31	
```
		

- Database schema - 
```
CREATE TABLE public.adm_co_holiday
(
  library_id integer NOT NULL,
  fiscal_year bigint,
  holiday timestamp without time zone NOT NULL,
  holi_type character(1),
  note character varying(100),
  entry_id character varying(20),
  entry_library_id integer,
  entry_date timestamp without time zone,
  CONSTRAINT adm_co_holiday_pkey PRIMARY KEY (library_id, holiday),
  CONSTRAINT fk_adm_co_holiday_acc_fiscal_year FOREIGN KEY (library_id, fiscal_year)
  REFERENCES public.acc_fiscal_year (library_id, fiscal_year) MATCH SIMPLE 
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_adm_co_holiday_patron FOREIGN KEY (entry_library_id, entry_id)
  REFERENCES public.patron (library_id, patron_id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
)
```

 - Holidays are defined under fiscal year. so fiscal year is reference key in holiday.
 - In bpmn process activity, **"fiscal year exists"** should check.
 - holiday_date and library id is primary key.
 - LibraryId exists should check.
 - entry_id is patron id who has sent REST request. As of now we do not have any security implementation so we will pass default value from ApiBase. One interface is required to check if request needs entry_id like we pass library_id from client.
 - holi_type, entry_id, entry_date will not expose outside domain. NOTE: Follow fiscal year entity.
 	- holi_type : 'R'	 
 	- entry_date : Current Time
 	- entry_library_id : libraryId
 

### Provided:

*Current date is 3 Feb 2016*

*Library:*
	
LibraryId: 1

*Patron:*

PatronId: 1 
	
*Fiscal Year:*
	
FiscalYearId: 20152016

StartDate: 01/03/2015

EndDate: 28/02/2016

**NOTE: Request header should have authenticated hearer token. The user should have admin privilege.**

**Limitation:** Due to non availability of Security Module we are unable to extract requested user.

**Type Enum:**
- R: Repeated holiday. Used in specifying weekly off. "note" should be empty or null. Converter should set default note as Day name. For examply setting all Sundays should set note as "Sunday". If user has passed any note then it should raise validation exception.
- S: Specific holiday. Used in specifying dates as off. "note" should be present. In converter it should seek for note if type "S" is selected.

**Special case**: If requested holiday or block having type is "S" then existing record's note field should overrite. If requested holiday type is "R" then it should skip all overlaping holidays. This will provide higher priority to note field having type is "S".


### User story 1
 
I want to add any one day as weekly holiday start with specific day and ends at perticular date. 


**Scenario 1**: Passing start date 7 Feb 2016 and end date 29 Feb 2016 with type 'R' should add all sundays including 7 Feb 2016 till 28 Feb 2016. Total rows expected are 4. Dates should be 7, 14, 21, 28.

*Request:*

```
{ 
	"fiscalYearId: "20152016"
	"startDate" : "2016/02/07",
	"endDate: "2016/02/28",
	"type" : "R",
    "note" : "",
    "libraryId" : "1"
}
```

Response:

```
204 - no content
```

**Secnario 2**: Passing start date 2 Feb 2016 and end date 29 Feb 2016 with type 'R' should respond with 406 validation error. Check this validation in workflow.

NOTE: Check for add past holiday 

*Request:*

```
{ 
	"fiscalYearId: "20152016"
	"startDate" : "2015/12/31",
	"endDate: "2016/02/28",
	"type" : "R",
    "note" : "",
    "libraryId" : "1"
}
```

Response:

```
406 - Conflict

{
  "errors": [
    {
      "messages": [
        "Start Date should not earlier than current date."
      ],
      "filedNames": [
        "startDate"
      ]
    }
  ],
  "valid": false
}

```

**Secnario 3**: Passing start date 6 Feb 2016 and end date 3 March 2016 with type 'R' should respond with 406 validation error. Check this validation in workflow.

*Request:*

```
{ 
	"fiscalYearId: "20152016"
	"startDate" : "2016/02/06",
	"endDate: "2016/03/03",
	"type" : "R",
    "note" : "",
    "libraryId" : "1"
}
```

Response:

```
406 - Conflict

{
  "errors": [
    {
      "messages": [
        "End Date should not later than fiscal end date."
      ],
      "filedNames": [
        "endDate"
      ]
    }
  ],
  "valid": false
}
```

NOTE: Scenario 2 and Scenario 3 are general scenario and applied to all user stories share single activiti-process named as **"ValidateStartEndDateOfHolidayDelegate"**


### User story 2
 
I want to add holiday range from start and end date with specific note provided by me. 


**Scenario 1**: Passing start date 8 Feb 2016 and end date 8 Feb 2016 with type 'S' and note as "Diu tour hangover"  should add one holiday with provided date.

*Request:*

```
{ 
	"fiscalYearId: "20152016",
	"startDate" : "2016/02/08",
	"endDate: "2016/02/08",
	"type" : "S",
    "note" : "Diu tour hangover",
    "libraryId" : "1"
}
```

Response:

```
204 - no content
```


**Scenario 2**: Passing start date 8 Feb 2016 and end date 12 Feb 2016 with type 'S' and note as "Vacation" should add all days including 8 Feb 2016 till 12 Feb 2016. Total rows expected are 5. Dates should be 8, 9, 10, 11, 12.

Request: 

```
{ 
	"fiscalYearId: "20152016"
	"startDate" : "2016/02/08",
	"endDate: "2016/02/12",
	"type" : "S",
    "note" : "Vacation",
    "libraryId" : "1"
}
```

Response:

```
204 - no content
```

### User story 3
 
I want to delete any one day of weekly holiday start with specific day and ends at perticular date. 


**Scenario 1**: Passing start date 7 Feb 2016 and end date 29 Feb 2016 with type 'R' should delete all sundays including 7 Feb 2016 till 28 Feb 2016. Total rows expected are 4. Dates 7, 14, 21, 28 should delete.

*Request:*

```
http:localhost:8087/api/holiday/{libraryId}/{fiscalYearId}/{startDate}/{endDate}/{type}
```

Response:

```
204 - no content
```

### User story 4
 
I want to delete holiday range from start and end date.


**Scenario 1**: Passing start date 8 Feb 2016 and end date 8 Feb 2016 with type 'S' should delete one holiday.

*Request:*

```
http:localhost:8087/api/holiday/{libraryId}/{fiscalYearId}/{startDate}/{endDate}/{type}
```

Response:

```
204 - no content
```


**Scenario 2**: Passing start date 8 Feb 2016 and end date 12 Feb 2016 with type 'S' delete all days including 8 Feb 2016 till 12 Feb 2016. Total rows expected are 5. Dates should be 8, 9, 10, 11, 12 should delete.

Request: 

```
http:localhost:8087/api/holiday/{libraryId}/{fiscalYearId}/{startDate}/{endDate}/{type}
```

Response:

```
204 - no content
```
