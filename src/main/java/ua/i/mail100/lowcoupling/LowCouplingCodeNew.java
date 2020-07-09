package ua.i.mail100.lowcoupling;

class LowCouplingCodeNew {
    private Printable printable;

    public LowCouplingCodeNew(Printable printable) {
        this.printable = printable;
    }

    public void action() {
        printable.print();
    }
}
