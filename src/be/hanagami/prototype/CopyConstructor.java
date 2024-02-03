package be.hanagami.prototype;

class Address
{
    public String streetAdress, city, country;

    public Address(String streetAdress, String city, String country) {
        this.streetAdress = streetAdress;
        this.city = city;
        this.country = country;
    }

    public Address(Address other)
    {
        this(other.streetAdress, other.city, other.country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAdress='" + streetAdress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

class Employee {
    public String name1;
    public Address address;

    public Employee(String name1, Address address) {
        this.name1 = name1;
        this.address = address;
    }

    public Employee(Employee other) {
        name1 = other.name1;
        address = new Address(other.address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name1='" + name1 + '\'' +
                ", address=" + address +
                '}';
    }
}
class CopyConstructorDemo
{
    public static void main(String[] args)
    {
        Employee john = new Employee("John",
                new Address("123 London Road", "London", "UK"));

        //Employee chris = john;
        Employee chris = new Employee(john);

        chris.name1 = "Chris";
        System.out.println(john);
        System.out.println(chris);
    }

}
