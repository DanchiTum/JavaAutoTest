package task6;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "AddressID", referencedColumnName = "id")
    private Address address;
    public Person() { }
    public Person(String name, int age, Address address, int id) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.id = id;
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}
    public int getId() {return id;}
    public void setId(int id) { this.id = id; }
}
