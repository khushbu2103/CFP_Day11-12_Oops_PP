package Day11_12_Oop_PP;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class Account {
    private double balance;
    public Account(double currentBalance) {
        if (currentBalance > 0.0) {
            balance = currentBalance;
        }
    }
    public void Debit()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount you want to debit");
        double debitAmount = sc.nextInt();
        if(debitAmount > balance)
        {
            System.out.println("Insufficient balance");
        }
        else
        {
            balance = balance - debitAmount;
        }
    }

    public static void main(String[] args) {
        Account account = new Account(500);
        account.Debit();
        System.out.println("Account balance after debit amount: " + account.balance);

    }
}

