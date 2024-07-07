// The wrong way =================================
class BusinessLogic {
    private Printer printer;

    public BusinessLogic() {
        this.printer = new Printer(); 
    }

    public void execute() {
        printer.print(); 
    }
}

class Printer {
    public void print() {
        System.out.println("Printing...");
    }
}

public class ViolatingDIPExample {
    public static void main(String[] args) {
        BusinessLogic businessLogic = new BusinessLogic();
        businessLogic.execute(); 
    }
}




// The right way =================================

class BusinessLogic {
    private Device device;

    public BusinessLogic(Device device) {
        this.device = device;
    }

    public void execute() {
        device.operate();
    }
}

interface Device {
    void operate();
}

class Printer implements Device {
    @Override
    public void operate() {
        System.out.println("Printing...");
    }
}

class Scanner implements Device {
    @Override
    public void operate() {
        System.out.println("Scanning...");
    }
}

public class DIPExample {
    public static void main(String[] args) {
        Device printer = new Printer();
        BusinessLogic businessLogic1 = new BusinessLogic(printer);
        businessLogic1.execute();

        Device scanner = new Scanner();
        BusinessLogic businessLogic2 = new BusinessLogic(scanner);
        businessLogic2.execute();
    }
}

