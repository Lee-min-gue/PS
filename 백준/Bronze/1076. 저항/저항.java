import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        long[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        long[] multipliers = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

        String firstColor = scanner.next();
        String secondColor = scanner.next();
        String thirdColor = scanner.next();
        
        long firstValue = 0;
        long secondValue = 0;
        long multiplier = 0;

        for (int i = 0; i < colors.length; i++) {
            if (colors[i].equals(firstColor)) {
                firstValue = values[i];
            }
            if (colors[i].equals(secondColor)) {
                secondValue = values[i];
            }
            if (colors[i].equals(thirdColor)) {
                multiplier = multipliers[i];
            }
        }
        
        long resistance = (firstValue * 10 + secondValue) * multiplier;
        System.out.println(resistance);
    }
}
