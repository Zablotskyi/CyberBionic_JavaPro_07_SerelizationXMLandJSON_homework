import java.io.Serializable;

public class Animal implements Serializable {
    private static final long serialVersionUID = 1l;
    private String name;
    private int age;
    private boolean hasTail;

    public Animal() {
    }

    public Animal(String name, int age, boolean hasTail) {
        this.name = name;
        this.age = age;
        this.hasTail = hasTail;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hasTail=" + hasTail +
                '}';
    }
}
