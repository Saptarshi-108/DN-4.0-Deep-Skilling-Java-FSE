package Week1_DataStructuresandAlgorithms.Exercise7_FinancialForecasting.code;

public class FinancialTool {

    private double futureValue;

    public void financialForecast(double presentValue, double growthRate, int timePeriod) {
        ForecastTool forecastTool = new ForecastTool();
        futureValue = forecastTool.futureForecast(presentValue, growthRate, timePeriod);

        System.out.println("Principal Amount = " + String.format("%.2f", presentValue)
                + ", Time Period = " + timePeriod
                + ", Annual Growth Rate = " + growthRate
                + ", Future Value = " + String.format("%.2f", futureValue) + "\n");
    }

}