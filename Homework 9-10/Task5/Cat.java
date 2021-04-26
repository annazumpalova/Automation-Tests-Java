package Task5;

public class Cat extends Animal{

    public Cat (String name, String favFood){
        super(name, favFood);
    }

    @Override
    public String explainSelf() {
        return String.format("Mrrr, I am %s and my favourite food is %s.", this.getName(), this.getFavouriteFood());
    }
}
