package behavioral.strategy;

public class Main {
    public static void main(String[] args) {
        Shopee shopee = new Shopee();
        shopee.pay(new GCashPayment(), 500);
        shopee.pay(new CardPayment(), 1200);
    }
}

interface Payment {
    void pay(double amount);
}

class GCashPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("[GCash] Paying P" + amount + " with GCash");
    }
}

class CardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("[Card] Paying P" + amount + " with Credit Card");
    }
}

class Shopee {
    public void pay(Payment payment, double amount) {
        payment.pay(amount);
    }
}


