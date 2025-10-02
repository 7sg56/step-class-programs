interface Printer {
    void connect();
}

interface Scanner {
    void connect();
}

class AllInOneMachine implements Printer, Scanner {
    @Override
    public void connect() {
        System.out.println("All-in-One Machine connected for printing and scanning.");
    }
}

public class AllInOneMachineTest {
    public static void main(String[] args) {
        Printer p = new AllInOneMachine();
        p.connect();

        Scanner s = new AllInOneMachine();
        s.connect();
    }
}
