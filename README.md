# CinemaRoomManager
## Description
This Java program is a simple cinema ticketing system that allows users to view the seats in the cinema, purchase 
tickets, and view statistics about ticket sales.

The main method contains a loop that presents the user with a menu of options and processes the selected option using 
a switch statement. The options are:

* `Show the seats`: calls the displayCinema method to print out a representation of the current state of the seats in the 
cinema.
* `Buy a ticket`: calls the buyTicket method, which prompts the user for a row and seat number and marks the selected seat 
as "purchased" if it is not already.
* `Statistics`: calls the showStatistics method, which calculates and displays the number of purchased tickets, the 
percentage of seats that have been purchased, the current income from ticket sales, and the total income that the 
cinema has made.
* `Exit`: exits the program.

## Methods
* `setCinema()`: prompts the user for the number of rows and seats in the cinema and creates a 2D char array to 
represent the seats. It then calls the displayCinema method to print out the initial state of the seats.

* `makeCinema()`: is called by the setCinema method and creates the 2D char array. It sets all seats to 'S' 
(for "available") and adds row and seat numbers to the first row and column of the array, respectively.

* `displayCinema()`: prints out a representation of the current state of the seats in the cinema, with row and seat 
numbers and an 'S' or 'B' for each seat to indicate whether it is available or purchased.

* `buyTicket()`: prompts the user for a row and seat number, and marks the selected seat as "purchased" if it is not
already. It also calculates and displays the price of the ticket based on the row number.

* `showStatistics()`: calculates and displays the number of purchased tickets, the percentage of seats that have 
been purchased, the current income from ticket sales, and the total income that the cinema has made. It iterates through
the 2D char array and counts the number of 'B's (purchased tickets) and adds up the total income and current income 
based on the row number of each 'B'. It then calculates the percentage of seats that have been purchased by dividing the
number of purchased tickets by the total number of seats and multiplying by 100.
