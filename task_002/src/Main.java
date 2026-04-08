import java.io.*;

//Завдання 2
//Необхідно здійснити десеріалізацію з файлу попереднього проекту (Animal) та вивести на екран вміст.
public class Main {
    private static final String FILE_NAME = "animal.dat";

    public static void main(String[] args) {
        Animal animal = new Animal("Берта", 5, true);

        serializeAnimal(animal, FILE_NAME);
        Animal loaded = deserializeAnimal(FILE_NAME);
        System.out.println("Десеріалізовано з файлу: ");
        System.out.println(loaded);
    }

    private static void serializeAnimal(Animal animal, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(animal);
            System.out.println("Записано у файл: " + new File(fileName).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Помилка серіалізації: " + e.getMessage());
        }
    }

    private static Animal deserializeAnimal(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Animal) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка десеріалізації: " + e.getMessage());
            return null;
        }
    }
}