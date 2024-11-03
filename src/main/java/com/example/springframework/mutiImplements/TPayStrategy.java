package com.example.springframework.mutiImplements;

public class TPayStrategy implements PayStrategy {
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
        return "TPay";
    }
}
