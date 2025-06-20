package Week1_DataStructuresandAlgorithms.Exercise7_FinancialForecasting.code;

public class ForecastTool {

    public double futureForecast(double presentValue, double growthRate, int timePeriod) {
        if (timePeriod <= 0) {
            return presentValue;
        }
        return futureForecast(presentValue, growthRate, timePeriod - 1) * (1 + growthRate);
    }

}