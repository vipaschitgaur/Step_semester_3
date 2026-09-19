package arrays_basics.assigment_problems;
import java.util.Random;

public class BmiCalculator {
    public static void main(String[] args) {
        double[] heights = new double[10];
        double[] weights = new double[10];
        Random random = new Random();
        
        for (int i = 0; i < 10; i++) {
            heights[i] = 1.5 + (random.nextDouble() * 0.4); 
            weights[i] = 50 + (random.nextDouble() * 60);  
        }
        
        BmiCalculator calculator = new BmiCalculator();
        calculator.printWellnessReport(heights, weights);
    }

    public String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("Person %d | %.2f m | %.2f kg | %.2f | %s\n",
                              (i + 1), heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }
}
