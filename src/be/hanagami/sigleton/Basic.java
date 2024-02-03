package be.hanagami.sigleton;

import java.io.*;

/**
 * 2 problemes avec cette façon de faire
 * 1: serialization
 * 2: trouver soi-même (reflection)
 */

class BasicSingleton implements Serializable
{
    // cannot new this class, however
    // *instance can be created deliberately (reflection)
    // *instance can be created accidentally (serialization)
    private BasicSingleton()// ne peut pas être appelé
    {
        System.out.println("Singleton is initializing");
    }

    public static final BasicSingleton INSTANCE
            = new BasicSingleton();

    public static BasicSingleton getInstance()
    {
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // required for correct serialization
    // readResolve is used for _replacing_ the object read from the stream
    protected Object readResolve()
    {
        return INSTANCE;
    }
}

class BasicSingletonDemo
{
    static void saveToFile(BasicSingleton singleton,
                           String filename)
        throws Exception
    {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String filename)
        throws Exception
    {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn))
        {
            return (BasicSingleton) in.readObject();
        }
    }

    public static void main(String[] args)
            throws Exception
    {

        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(123);
        System.out.println(singleton.getValue());

        // 1: reflection
        // 2: serialization

        BasicSingleton singleton1 = BasicSingleton.getInstance();
        singleton1.setValue(111);

        String fileName = "single.bin";
        saveToFile(singleton, fileName);

        singleton1.setValue(222);

        BasicSingleton singleton2 = readFromFile(fileName);

        System.out.println(singleton1 == singleton2);

        System.out.println(singleton1.getValue());
        System.out.println(singleton2.getValue());
    }

}
