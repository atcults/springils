# Department

- It is a simple CRUD operation.

- Database schema - 
	- 	table name - dept
```
CREATE TABLE public.dept
(
  library_id integer NOT NULL,
  dept_id integer NOT NULL,
  dept_name character varying(100),
  hod_id character varying(20),
  entry_id character varying(20),
  entry_date timestamp without time zone,
  CONSTRAINT dept_pkey PRIMARY KEY (library_id, dept_id),
  CONSTRAINT fk_dept_library FOREIGN KEY (library_id)
      REFERENCES public.library (library_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_dept_patron FOREIGN KEY (library_id, hod_id)
      REFERENCES public.patron (library_id, patron_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_dept_patron1 FOREIGN KEY (library_id, entry_id)
      REFERENCES public.patron (library_id, patron_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
```

- **note** - department table is not using, entry_library_id is not there in dept table schema.
- if HOD(Head of Department) provided then patron_id will set and patron_id should valid from valid library	
- valiation - check department name should not duplicate.
- In bpmn process activity, **"department name"** should check, patron_id should check if hod provided.
 - LibraryId exists should check.
 - entry_id is patron id who has sent REST request. As of now we do not have any security implementation so we will pass default value from ApiBase. One interface is required to check if request needs entry_id like we pass library_id from client.
 - entry_id, entry_date will not expose outside domain. NOTE: Follow fiscal year entity.
  	- entry_date : Current Time
 	- entry_id : Patron Id
 

### Provided:

*Current date is 3 Feb 2016*

*Library:*
	
LibraryId: 1

*Patron:*

PatronId: 1 
	
**NOTE: Request header should have authenticated hearer token. The user should have admin privilege.**

**Limitation:** Due to non availability of Security Module we are unable to extract requested user.

**Special case**: If HOD will provide using patron search filter and patron_id will store in database.


### User story 1
 
I want to add department in library. 


**Scenario 1**: Passing department name.

*Request:*

```
{ 
	"departmentName" : "Inforamation and technology",
    "libraryId" : "1"
}
```

Response:

```
200 - ok
1 //department Id.
```

**Secnario 2**: not Passing department name and should respond with **baki** error. Check this validation in workflow.

*Request:*

```
{ 
	'departmentName" : "",
    "libraryId" : "1"
}
```

Response:

```
406 - Conflict **need to check**

{
  "errors": [
    {
      "messages": [
        "department should require."
      ],
      "filedNames": [
        "departmentName"
      ]
    }
  ],
  "valid": false
}

```

NOTE: Scenario 2 is general scenario and applied to all user stories share single activiti-process named as **ProcessCheckDeaparmentDelegate"**


### User story 2
 
I want to add department with head of department.

**Scenario 1**: Passing departmentName and hod id.

*Request:*

```
{ 
	"department: "Medical",
    "hod" : "1",
	"libraryId" : "1"
}
```

Response:

```
200 - ok

2 // department id