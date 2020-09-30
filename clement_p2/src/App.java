import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    private static Scanner scan = new Scanner(System.in);

    private static boolean moreInput() {

        System.out.println("Would you like to input more info? (Y/N)");

        String response = scan.next();

        if (response.equals("Y"))
            return true;

        else if (response.equals("N"))
            return false;

        else {
            System.out.println("You must type either Y or N.");
            return moreInput();
        }

    }

    private static int getUserHeight () {

        boolean keepRunning = true;
        int response = 0;

        while (keepRunning) {
            System.out.println("Give me your height in inches.");
            response = scan.nextInt();

            if (response < 0) {
                System.out.println("Your height must be a positive number.");
                scan.nextLine();
            }
            else {
                keepRunning = false;
            }
        }

        return response;

    }

    private static double getUserWeight () {

        boolean keepRunning = true;
        int response = 0;

        while (keepRunning) {
            System.out.println("Give me your weight in pounds.");
            response = scan.nextInt();

            if (response < 0) {
                System.out.println("Your weight must be a positive number.");
                scan.nextLine();
            }
            else {
                keepRunning = false;
            }
        }

        return response;

    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.printf("Your BMI score is: %.1f\n", bmi.bmi_score);
        System.out.println("Your BMI category is: " + bmi.bmi_category);
        System.out.println("");
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        int size = bmiData.size();
        double total_score = 0;

        for (int i = 0; i < size; i++) {
            total_score += bmiData.get(i).bmi_score;
        }

        double average_score = total_score / size;

        System.out.printf("Your BMI score is: %.1f\n", average_score);
    }

}