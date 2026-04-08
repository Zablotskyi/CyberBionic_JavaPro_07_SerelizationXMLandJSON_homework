import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class AddressHandler extends DefaultHandler {

    private City city;
    private Street currentStreet;

    private boolean insideCity = false;           // чи ми всередині <city>
    private StringBuilder cityText = new StringBuilder();

    public City getCity() {
        return city;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("city".equals(qName)) {
            city = new City();
            city.size = attributes.getValue("size");
            insideCity = true;
            cityText.setLength(0);
        } else if ("street".equals(qName)) {
            currentStreet = new Street();
            currentStreet.name = attributes.getValue("name");
            city.streets.add(currentStreet);
        } else if ("house".equals(qName)) {
            String number = attributes.getValue("number");
            currentStreet.houses.add(new House(number));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (insideCity) {
            cityText.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("city".equals(qName)) {
            insideCity = false;

            // Беремо тільки перший рядок/перший “значущий” текст як назву міста
            // (бо всередині city є ще street/house і пробіли/переноси)
            String raw = cityText.toString().trim();

            // якщо у файлі: <city size="big">Kiev ...</city>
            // то raw починається з "Kiev"
            if (!raw.isEmpty()) {
                // беремо перше слово/рядок як назву
                String name = raw.split("\\s+")[0];
                city.name = name;
            }
        }
    }
}