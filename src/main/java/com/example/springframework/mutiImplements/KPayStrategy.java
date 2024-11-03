package com.example.springframework.mutiImplements;

public class KPayStrategy implements PayStrategy{
    @Override
    public void setData(Pay pay) {

    }

    @Override
    public void pay() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public String type() {
        return "KPay";
    }
}
