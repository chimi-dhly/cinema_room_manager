package cinema;

public class Display extends Cinema{
    public static void displayMainMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }
    public static void displayCinema(Cinema cinema) {
        System.out.println("Cinema:");
        //display first line
        System.out.print(" ");
        for (int i = 1; i <= cinema.columns; i++) {
            System.out.printf(" %d", i);
        }
        System.out.print("\n");
        //display the rest of the grid
        for (int i = 0; i < cinema.rows ; i++) {
            System.out.printf("%d",i+1);
            for (int j = 0; j < cinema.columns; j++) {
                if (j < 10) {
                    System.out.printf(" %c", cinema.seats[i][j]);
                } else {
                    System.out.printf("  %c", cinema.seats[i][j]);

                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void statistics(Cinema cinema) {
        int purchasedTickets = calculatePurchasedTickets(cinema);
        double percentage = cinema.percentage();
        int totalIncome = cinema.totalIncome();
        System.out.printf("Number of purchased tickets: %d\n", purchasedTickets);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.printf("Current income: $%d\n", cinema.income);
        System.out.printf("Total income: $%d\n\n", totalIncome);
    }


    private static int calculatePurchasedTickets(Cinema cinema) {
        int counter = 0;
        for (char[] row :
                cinema.seats) {
            for (char seat :
                    row) {
                if (seat == 'B') {
                    counter++;
                }
            }
        }
        return counter;

    }
}
