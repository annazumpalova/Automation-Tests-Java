import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class Example {
    public static void main(String[] args) {

        Student st1 = new Student();
        Student st2 = new Student(6, "Ivan","Ivanov");

        Worker worker1 = new Worker();
        Worker worker2 = new Worker("Pesho", "Ivanov", 7.7, 8);
    }
}
