package be.hanagami.prototype;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

/**
 * on peut aussi uliliser la biblio reflection alors pas la pein d'implementer Serializable
 */
class Foo implements Serializable
{
    public int stuff;
    public String whatever;

    public Foo(int stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "stuff=" + stuff +
                ", whatever='" + whatever + '\'' +
                '}';
    }
}

class SerializationDemo{

    public static void main(String[] args)
    {
        Foo foo = new Foo(42, "life");
        Foo foo2 = SerializationUtils.roundtrip(foo);

        foo2.whatever ="xyz";

        System.out.println(foo);
        System.out.println(foo2);
    }
}
