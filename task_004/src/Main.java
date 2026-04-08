import javax.xml.bind.*;
import java.nio.file.Path;
import java.nio.file.Paths;

//Завдання 4
//Використовуючи JAXB, виконати завдання №3.
public class Main {
    public static void main(String[] args) throws Exception {
        Path xml = Paths.get("addresses.xml");

        Addresses addresses = new Addresses();

        City city = new City("small", "Slavutich");
        Street s1 = new Street("Dobryninskyi");
        s1.addHouse(new House("10"));
        Street s2 = new Street("Bakynskyi");
        s2.addHouse(new House("25"));

        city.addStreet(s1);
        city.addStreet(s2);

        addresses.getCities().add(city);

        JAXBContext context = JAXBContext.newInstance(
                Addresses.class, City.class, Street.class, House.class
        );

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(addresses, xml.toFile());

        System.out.println("XML створено: " + xml.toAbsolutePath());

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Addresses loaded = (Addresses) unmarshaller.unmarshal(xml.toFile());

        System.out.println("\n--- Дерево після JAXB ---");
        System.out.println(loaded);
    }
}