# StudentWebService

- web servis za povezivanje s bazom podataka i uređivanje osnovnih podataka o studentima
- korišten Java Spark Framework
- radi s SQL Server bazom, potrebno je podesiti connection string i kreirati tablicu sljedećom skriptom:

CREATE TABLE [dbo].[Students](
	[studentId] [int] IDENTITY(1,1) NOT NULL,
	[firstName] [nvarchar](50) NULL,
	[lastName] [nvarchar](50) NULL,
	[createdOn] [date] NULL,
	[oib] [nvarchar](50) NULL,
	[modifiedOn] [date] NULL,
	[birthDate] [date] NULL,
	[countryOfBirth] [nvarchar](50) NULL,
	[placeOfBirth] [nvarchar](50) NULL,
	[enrollmentDate] [date] NULL
)

- default localhost port je 4567

- API endpointovi:
<br/>
localhost:4567/get<br/>
method: GET<br/>
<br/>
- vraća podatke o svim studentima u JSON formatu<br/>
<br/>
localhost:4567/insert<br/>
method: POST<br/>
primjer requesta: <br/>
{"firstName":"Ana","lastName":"Anić","oib":"12345678901","birthDate":"svi 5, 1990","countryOfBirth":"Hrvatska","placeOfBirth":"Zagreb","enrollmentDate":"ruj 9, 2017"}<br/>
<br/>
- sprema podatke o novom studentu u bazu<br/>
<br/>
localhost:4567/update<br/>
method: POST<br/>
primjer requesta: <br/>
{"studentId":6, "firstName":"Ivan","lastName":"Ivić","oib":"98765432109","birthDate":"svi 5, 1990","countryOfBirth":"Hrvatska","placeOfBirth":"Split","enrollmentDate":"ruj 9, 2017"}<br/>
<br/>
- ažurira podatke studenta s navedenim "studentId"<br/>
<br/>
localhost:4567/delete<br/>
method: POST<br/>
primjer requesta:<br/>
{"studentId":6}<br/>
<br/>
- briše studenta s navedenim "studentId"<br/>




