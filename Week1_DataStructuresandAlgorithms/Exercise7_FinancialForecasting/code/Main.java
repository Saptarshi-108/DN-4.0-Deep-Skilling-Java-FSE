package Week1_DataStructuresandAlgorithms.Exercise7_FinancialForecasting.code;

public class Main {

    public static void main(String[] args) {

        FinancialTool ft = new FinancialTool();

        ft.financialForecast(15000.00, 0.055, 10);
        ft.financialForecast(85000.50, 0.045, 7);
        ft.financialForecast(37500.75, 0.062, 5);
        ft.financialForecast(60000.00, 0.038, 15);

    }

}