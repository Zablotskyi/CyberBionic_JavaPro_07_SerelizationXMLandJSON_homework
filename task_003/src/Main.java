import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

//Завдання 3
//Створіть клас, використовуючи SAXParser, де опишіть ієрархію XML файлу. Необхідно, щоб проект створював XML-файл і
//будував дерево (місто, назва вулиці, будинок). У місті використовуйте атрибут (наприклад, <city size=”big>Kiev</city>).

public class Main {
    public static void main(String[] args) {
        try {
            // 1) Створюємо XML файл
            Path path = Paths.get("addresses.xml");
            createXml(path);

            // 2) SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            AddressHandler handler = new AddressHandler();
            saxParser.parse(path.toFile(), handler);

            // 3) Виводимо дерево
            City city = handler.getCity();
            System.out.println(city);

        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private static void createXml(Path path) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<addresses>\n" +
                        "  <city size=\"big\">Slavutych\n" +
                        "    <street name=\"Dobryninskyi\">\n" +
                        "      <house number=\"10\"/>\n" +
                        "    </street>\n" +
                        "  </city>\n" +
                        "</addresses>\n";

        try (FileWriter fw = new FileWriter(path.toFile())) {
            fw.write(xml);
        }
    }
}
