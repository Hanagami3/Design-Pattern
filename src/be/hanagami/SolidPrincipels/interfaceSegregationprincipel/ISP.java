package be.hanagami.SolidPrincipels.interfaceSegregationprincipel;

class Document {}

interface Machine
{
    void print(Document d);
    void fax(Document d) throws Exception;
    void scan(Document d) throws Exception;
}

// ok if you need a multifunction machine
class MultiFunctionPrinter implements Machine
{
    @Override
    public void print(Document d) {
        //ok
    }

    @Override
    public void fax(Document d) {
        //ok
    }

    @Override
    public void scan(Document d) {
        //ok
    }
}

class OldFashionedPrinter implements Machine
{
    @Override
    public void print(Document d) {
        //ok
    }

    @Override //on doit alors spécifier dans l'interface
    public void fax(Document d) throws Exception {
            //pas ok
        throw new Exception();
    }

    @Override
    public void scan(Document d) throws Exception{
        //pas ok pour old
        throw new Exception();
    }
}

interface Printer
{
    void print(Document d) throws Exception;//?
}

interface Fax
{
    void fax(Document d) throws Exception;//?;
}

interface IScanner
{
    void scan(Document d) throws Exception;//?;
}

//YAGNI = You Ain't Going to Need It
class JustAPrinter implements Printer
{
    @Override
    public void print(Document d) {
        //ok
    }
}

class Photocopier implements Printer, IScanner
{
    @Override
    public void print(Document d) throws Exception //?
    {
        throw new Exception();//?
        //ok
    }

    @Override
    public void scan(Document d) throws Exception //?
    {
        throw new Exception();//?
        //ok
    }
}

interface  MultiFunctionDevice extends Printer, IScanner {}

class MultiFunctionMachine implements MultiFunctionDevice
{
    // compose this out of several modules
    private Printer printer;
    private IScanner scanner;

    public MultiFunctionMachine(Printer printer, IScanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document d) throws Exception //?
    {
        printer.print(d);
    }

    @Override
    public void scan(Document d) throws Exception //?
    {
        scanner.scan(d);
    }
}