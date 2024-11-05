package org.server.strategydesign;

import java.util.HashMap;
import java.util.Map;

public class StrategySelector {
    //Kullanıcıdan alınan keyworde göre strategyleri belirlemek için oluşturulmuş bir sınıftır
    //Strategyler map içerisinde tutulmaktadır.

    private Map<String , Strategy> strategyMap = new HashMap<>();

    public StrategySelector(){
        strategyMap.put("AUTH",new AuthStrategy());
        strategyMap.put("REGISTER" , new RegisterStrategy());
        strategyMap.put("LIST" , new ListStrategy());
        strategyMap.put("SEND",new SendStrategy());
        strategyMap.put("READ",new ReadStrategy());

    }

    public void  addStrategyMap(String keyword , Strategy strategy){
        strategyMap.put(keyword , strategy);
    }

    public Strategy getStrategy(String keyword){
        return strategyMap.getOrDefault(keyword,null);
    }
}
