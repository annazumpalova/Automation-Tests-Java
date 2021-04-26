package Task5;

public class Dog extends Animal{
    public Dog (String name, String favFood){
        super(name, favFood);
    }

    @Override
    public String explainSelf() {
        return String.format("Bau, I am %s and my favourite food is %s.", this.getName(), this.getFavouriteFood());
    }
}
