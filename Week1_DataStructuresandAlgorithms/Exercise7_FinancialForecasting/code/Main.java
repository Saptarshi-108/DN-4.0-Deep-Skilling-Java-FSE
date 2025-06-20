package Week1_DataStructuresandAlgorithms.Exercise7_FinancialForecasting.code;

public class Main {

    public static void main(String[] args) {

        FinancialTool ft = new FinancialTool();

        ft.financialForecast(20000.00, 0.055, 10);
        ft.financialForecast(90000.50, 0.045, 7);
        ft.financialForecast(49500.75, 0.062, 5);
        ft.financialForecast(62000.00, 0.038, 15);
        
    }
}