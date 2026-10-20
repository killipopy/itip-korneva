package edu.course.lab02;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test

    void  withdrawDecreasesBalance(){
        BankAccount account = new BankAccount(100);
        account.withdraw(30);
        assertEquals(70, account.getBalance());
    }

    @Test

    void withdrawMoreThanBalanceThrows() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(130));
        assertEquals(100, account.getBalance());
    }

    @Test

    void negativeInitialBalanceThrows() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-1));
    }

    @Test

    void depositIncreasesBalance() {
        BankAccount account = new BankAccount(100);
        account.deposit(130);
        assertEquals(230, account.getBalance());
    }

    @Test

    void nonPositiveDepositThrows() {
        BankAccount account = new BankAccount(10);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-5));
    }

    @Test

    void nonPositiveWithdrawThrows() {
        BankAccount account = new BankAccount(10);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-5));
    }
}
