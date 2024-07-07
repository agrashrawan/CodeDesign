interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface MultiFunctionDevice extends Printer, Scanner {
}

class SimplePrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Printing...");
    }
}

class SimpleScanner implements Scanner {
    @Override
    public void scan() {
        System.out.println("Scanning...");
    }
}

class MultiFunctionPrinter implements MultiFunctionDevice {
    @Override
    public void print() {
        System.out.println("Printing...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning...");
    }
}

public class ISPExample {
    public static void main(String[] args) {
        Printer simplePrinter = new SimplePrinter();
        simplePrinter.print();  

        Scanner simpleScanner = new SimpleScanner();
        simpleScanner.scan();   

        MultiFunctionDevice multiFunctionPrinter = new MultiFunctionPrinter();
        multiFunctionPrinter.print(); 
        multiFunctionPrinter.scan();  
    }
}
