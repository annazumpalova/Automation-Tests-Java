public class GSM {
    String model;
    String manufacturer;
    int price;
    int totalCallNumber;
    String batteryModel;
    int idleTime;
    int phoneUsageTime;
    double displayInches;
    String[] displayColor;

    void call(int seconds) {
        totalCallNumber = totalCallNumber + 1;
        phoneUsageTime = phoneUsageTime + seconds;
    }

    void printPhoneDetailInformation() {
        System.out.println("GSM model: " + model);
        System.out.println("GSM manufacturer: " + manufacturer);
        System.out.println("GSM price: " + price);
        System.out.println("GSM minutes of calls: " + totalCallNumber);
        System.out.println("GSM battery model: " + batteryModel);
        System.out.println("GSM idle time: " + idleTime / 60 + " hours and " + idleTime % 60 + " minutes");
        System.out.println("GSM time usage : " + phoneUsageTime / 60 + " hours and " + phoneUsageTime % 60 + " minutes");
        System.out.println("GSM display inches: " + displayInches);

        System.out.print("GSM display color: ");
        for (int i = 0; i < displayColor.length; i++) {
            System.out.print(displayColor[i] + " ");
        }
    }
}
