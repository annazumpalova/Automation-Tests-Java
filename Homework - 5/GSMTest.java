public class GSMTest {
    public static void main(String[] args) {

        GSM arrGsm[] = new GSM[3];
        GSM gsmOne = new GSM();
        arrGsm[0] = gsmOne;
        GSM gsmTwo = new GSM();
        arrGsm[1] = gsmTwo;
        GSM gsmThree = new GSM();
        arrGsm[2] = gsmThree;
        int seconds = 180;

        gsmOne.model = "iPhone";
        gsmOne.manufacturer = "Apple";
        gsmOne.price = 1500;
        gsmOne.totalCallNumber = 3;
        gsmOne.batteryModel = "Lithium-ion";
        gsmOne.idleTime = 360;
        gsmOne.phoneUsageTime = 260;
        gsmOne.displayInches = 5.85;
        gsmOne.displayColor = new String[]{"red", "blue"};

        gsmTwo.model = "S9";
        gsmTwo.manufacturer = "Sumsung";
        gsmTwo.price = 1300;
        gsmTwo.totalCallNumber = 7;
        gsmTwo.batteryModel = "V Li-ion";
        gsmTwo.idleTime = 410;
        gsmTwo.phoneUsageTime = 320;
        gsmTwo.displayInches = 6.85;
        gsmTwo.displayColor = new String[]{"yellow", "green", "red"};

        gsmThree.model = "105";
        gsmThree.manufacturer = "Nokia";
        gsmThree.price = 500;
        gsmThree.totalCallNumber = 15;
        gsmThree.batteryModel = "Nokia battery";
        gsmThree.idleTime = 225;
        gsmThree.phoneUsageTime = 470;
        gsmThree.displayInches = 1.85;
        gsmThree.displayColor = new String[]{"green", "orange", "pink"};

        for (int k = 0; k < arrGsm.length; k++) {
            arrGsm[k].call(seconds);
            arrGsm[k].printPhoneDetailInformation();
            seconds = seconds + 60;
            System.out.print("\n\n");
        }
    }
}
