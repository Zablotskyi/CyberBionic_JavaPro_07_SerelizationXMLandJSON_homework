import java.util.ArrayList;
import java.util.List;

public class Street {
    public String name;
    public List<House> houses = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Street{name='").append(name).append("', houses=");

        for (int i = 0; i < houses.size(); i++) {
            sb.append(houses.get(i).number);
            if (i < houses.size() - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}