## Table of contents
* [General info](#general-info)

* [Setup](#setup)

## General info
Simple CLI app that tracks working hours in memory. Per requirements I was expected to deliver:

● an interface that describes the behavior of the system;

● an implementation for this interface;

Which is nice, as it was clearly stated. However, putting everything in a single interface would brake the Single responsibility principle, so
I decided for every functionality to have a different interface. Namely - Validator(validates the input), Overtime(calculates the overtime) and 
TimeWorked(calculates the working time when entry is added). 
As structure for the project was missing, I opted for MVCS - Model holds the representation of a DB, View renders the input if validated and requested, 
the controller accepts the input and depending on the input either calls a Service to compute and add, or just calls the View to render the
output.	

	
## Setup
To run this project, ensure you have installed locally:
* Java >= 16.
Clone the repo and compile it.
