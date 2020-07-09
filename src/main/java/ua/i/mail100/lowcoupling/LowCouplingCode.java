package ua.i.mail100.lowcoupling;

public class LowCouplingCode {
    private One one;
    private Two two;

    public LowCouplingCode(One one, Two two) {
        this.one = one;
        this.two = two;
    }

    public void actionOne() {
        one.print();
    }

    public void actionTwo() {
        two.print();
    }
}


