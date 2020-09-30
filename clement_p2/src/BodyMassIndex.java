public class BodyMassIndex {

    public String bmi_category;
    public double bmi_score;

    public BodyMassIndex(double height, double weight) {
        this.bmi_score = find_score(height, weight);
        this.bmi_category = find_category(height, weight);
    }

    private double find_score (double height, double weight) {
        return 703 * weight / (height * height);
    }

    private String find_category (double height, double weight) {

        double bmi_score = find_score(height, weight);

        if (bmi_score < 18.5)
            return "Underweight";
        else if (bmi_score >= 18.5 && bmi_score < 25)
            return "Normal weight";
        else if (bmi_score >= 25 && bmi_score < 30)
            return "Overweight";
        else if (bmi_score >= 30)
            return "Obesity";
        else
            return ("An error has occurred while finding your BMI.");

    }

}
