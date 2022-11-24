package bank;

import bank.exceptions.AccountAlreadyExistsException;

import java.util.HashMap;
import java.util.*;

public class PrivateBank implements Bank {
    private String name;
    private double incomingInterest;
    private double outGoingInterest;
    private Map<String, List<Transaction>> accountsToTransaction = new HashMap<>();

    public String getName() { return name;}
    public double getIncomingInterest() { return incomingInterest;}
    public double getOutGoingInterest() { return outGoingInterest;}

    public void setName(String name) {this.name = name;}
    public void setIncomingInterest(double x){
        if(x >= 0 && x <= 1){
            incomingInterest = x;
        }
        else{
            System.out.println("Fehler: Es muss ein Wert zwischen 0 - 1 getroffen werden! Wert auf 0 gesetzt");
            this.setIncomingInterest(0);
        }
    }
    public void setOutGoingInterest(double x){
        if(x >= 0 && x <= 1){
            outGoingInterest = x;
        }
        else{
            System.out.println("Fehler: Es muss ein Wert zwischen 0 - 1 getroffen werden! Wert wurde auf 0 gesetzt");
            this.setOutGoingInterest(0);
        }
    }

    PrivateBank(String name, double incomingInterest, double outGoingInterest){
        this.setName(name);
        this.setIncomingInterest(incomingInterest);
        this.setOutGoingInterest(outGoingInterest);
    }
    public PrivateBank(PrivateBank copy){
        this(copy.getName(),copy.getIncomingInterest(),copy.getOutGoingInterest());
        this.accountsToTransaction = copy.accountsToTransaction;
    }

    @Override
    public String toString() {
        return "PrivateBank{" +
                "name='" + name + '\'' +
                ", incomingInterest=" + incomingInterest +
                ", outGoingInterest=" + outGoingInterest +
                ", accountsToTransaction=" + accountsToTransaction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivateBank that = (PrivateBank) o;
        return Double.compare(that.incomingInterest, incomingInterest) == 0 && Double.compare(that.outGoingInterest, outGoingInterest) == 0 && Objects.equals(name, that.name) && Objects.equals(accountsToTransaction, that.accountsToTransaction);
    }

    boolean containsTransaction(String account, Transaction transaction){

    }

    double getAccountBalance(String account){

    }

    List<Transaction> getTransactions(String account){

    }

    List<Transaction> getTransactionsByType(String account, boolean positive){

    }



}
