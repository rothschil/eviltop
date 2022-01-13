package io.github.rothschil.design.strategy;

public class Shopping {

    private Payment payment;

    public Shopping(Payment payment) {
        this.payment = payment;
    }

    public void buyDesktop(){
        System.out.println("购买台式机");
        payment.payment();
    }


}
