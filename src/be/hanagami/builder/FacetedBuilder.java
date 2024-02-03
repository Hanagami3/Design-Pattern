package be.hanagami.builder;

class Person1
{
    //address
    public String streetAdress, postcode, city;

    // employment
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Person1{" +
                "streetAdress='" + streetAdress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}

//builder facade
class PersonBuilder1
{
    //the object we're going to build
    protected Person1 person1 = new Person1(); // reference!

    public PersonAddressBuilder lives()
    {
        return new PersonAddressBuilder(person1);
    }

    public PersonJobBuilder works()
    {
        return  new PersonJobBuilder(person1);
    }

    public Person1 build()
    {
        return person1;
    }
}

class PersonAddressBuilder extends PersonBuilder1
{
    public PersonAddressBuilder(Person1 person1)
    {
        this.person1 = person1;
    }

    public PersonAddressBuilder at(String streetAddress)
    {
        person1.streetAdress = streetAddress;
        return this;
    }

    public PersonAddressBuilder withPostcode(String postcode)
    {
        person1.postcode = postcode;
        return this;
    }

    public PersonAddressBuilder in(String city)
    {
        person1.city = city;
        return this;
    }
}

class PersonJobBuilder extends PersonBuilder1
{
    public PersonJobBuilder(Person1 person1)
    {
        this.person1 =  person1;
    }
    public PersonJobBuilder at(String companyName)
    {
        person1.companyName = companyName;
        return this;
    }

    public PersonJobBuilder asA(String position)
    {
        person1.position = position;
        return this;
    }

    public PersonJobBuilder earning(int annualIncome)
    {
        person1.annualIncome = annualIncome;
        return this;
    }
}

class BuilderFacetsDemo
{
    public static void main(String[] args) {
        PersonBuilder1 pb1 = new PersonBuilder1();
        Person1 person1 = pb1
                .lives()
                    .at("123 London Road")
                    .in("London")
                    .withPostcode("SW12BC")
                .works()
                    .at("Fabrikam")
                    .asA("Engineer")
                    .earning(123000)
                .build();
        System.out.println(person1);
    }
}
