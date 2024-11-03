package com.example.springframework.mutiImplements.config;

import com.example.springframework.mutiImplements.Pay;
import com.example.springframework.mutiImplements.PayStrategy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class PayServiceConfig {

    private final Map<String, PayStrategy> stringPayStrategyMap = new HashMap<>();

    public PayServiceConfig(List<PayStrategy> stringPayStrategyMap) {

        if (isEmpty(stringPayStrategyMap)) {
            throw new IllegalArgumentException("존재하는 managerProcesses 가 없음");
        }
        for (PayStrategy managerService : stringPayStrategyMap) {
            this.stringPayStrategyMap.put(managerService.type(), managerService);
        }
    }

    public void getInstance(String type, Pay pay) {
        PayStrategy payStrategy = stringPayStrategyMap.get(type);
        payStrategy.setData(pay);
    }
}
