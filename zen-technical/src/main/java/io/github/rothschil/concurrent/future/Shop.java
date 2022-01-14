package io.github.rothschil.concurrent.future;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Shop {

    private String code;

    public void setCode(String code) {
        this.code = code;
    }

    public Shop() {
    }

    public String getCode() {
        return code;
    }

    public Shop(String code) {
        this.code = code;
    }

    public int getPrice(String product){
        return calcPrice(product);
    }

    private int calcPrice(String product) {
        delayed();
        Random random = new Random();
        return random.nextInt(1000)*product.charAt(0)+product.charAt(1);
    }

    private void delayed() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
