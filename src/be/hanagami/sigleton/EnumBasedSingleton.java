package be.hanagami.sigleton;

import java.io.*;

enum EnumBasedSingleton
{
    INSTANCE;

    EnumBasedSingleton() //constructor always private in an Enum
    {
        value = 42;
    }
    private int value;

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }
}

class Demo
{
    static void saveToFile(EnumBasedSingleton singleton,
                           String filename)
            throws Exception
    {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(singleton);
        }
    }

    static EnumBasedSingleton readFromFile(String filename)
            throws Exception
    {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn))
        {
            return (EnumBasedSingleton) in.readObject();
        }
    }

    public static void main(String[] args)
            throws Exception
    {
        String fileName = "myfile.bin";

        EnumBasedSingleton singleton = EnumBasedSingleton.INSTANCE;
        singleton.setValue(111);
        saveToFile(singleton, fileName);

        EnumBasedSingleton singleton2 = readFromFile(fileName);
        System.out.println(singleton2.getValue());
    }
}
