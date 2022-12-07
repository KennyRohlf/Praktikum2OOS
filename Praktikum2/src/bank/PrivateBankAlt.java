package bank;

import bank.exceptions.*;

import java.util.HashMap;
import java.util.*;

public class PrivateBankAlt implements Bank {
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

    public PrivateBankAlt(String name, double incomingInterest, double outGoingInterest){
        this.setName(name);
        this.setIncomingInterest(incomingInterest);
        this.setOutGoingInterest(outGoingInterest);
    }
    public PrivateBankAlt(PrivateBank copy){
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
        return Double.compare(that.getIncomingInterest(), incomingInterest) == 0 && Double.compare(that.getOutGoingInterest(), outGoingInterest) == 0 && Objects.equals(name, that.getName()) && Objects.equals(accountsToTransaction, that.accountsToTransaction);
    }

    /**
     * Adds an account to the bank.
     *
     * @param account the account to be added
     * @throws AccountAlreadyExistsException if the account already exists
     */
    public void createAccount(String account) throws AccountAlreadyExistsException{
        if(accountsToTransaction.containsKey(account)){
            throw new AccountAlreadyExistsException("Account existiert bereits!" +  "\n");
        }
        else{
            List<Transaction> newList = new ArrayList<>();
            accountsToTransaction.put(account,newList);
            System.out.println("Account " +  account + " wurde erfolgreich erstellt!" +  "\n");
        }
    }

    /**
     * Adds an account (with specified transactions) to the bank.
     * Important: duplicate transactions must not be added to the account!
     *
     * @param account      the account to be added
     * @param transactions a list of already existing transactions which should be added to the newly created account
     * @throws AccountAlreadyExistsException    if the account already exists
     * @throws TransactionAlreadyExistException if the transaction already exists
     * @throws TransactionAttributeException    if the validation check for certain attributes fail
     */
    //Es wird ein Account mit einer Liste von Transaktionen.
    public void createAccount(String account, List<Transaction> transactions) throws AccountAlreadyExistsException, TransactionAlreadyExistException, TransactionAttributeException{
        if(accountsToTransaction.containsKey(account)){
            throw new AccountAlreadyExistsException("Account existiert bereits!" +  "\n");
        }
        else if (accountsToTransaction.containsValue(transactions)){
            throw new TransactionAlreadyExistException("Die Transaktion existiert bereits!" +  "\n");
        }
        else if(accountsToTransaction.isEmpty()){
            throw new TransactionAttributeException("Fehler oder fehlende Attribute!" +  "\n");
        }
        else{
            //createAccount(account, transactions); (weiß nicht, ob es in den oberen springt)
            List<Transaction> newList = new ArrayList<>();
            accountsToTransaction.put(account, newList);
            System.out.println("Account " +  account + " wurde erfolgreich erstellt!" +  "\n");
        }
    }

    /**
     * Adds a transaction to an already existing account.
     *
     * @param account     the account to which the transaction is added
     * @param transaction the transaction which should be added to the specified account
     * @throws TransactionAlreadyExistException if the transaction already exists
     * @throws AccountDoesNotExistException     if the specified account does not exist
     * @throws TransactionAttributeException    if the validation check for certain attributes fail
     */
    public void addTransaction(String account, Transaction transaction) throws TransactionAlreadyExistException, AccountDoesNotExistException, TransactionAttributeException{
        if(!accountsToTransaction.containsKey(account)){
            throw new AccountDoesNotExistException("Account konnte nicht gefunden werden!" +  "\n");
        }
        else if(accountsToTransaction.get(account).contains(transaction)){
            throw new TransactionAlreadyExistException("Die Transaktionen existiert bereits!" +  "\n");
        }
        else if(accountsToTransaction.isEmpty()){
            throw new TransactionAttributeException("Mit den Attributen ist ein Fehler aufgetreten!" +  "\n");
        }
        else{
            if(transaction instanceof Payment payment){
                try{
                    payment.setIncomingInterest(PrivateBankAlt.this.getIncomingInterest());
                    payment.setOutGoingInterest(PrivateBankAlt.this.getOutGoingInterest());
                    accountsToTransaction.get(account).add(transaction);
                }
                catch(AttributeException e){
                    throw new RuntimeException(e);
                }
            }
            else if(transaction instanceof Transfer transfer){
                if(transfer.getSender() == this.getName()){
                    transfer.setAmount(-(transfer.getAmount()));
                    accountsToTransaction.get(account).add(transfer);
                }
                else{
                    accountsToTransaction.get(account).add(transfer);
                }
            }
        }
    }

