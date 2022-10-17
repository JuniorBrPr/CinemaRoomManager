import java.util.Scanner;

public class Main {
    final static Scanner in = new Scanner(System.in);
    static int rows, seats;

    public static void main(String[] args) {
        char[][] cinema = setCinema();
        int input;
        do {
            System.out.println("""
                                        
                    1. Show the seats
                    2. Buy a ticket
                    3. Statistics
                    0. Exit
                    """);
            input = in.nextInt();

            switch (input) {
                case 0 -> System.out.println("Goodbye!");
                case 1 -> displayCinema(cinema);
                case 2 -> buyTicket(cinema);
                case 3 -> showStatistics(cinema);
                default -> System.out.println("Invalid input");
            }
        } while (input != 0);
    }

    public static void showStatistics(char[][] cinema) {
        int purchasedTickets = 0;
        int currentIncome = 0;
        int totalIncome = 0;
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                if (i > 0 && j > 0) {
                    totalIncome += getPrice(i);
                }
                if (cinema[i][j] == 'B') {
                    purchasedTickets++;
                    currentIncome += getPrice(i);
                }
            }
        }

        double percentagePurchasedTickets = (double) purchasedTickets / (rows * seats) * 100;

        System.out.println("\nNumber of purchased tickets: " + purchasedTickets);
        System.out.printf("Percentage: %.2f%c%n", percentagePurchasedTickets, '%');
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

    public static void buyTicket(char[][] cinema) {
        int row, seat;
        boolean transactionSuccessful = false;
        do {
            System.out.println("\nEnter a row number: ");
            row = in.nextInt();
            System.out.println("Enter a seat number in that row: ");
            seat = in.nextInt();

            if (row > rows || seat > seats) {
                System.out.println("\nWrong input!");
            } else {
                if (cinema[row][seat] != 'B') {
                    cinema[row][seat] = 'B';
                    transactionSuccessful = true;
                } else {
                    System.out.println("That ticket has already been purchased!");
                }
            }
        } while (!transactionSuccessful);

        System.out.println("\nTicket price: $" + getPrice(row));
    }

    public static char[][] setCinema() {
        System.out.println("Enter the number of rows: ");
        rows = in.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        seats = in.nextInt();

        char[][] cinema = makeCinema(rows, seats);
        displayCinema(cinema);
        return cinema;
    }

    public static char[][] makeCinema(int rows, int seats) {
        char[][] cinema = new char[rows + 1][seats + 1];

        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                if (i == 0 && j != 0) {
                    cinema[i][j] = Integer.toString(j).charAt(0);
                } else if (i > 0 && j == 0) {
                    cinema[i][j] = Integer.toString(i).charAt(0);
                } else if (i > 0) {
                    cinema[i][j] = 'S';
                } else {
                    cinema[i][j] = ' ';
                }
            }
        }

        return cinema;
    }

    public static void displayCinema(char[][] cinema) {
        System.out.println("\nCinema:");
        for (char[] chars : cinema) {
            for (int j = 0; j < chars.length; j++) {
                System.out.print(chars[j] + " ");
                if (j == chars.length - 1) {
                    System.out.print("\n");
                }
            }
        }
    }

    public static int getPrice(int row) {
        int price;
        if (rows * seats < 60) {
            price = 10;
        } else {
            if (row <= (rows - rows % 2) / 2) {
                price = 10;
            } else {
                price = 8;
            }
        }
        return price;
    }
}