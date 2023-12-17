package Day11_12_Oop_PP;

import java.util.ArrayList;
import java.util.Scanner;

public class Stock {
    String stockName;
    int numberOfShares;
    double sharePrice;

    public Stock(String stockName, int numberOfShares, double sharePrice) {
        this.stockName = stockName;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }
    public double calculateStockValue() {
        return numberOfShares * sharePrice;
    }
}
class StockPortfolio
{
    ArrayList<Stock> stocks = new ArrayList<>();

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    double calculateTotalPortfolioValue() {
        double totalValue = 0;
        for (Stock stock : stocks) {
            totalValue += stock.calculateStockValue();
        }
        return totalValue;
    }
    void printStockReport() {
        System.out.println("Stock Report:");
        System.out.println("------------------------------------------------------");
        System.out.printf("%-15s %-20s %-15s %-15s%n", "Stock Name", "Number of Shares", "Share Price", "Stock Value");
        System.out.println("------------------------------------------------------");
        for (Stock stock : stocks) {
            System.out.printf("%-15s %-20d %-15.2f %-15.2f%n",
                    stock.stockName, stock.numberOfShares, stock.sharePrice, stock.calculateStockValue());
        }
        System.out.println("------------------------------------------------------");
        System.out.printf("%-50s %-15.2f%n", "Total Portfolio Value", calculateTotalPortfolioValue());
        System.out.println("------------------------------------------------------");
    }
}
class StockAccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPortfolio portfolio = new StockPortfolio();

        System.out.print("Enter the number of stocks: ");
        int numStocks = scanner.nextInt();

        for (int i = 0; i < numStocks; i++) {
            System.out.println("\nEnter details for Stock #" + (i + 1));
            System.out.print("Stock Name: ");
            String stockName = scanner.next();
            System.out.print("Number of Shares: ");
            int numberOfShares = scanner.nextInt();
            System.out.print("Share Price: ");
            double sharePrice = scanner.nextDouble();

            Stock stock = new Stock(stockName, numberOfShares, sharePrice);
            portfolio.addStock(stock);
        }

        portfolio.printStockReport();
    }
}
