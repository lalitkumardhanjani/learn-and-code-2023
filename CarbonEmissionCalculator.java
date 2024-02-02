public class CarbonEmissionCalculator {

    public static double calculateCarbonEmission(int inboxMessageCount) {
        double carbonEmissionConstant = 0.3;
        return inboxMessageCount * carbonEmissionConstant;
    }
}
