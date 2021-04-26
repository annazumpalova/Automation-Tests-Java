package Task5;

public abstract class Animal {
    String name;
    String favouriteFood;

    public Animal(String name, String favFood) {
        this.setName(name);
        this.setFavouriteFood(favFood);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (!name.isEmpty() && !name.equals(" ")) {
            this.name = name;
        }
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    private void setFavouriteFood(String favouriteFood) {
        if (!favouriteFood.isEmpty() && !favouriteFood.equals(" ")) {
            this.favouriteFood = favouriteFood;
        }
    }

    public abstract String explainSelf();
}
