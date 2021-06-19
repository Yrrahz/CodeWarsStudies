public class Person {
    public String name;    // team member's name
    public int happiness;  // happiness rating out of 10
    public String department;

    public Person(String name, int happiness){
        this.name = name;
        this.happiness = happiness;
    }

    public Person(String name, String department){
        this.name = name;
        this.department = department;
    }
}
