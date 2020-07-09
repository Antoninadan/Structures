package ua.i.mail100.lowcoupling;

class TestLowCoupling {
    public static void main(String[] args) {
        Printable one = new One();
        Printable two = new Two();

        new LowCouplingCodeNew(one);



    }
}
