import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "addresses")
@XmlAccessorType(XmlAccessType.FIELD)
public class Addresses {

    @XmlElement(name = "city")
    private List<City> cities = new ArrayList<>();

    public Addresses() {}

    public List<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (City c : cities) sb.append(c).append("\n");
        return sb.toString();
    }
}