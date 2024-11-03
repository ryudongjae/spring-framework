package com.example.springframework.mutiImplements;

public interface PayStrategy {
    void setData(Pay pay);
    void pay();
    void cancel();
    String type();
}
