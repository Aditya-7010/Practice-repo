package DeepSkill.DataStructuresandAlgorithms.FinancialForecasting;
public class FinancialForecast {

    public static double predictFutureValue(double currentValue, double growthRate, int years) {

        if (years == 0) 
            return currentValue;

        return predictFutureValue(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {

        double currentValue = 43094;
        double growthRate = 0.29; 
        int years = 3;

        double futureValue = predictFutureValue( currentValue, growthRate, years);

        System.out.println( "Predicted Value after" + years + " years = " + futureValue);
    }
}