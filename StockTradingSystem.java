package lab112023;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StockTradingSystem {
    // Предположим, что у нас есть список для хранения сделок
    private List<Deal> deals = new ArrayList<>();

    public static void main(String[] args) {
        StockTradingSystem system = new StockTradingSystem();
        system.demoOperations();
        
        Deal[] deals = {
                new Deal() {{ ID = 1; TypeID = 1; PlaceID = 1; CurrencyID = 1; Tiker = "AAPL"; Order = 001; Number = 001; Quantity = 120; Price = 130.5; TotalCost = 15660; Trader = "T001"; Commission = 15.6; }},
                new Deal() {{ ID = 2; TypeID = 2; PlaceID = 2; CurrencyID = 2; Tiker = "GOOGL"; Order = 002; Number = 002; Quantity = 85; Price = 2400.5; TotalCost = 204040; Trader = "T002"; Commission = 204.04; }},
                new Deal() {{ ID = 3; TypeID = 1; PlaceID = 3; CurrencyID = 1; Tiker = "MSFT"; Order = 003; Number = 003; Quantity = 50; Price = 210.0; TotalCost = 10500; Trader = "T001"; Commission = 10.5; }}
            };

            // Фильтруем сделки, где количество ценных бумаг больше 80
            Predicate<Deal> filter = deal -> deal.Quantity > 80;

            for (Deal deal : deals) {
                if (filter.test(deal)) {
                    // Обработка сделки, которая соответствует условию
                    System.out.println("Подходят под условия сделка под номером:" + deal.Number);
                }
            }
        
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