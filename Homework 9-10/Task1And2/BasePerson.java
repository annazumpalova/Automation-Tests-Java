package Task1And2;

public abstract class BasePerson {
    String name;

    public BasePerson(String personName) {
        this.setName(personName);
    }

    private void setName(String name) {
        if (!name.isEmpty() && name != null) {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }
}
