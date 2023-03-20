package cinema;

import java.util.Scanner;

import static cinema.Cinema.promptInput;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        Cinema cinema = new Cinema();
        cinema.setUpCinema();
        while (cinema.isProgramRunning()) {
            Display.displayMainMenu();
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1 -> Display.displayCinema(cinema);
                case 2 -> cinema.pickASeat();
                case 3 -> Display.statistics(cinema);
                case 0 -> cinema.shutDown();
                default -> System.out.print("Wrong input!\n\n");

            }
        }

    }
}
