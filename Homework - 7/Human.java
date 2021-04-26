public class Human {
    String firstName;
    String lastName;

   public Human(){

   }

    public Human(String name, String familyName){
        this.firstName = name;
        this.lastName = familyName;
    }
    public void walk(){
        System.out.println("Walking...");
    }
}
