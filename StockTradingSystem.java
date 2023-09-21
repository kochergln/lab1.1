package lab112023;

public class StockTradingSystem {

    public static void main(String[] args) {
        StockTradingSystem system = new StockTradingSystem();
        system.executeDeals();
    }

    public void executeDeals() {
        // Анонимный класс для сделки покупки
        Deal buyDeal = new Deal() {
            @Override
            public void execute() {
                System.out.println("Заключаю сделку по покупке...");
            }

            @Override
            public String getDealType() {
                return "Покупка";
            }

            @Override
            public double getAmount() {
                return 1000.50; // примерное значение
            }
        };

        // Анонимный класс для сделки продажи
        Deal sellDeal = new Deal() {
            @Override
            public void execute() {
                System.out.println("Заключаю сделку по продаже...");
            }

            @Override
            public String getDealType() {
                return "Продажа";
            }

            @Override
            public double getAmount() {
                return 500.25; // примерное значение
            }
        };

        // Выполнение сделок
        executeDeal(buyDeal);
        executeDeal(sellDeal);
    }

    private void executeDeal(Deal deal) {
        System.out.println("Тип сделки: " + deal.getDealType());
        System.out.println("Цена: $" + deal.getAmount());
        deal.execute();
        System.out.println("------------------------------");
    }
}