    /**
     * Removes a transaction from an account. If the transaction does not exist, an exception is
     * thrown.
     *
     * @param account     the account from which the transaction is removed
     * @param transaction the transaction which is removed from the specified account
     * @throws AccountDoesNotExistException     if the specified account does not exist
     * @throws TransactionDoesNotExistException if the transaction cannot be found
     */
    public void removeTransaction(String account, Transaction transaction) throws AccountDoesNotExistException, TransactionDoesNotExistException{

        if(accountsToTransaction.isEmpty()){
            throw new AccountDoesNotExistException("Account existiert nicht!" +  "\n");
        }
        else if(!accountsToTransaction.get(account).contains(transaction)){
            throw new TransactionDoesNotExistException("Die Transaktion ist nicht vorhanden!" +  "\n");
        }
        else{
            accountsToTransaction.get(account).remove(transaction);
            System.out.println("Dem Account " + account + "Wurde die Transaktion " + transaction.getAmount() + "€ erfolgreich entfernt!");
        }
    }

    /**
     * Checks whether the specified transaction for a given account exists.
     *
     * @param account     the account from which the transaction is checked
     * @param transaction the transaction to search/look for
     */
    public boolean containsTransaction(String account, Transaction transaction){

        return (accountsToTransaction.containsKey(account) && accountsToTransaction.containsValue(transaction));
    }

    /**
     * Calculates and returns the current account balance.
     *
     * @param account the selected account
     * @return the current account balance
     */
    public double getAccountBalance(String account) {

        double balance = 0;
        List<Transaction> list = accountsToTransaction.get(account);

        for (Transaction transaction : list) {
            if (transaction instanceof Transfer transfer && transfer.getSender().equals(account)) {
                balance -= transaction.calculate();
            } else {
                balance += transaction.calculate();
            }
        }
        return balance;
    }
    /**
     * Returns a list of transactions for an account.
     *
     * @param account the selected account
     * @return the list of all transactions for the specified account
     */
    public List<Transaction> getTransactions(String account){
        return accountsToTransaction.get(account);
    }

    /**
     * Returns a sorted list (-> calculated amounts) of transactions for a specific account. Sorts the list either in ascending or descending order
     * (or empty).
     *
     * @param account the selected account
     * @param asc     selects if the transaction list is sorted in ascending or descending order
     * @return the sorted list of all transactions for the specified account
     */
    public List<Transaction> getTransactionsSorted(String account, boolean asc){

        List<Transaction> sortiert = accountsToTransaction.get(account);
        if(asc){
            sortiert.sort(Comparator.comparing(Transaction::getAmount));
        }
        else{
            sortiert.sort(Comparator.comparing(Transaction::getAmount).reversed());
        }
        return sortiert;
    }

    /**
     * Returns a list of either positive or negative transactions (-> calculated amounts).
     *
     * @param account  the selected account
     * @param positive selects if positive or negative transactions are listed
     * @return the list of all transactions by type
     */
    public List<Transaction> getTransactionsByType(String account, boolean positive){
        List<Transaction> Liste = accountsToTransaction.get(account);
        List<Transaction> newList = new ArrayList<>();

        if(positive){
            for (Transaction transaction : Liste) {
                if (transaction.getAmount() >= 0) {
                    newList.add(transaction);
                }
            }
        }
        else{
            for (Transaction transaction : Liste) {
                if (transaction.getAmount() < 0) {
                    newList.add(transaction);
                }
            }
        }
        return newList;
    }
}
