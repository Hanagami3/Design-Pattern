package be.hanagami.builder;

class Person
{
    public String name2;
    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name2='" + name2 + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

//class PersonBuilder
//{
//    protected Person person = new Person();
//
//    public PersonBuilder withName(String name2)
//    {
//        person.name2 = name2;
//        return this;
//    }
//
//    public  Person build()
//    {
//        return person;
//    }
//}

class PersonBuilder<SELF extends PersonBuilder<SELF>>
{
    protected Person person = new Person();

    // critical to return SELF here
    public SELF withName(String name2)
    {
        person.name2 = name2;
        return self();
    }

    public  Person build()
    {
        return person;
    }

    protected SELF self()
    {
        // unchecked cast, but actually safe
        // proof: try sticking a non-PersonBuilder
        //           as SELF parameter; it won't work!'
        return (SELF) this;
    }
}

//class PersonBuilde
//{
//    protected Person person = new Person();
//
//    public PersonBuilder withName(String name2)
//    {
//        person.name2 = name2;
//        return this;
//    }
//
//    public  Person build()
//    {
//        return person;
//    }
//}



class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>
{
    public EmployeeBuilder workAt(String position)
    {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self()
    {
        return this;
    }
}

class RecursiveGenericsDemo
{
    public static void main(String[] args)
    {
        EmployeeBuilder pb = new EmployeeBuilder();
        Person dmitri = pb
                .withName("Dmitri")
                //.worksAt //don't work
                .workAt("Developer")
                .build();
        System.out.println(dmitri);
    }
}
