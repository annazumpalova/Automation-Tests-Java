public class Worker extends Human{
    double paidPerHour;
    int workingHour;

    public Worker(){

    }

    public Worker(String name, String familyName, double paidP, int wHours) {
        super(name, familyName);
        this.paidPerHour = paidP;
        this.workingHour = wHours;
    }

    public double calculateSalary(){
        double total = 0;
        if(this.workingHour > 0 && this.paidPerHour > 0){
            total = this.paidPerHour*this.workingHour;
        }
        return total;
    }
}
