import java.util.Scanner;

public class InsurancePremiumCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        String buildingType = sc.nextLine().trim();
        double amount = sc.nextDouble();
        int claims = sc.nextInt();

        double premium = 0;
        double processingCharge = 0;
        double bonusRate = 0;

        if (buildingType.equalsIgnoreCase("Domestic")) {

            // Rate calculation
            if (amount < 100000) {
                premium = amount * 0.003;
            } else {
                premium = amount * 0.0025;
            }

            processingCharge = 50;

            // No-claim bonus
            if (claims == 0) {
                bonusRate = 0.10;
            }

        } else if (buildingType.equalsIgnoreCase("Commercial")) {

            // Rate calculation
            if (amount < 250000) {
                premium = amount * 0.005;
            } else {
                premium = amount * 0.0075;
            }

            processingCharge = 80;

            // No-claim bonus
            if (claims == 0) {
                bonusRate = 0.15;
            }
        }

        // Total before discount
        double total = premium + processingCharge;

        // Apply bonus
        double discount = total * bonusRate;
        double finalPremium = total - discount;

        // Output (rounded to 2 decimal places)
        System.out.printf("%.2f", finalPremium);

        sc.close();
    }
}
