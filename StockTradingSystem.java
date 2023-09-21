package lab112023;

import java.util.ArrayList;
import java.util.List;

public class StockTradingSystem {
    // Предположим, что у нас есть список для хранения сделок
    private List<Deal> deals = new ArrayList<>();

    public static void main(String[] args) {
        StockTradingSystem system = new StockTradingSystem();
        system.demoOperations();
    }

    public void demoOperations() {
        // Анонимный класс для демонстрации добавления сделки
        Runnable addDealOperation = new Runnable() {
            @Override
            public void run() {
                Deal deal = new Deal();
                deal.ID = 1;
                deal.Tiker = "AAPL";
                deal.Order = 12345;
                deal.Number = 54321;
                deal.Quantity = 100;
                deal.Price = 150.50;
                deal.TotalCost = deal.Quantity * deal.Price;
                deal.Trader = "Михаил";
                deal.Commission = 0.02 * deal.TotalCost;

                deals.add(deal);
                System.out.println("Добавлена новая сделка: " + deal.Tiker);
            }
        };

        // Анонимный класс для демонстрации вывода информации о сделке
        Runnable displayDealOperation = new Runnable() {
            @Override
            public void run() {
                if (deals.isEmpty()) {
                    System.out.println("Сделок нет.");
                    return;
                }

                Deal deal = deals.get(0); // получаем первую сделку для демонстрации
                System.out.println("Информация о сделке:");
                System.out.println("ID: " + deal.ID);
                System.out.println("Ticker: " + deal.Tiker);
                System.out.println("Order: " + deal.Order);
                System.out.println("Number: " + deal.Number);
                System.out.println("Quantity: " + deal.Quantity);
                System.out.println("Price: $" + deal.Price);
                System.out.println("Total Cost: $" + deal.TotalCost);
                System.out.println("Trader: " + deal.Trader);
                System.out.println("Commission: $" + deal.Commission);
            }
        };

        // Демонстрация операций
        addDealOperation.run();
        displayDealOperation.run();
    }
}