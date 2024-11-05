package org.server.strategydesign;

public class StrategyContext {
    //Stratgylerin başlatılacağı sınıf

    private Strategy commandStrategy ;

    public StrategyContext(Strategy commandStrategy) {
        this.commandStrategy=commandStrategy;
    }
    public void executeStrategy() {
        if (commandStrategy != null) {
            commandStrategy.execute();
        } else {
            System.out.println("Herhangi bir strategy bulunamadı ");
        }
    }
}
