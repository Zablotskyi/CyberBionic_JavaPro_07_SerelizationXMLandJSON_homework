import java.util.ArrayList;
import java.util.List;

public class City {
    public String name;
    public String size;
    public List<Street> streets = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("City{name='").append(name)
                .append("', size='").append(size)
                .append("'}\n");

        for (Street s : streets) {
            sb.append("  ").append(s).append("\n");
        }
        return sb.toString();
    }
}