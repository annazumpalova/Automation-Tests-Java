public class Student extends Human {
    double evaluation;

    public Student() {
        super(); // nqma znachenie dali go ima no se maha
    }
    public Student (double evaluation, String name, String familyName){
        super(name, familyName);
    }
    public void goToSchool(){
        System.out.print("Going to school...");
    }
}
