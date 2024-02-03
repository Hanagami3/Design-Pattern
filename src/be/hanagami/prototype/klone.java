package be.hanagami.prototype;

import java.util.Arrays;

/**
 * not use cloneable
 */
class Adress implements Cloneable // empty interface
{
    public String streetName;
    public int houseNumber;

    public Adress(String streetName, int houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }

    //deep copy
    @Override
    public Object clone() throws CloneNotSupportedException // change from protected to public
    {
        return new Adress(streetName, houseNumber);
    }
}

class Person implements Cloneable
{
    public String [] names;
    public Adress adress;

    public Person(String[] names, Adress adress)
    {
        this.names = names;
        this.adress = adress;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "names=" + Arrays.toString(names) +
                ", adress=" + adress +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return new Person(
                names.clone(),
                (Adress) adress.clone());
    }
}

class Demo
{
    public static void main(String[] args) throws Exception {
        Person john = new Person(new String[]{"John", "Smith"},
                new Adress("London Road", 123));

//        Person jane = john; ==> not goed because jane and john referring to the same object by copying the reference
//        jane.names[0] = "Jane";
//        jane.adress.houseNumber = 124;
//        System.out.println(jane); Person{names=[Jane, Smith], adress=Adress{streetName='London Road', houseNumber=124}}
//        System.out.println(john); Person{names=[Jane, Smith], adress=Adress{streetName='London Road', houseNumber=124}}

        Person jane = (Person) john.clone();
        jane.names[0] = "Jane";
        jane.adress.houseNumber = 124;

        System.out.println(jane);
        System.out.println(john);
    }
}