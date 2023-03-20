package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    protected int rows ;
    protected int columns ;
    protected  char[] [] seats ;
    protected int purchasedSeats;
    protected int income ;
    protected State state ;

    public Cinema() {
    }

    protected double percentage() {
        double totalSeats = rows * columns;
        double purchaseSeats = (double)purchasedSeats;
        return purchasedSeats / totalSeats * 100;
    }

    public boolean isProgramRunning() {
        return state != State.OFF;
    }
    public void setUpCinema() {
        Cinema cinema = new Cinema();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        this.rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row");
        this.columns = scanner.nextInt();
        this.seats = new char[rows][columns];
        this.state = State.ON;
        fillCinemaArrayWithEmptySeats();
        System.out.println();
    }

    public void fillCinemaArrayWithEmptySeats() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = 'S';
            }
        }
    }

    public void pickASeat() {
        Scanner scanner = new Scanner(System.in);
        int rowNumber = 0, seatNumber = 0;
        boolean isRowValid = false, isSeatFound = false ;
        while (!isSeatFound) {
            isRowValid = false;
            while (!isRowValid) {
                System.out.println("Enter a row number:");
                rowNumber = scanner.nextInt();
                if (rowNumber > rows) {
                    System.out.println("Wrong input!");
                } else {
                    isRowValid = true;
                }
            }
            boolean isSeatValid = false;
            while (!isSeatValid) {
                System.out.println("Enter a seat number in that row:");
                seatNumber = scanner.nextInt();
                if (seatNumber > columns) {
                    System.out.println("Wrong input!");
                } else {
                    isSeatValid = true;
                }
            }
            if (seats[rowNumber - 1][seatNumber - 1] == 'S') {
                seats[rowNumber - 1][seatNumber - 1] = 'B';
                isSeatFound = true;
            } else {
                System.out.println("That ticket has already been purchased!");
                System.out.println();
            }
            purchasedSeats ++;
        }

        calculateTicketPrice(rowNumber, seatNumber);
    }

    private void calculateTicketPrice(int rowNumber, int columnNumber) {
        int price = 0;
        if (rows * columns < 60 || rowNumber <= rows / 2) {
            price = 10;
        } else {
            price = 8;
        }
        income += price;
        System.out.printf("Ticket price: $%d\n",price);
    }


    public static void promptInput() {
        System.out.println("Enter the number of rows:");
        Scanner scanner = new Scanner(System.in);
        int n_rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int n_columns = scanner.nextInt();
        System.out.println("Total income:");
        System.out.printf("$%d\n", calculateIncome(n_rows,n_columns));
    }



    private static int calculateIncome(int nRows, int nColumns) {
        final int NUMBER_OF_COLUMNS_LIMITED_IN_TOTAL = 60;
        final int TICKET_PRICE_IF_SMALL_ROOM = 10;
        final int TICKET_PRICE_LARGE_ROOM_FRONT_HALF = 10 ;
        final int TICKET_PRICE_LARGE_ROM_BACK_HALF = 8;
        if (nColumns * nRows < NUMBER_OF_COLUMNS_LIMITED_IN_TOTAL) {
            return TICKET_PRICE_IF_SMALL_ROOM * nRows * nColumns;
        }
        return (nRows / 2 * TICKET_PRICE_LARGE_ROOM_FRONT_HALF +
                (nRows - nRows / 2) * TICKET_PRICE_LARGE_ROM_BACK_HALF) * nColumns;
    }

    public void shutDown() {
        state = State.OFF;
    }


    protected int totalIncome() {
        int totalSeats = rows * columns;
        if (totalSeats < 60) {
            return totalSeats * 10;
        } else {
            return (rows / 2 * columns * 10 + ((rows - (rows / 2)) * columns * 8));
        }
    }
}