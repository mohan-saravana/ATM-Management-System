package com.atm.main;

import java.util.List;
import java.util.Scanner;

import com.atm.model.Atmaccount;
import com.atm.model.Atmtransaction;
import com.atm.model.Atmuser;
import com.atm.service.Atmaccservice;
import com.atm.service.Atmtracnservice;
import com.atm.service.AtmService;
import com.atm.serviceimpl.Atmaccserviceimpl;
import com.atm.serviceimpl.Atmtracnserviceimpl;
import com.atm.serviceimpl.Atmserviceimpl;

public class Atmmainapplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Atmserviceimpl userService =
                new Atmserviceimpl();

        Atmaccserviceimpl accountService =
                new Atmaccserviceimpl();

        Atmtracnserviceimpl transactionService =
                new Atmtracnserviceimpl();

        System.out.println("================================");
        System.out.println("       ATM MANAGEMENT SYSTEM");
        System.out.println("================================");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        Atmuser user =
                userService.login(username, pin);

        if (user == null) {

            System.out.println(
                    "Invalid username or PIN.");

            sc.close();
            return;
        }

        System.out.println();
        System.out.println("Login Successful!");
        System.out.println(
                "Welcome " + user.getFullName());

        Atmaccount account =
                accountService.getAccountByUserId(
                        user.getUserId());

        if (account == null) {

            System.out.println(
                    "Account not found.");

            sc.close();
            return;
        }

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("========== ATM MENU ==========");
            System.out.println("1. Balance Enquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Money");
            System.out.println("5. Mini Statement");
            System.out.println("6. Change PIN");
            System.out.println("7. Logout");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    account =
                            accountService
                            .getAccountByUserId(
                                    user.getUserId());

                    System.out.println(
                            "Account Number: "
                            + account.getAccountNumber());

                    System.out.println(
                            "Current Balance: ₹"
                            + account.getBalance());

                    break;

                case 2:

                    System.out.print(
                            "Enter deposit amount: ");

                    double depositAmount =
                            sc.nextDouble();

                    if (accountService.deposit(
                            account.getAccountId(),
                            depositAmount)) {

                        transactionService
                        .addTransaction(
                            new Atmtransaction(
                                0,
                                account.getAccountId(),
                                "DEPOSIT",
                                depositAmount,
                                null
                            )
                        );

                        System.out.println(
                                "Amount deposited successfully.");

                    } else {

                        System.out.println(
                                "Deposit failed.");
                    }

                    break;

                case 3:

                    System.out.print(
                            "Enter withdrawal amount: ");

                    double withdrawAmount =
                            sc.nextDouble();

                    if (accountService.withdraw(
                            account.getAccountId(),
                            withdrawAmount)) {

                        transactionService
                        .addTransaction(
                            new Atmtransaction(
                                0,
                                account.getAccountId(),
                                "WITHDRAW",
                                withdrawAmount,
                                null
                            )
                        );

                        System.out.println(
                                "Please collect your cash.");

                    } else {

                        System.out.println(
                                "Withdrawal failed.");
                        System.out.println(
                                "Insufficient balance or invalid amount.");
                    }

                    break;

                case 4:

                    System.out.print(
                            "Enter receiver account ID: ");

                    int receiverAccountId =
                            sc.nextInt();

                    System.out.print(
                            "Enter transfer amount: ");

                    double transferAmount =
                            sc.nextDouble();

                    if (accountService.transfer(
                            account.getAccountId(),
                            receiverAccountId,
                            transferAmount)) {

                        transactionService
                        .addTransaction(
                            new Atmtransaction(
                                0,
                                account.getAccountId(),
                                "TRANSFER",
                                transferAmount,
                                null
                            )
                        );

                        System.out.println(
                                "Money transferred successfully.");

                    } else {

                        System.out.println(
                                "Transfer failed.");
                    }

                    break;

                case 5:

                    List<Atmtransaction> transactions =
                            transactionService
                            .getTransactions(
                                    account.getAccountId());

                    System.out.println();
                    System.out.println(
                            "========= MINI STATEMENT =========");

                    if (transactions.isEmpty()) {

                        System.out.println(
                                "No transactions found.");

                    } else {

                        for (Atmtransaction t :
                                transactions) {

                            System.out.println(
                                    t.getTransactionType()
                                    + " | ₹"
                                    + t.getAmount()
                                    + " | "
                                    + t.getTransactionDate());
                        }
                    }

                    break;

                case 6:

                    System.out.print(
                            "Enter new PIN: ");

                    String newPin =
                            sc.next();

                    if (newPin.matches("\\d{4}")) {

                        if (userService.changePin(
                                user.getUserId(),
                                newPin)) {

                            System.out.println(
                                    "PIN changed successfully.");

                        } else {

                            System.out.println(
                                    "PIN change failed.");
                        }

                    } else {

                        System.out.println(
                                "PIN must contain exactly 4 digits.");
                    }

                    break;

                case 7:

                    running = false;

                    System.out.println(
                            "Thank you for using ATM.");

                    break;

                default:

                    System.out.println(
                            "Invalid choice.");
            }
        }

        sc.close();
    }
}