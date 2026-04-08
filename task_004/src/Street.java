import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Street {

    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "house")
    private List<House> houses = new ArrayList<>();

    public Street() {}
    public Street(String name) { this.name = name; }

    public void addHouse(House h) { houses.add(h); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Street{name='" + name + "', houses=");
        for (int i = 0; i < houses.size(); i++) {
            sb.append(houses.get(i).getNumber());
            if (i < houses.size() - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}