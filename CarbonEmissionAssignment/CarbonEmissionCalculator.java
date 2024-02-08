public class CarbonEmissionCalculator {

    public static double calculateCarbonEmission(int inboxMessageCount) {
        return inboxMessageCount * Constants.CARBON_EMISSION_CONSTANT;
    }
}
