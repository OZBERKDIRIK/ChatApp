package org.server.strategydesign;

public class StrategyContext {
    //Stratgylerin başlatılacağı sınıf

    private Strategy commandStrategy ;

    public StrategyContext(Strategy commandStrategy) {
        this.commandStrategy=commandStrategy;
    }
    public void executeStrategy(String content1 , String content2) {
        if (commandStrategy != null) {
            commandStrategy.execute(content1,content2);
        } else {
            System.out.println("Herhangi bir strategy bulunamadı ");
        }
    }
}
