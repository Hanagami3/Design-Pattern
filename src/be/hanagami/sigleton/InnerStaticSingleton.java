package be.hanagami.sigleton;
class InnerStaticSingleton
{
    private InnerStaticSingleton(){}

    private static class Impl
    {
        public static final InnerStaticSingleton
        INSTANCE = new InnerStaticSingleton();
    }

    public InnerStaticSingleton getInstance()
    {
        return Impl.INSTANCE;
    }
}
