import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class House {

    @XmlAttribute(name = "number")
    private String number;

    public House() {}
    public House(String number) { this.number = number; }

    public String getNumber() { return number; }
}