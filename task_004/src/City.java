import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    @XmlAttribute(name = "size")
    private String size;

    @XmlMixed
    @XmlElements({
            @XmlElement(name = "street", type = Street.class)
    })
    private List<Object> content = new ArrayList<>();

    public City() {}

    public City(String size, String name) {
        this.size = size;
        setName(name);
    }

    public String getSize() { return size; }

    public String getName() {
        for (Object o : content) {
            if (o instanceof String) {
                String s = ((String) o).trim();
                if (!s.isEmpty()) return s;
            }
        }
        return null;
    }

    public void setName(String name) {
        content.removeIf(o -> o instanceof String);
        content.add(0, name + "\n    ");
    }

    public void addStreet(Street s) {
        content.add(s);
        content.add("\n    ");
    }

    public List<Street> getStreets() {
        List<Street> streets = new ArrayList<>();
        for (Object o : content) {
            if (o instanceof Street) streets.add((Street) o);
        }
        return streets;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("City{name='").append(getName()).append("', size='").append(size).append("'}\n");
        for (Street st : getStreets()) sb.append("  ").append(st).append("\n");
        return sb.toString();
    }
}