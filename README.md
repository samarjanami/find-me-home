# find-me-home

Web application to search for real estate properties and displaying detailed property information.

## Instructions
Make sure to replace [RESO Web API](https://bridgedataoutput.com/docs/platform/API/reso-web-api) token in application.properties file:
```
server.token =[---Replace server token here---]
```
## Demo Application
Visit [find-me-home](https://find-me-home.herokuapp.com/) for live demo of the application. Since a test API (RESO / Austin Board of Realtors Developers Reference Server) is used for the demo app, only listings that were sold in the Austin market over a year ago are available. Please note that since these were actual listings, the photos are blurred out. Here are some search criteria that will return some results:

ZipCode: 78654, Min-Beds: 4, Min-Bathroom: 3

ZipCode: 78623, Min-Price: $300,000

## Tools and Technologies
Java, Maven, Spring Boot, Spring MVC, ThymeLeaf, HTML, CSS, JavaScript, JQuery, AJAX  