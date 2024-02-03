package be.hanagami.builder;


class Perso {
    public String nam;
    public int age;

    @Override
    public String toString() {
        return "Perso{" +
                "nam='" + nam + '\'' +
                ", age=" + age +
                '}';
    }
}

class CodeBuilderExo
{
    Perso perso = new Perso();
    public CodeBuilderExo(String nam)
    {
        perso.nam = nam;
    }

    public CodeBuilderExo addField(String nam, String type)
    {
        perso.nam = nam;
        return this;
    }

    public CodeBuilderExo addField(int age, String type)
    {
        perso.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "CodeBuilderExo{" +
                "perso=" + perso +
                '}';
    }
}

class ExoDemo
{
    public static void main(String[] args) {
        CodeBuilderExo cb = new CodeBuilderExo("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
    }
}

