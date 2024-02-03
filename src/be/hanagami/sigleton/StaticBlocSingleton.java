package be.hanagami.sigleton;


import java.io.File;
import java.io.IOException;

class StaticBlocSingleton
{
    private StaticBlocSingleton() throws IOException
    {
        System.out.println("Singleton is initializing");
        File.createTempFile(".", ".");
    }

    private static StaticBlocSingleton instance;

    static
    {
        try
        {
            instance = new StaticBlocSingleton();
        }
        catch (Exception e)
        {
            System.err.println("failed to create singleton");
        }
    }

    public static StaticBlocSingleton getInstance()
    {
        return instance;
    }
}
