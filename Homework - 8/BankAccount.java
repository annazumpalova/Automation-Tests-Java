import com.ibm.dtfj.javacore.parser.framework.parser.ILookAheadBuffer;
import jdk.nashorn.internal.ir.Splittable;

public class BankAccount {
    private String ownerName;
    private String name;
    private int IBAN;
    private double amount;

    public BankAccount(String ownerName, String name, int IBAN){
        this.setOwnerName(ownerName);
        this.setName(name);
        this.setIBAN(IBAN);
    }

    public BankAccount(String ownerName, String name, int IBAN, double amount){
        this(ownerName, name, IBAN);
        this.setAmount(amount);
    }

    public String getOwnerName() {
        return this.ownerName;
    }
    public String getName(){
        return this.name;
    }
    public int getIBAN(){
        return this.IBAN;
    }
    public double getAmount(){
        return this.amount;
    }
    public void setName(String name) {
        if(name!=null || !name.isEmpty()){
            this.name = name;
        }
    }

    private void setOwnerName(String wn){
        if(wn!=null && !wn.isEmpty()){
            this.ownerName = wn;
        }
    }

    private void setIBAN(int iban){
        if(iban>7){
            this.IBAN = iban;
        }
    }

    private void setAmount(double am){
        if(am > 0){
            this.amount = am;
        }
    }

    void depositMoney(double money){
        this.setAmount(money);
    }
    public double withdrawal(double money){
        if(money>this.getAmount()){
            setAmount(0);
            return getAmount();
        }
        setAmount(getAmount()-money);
        return money;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "ownerName='" + ownerName + '\'' +
                ", name='" + name + '\'' +
                ", IBAN=" + IBAN +
                ", amount=" + amount +
                '}';
    }
}
