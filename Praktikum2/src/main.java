import bank.PrivateBank;
import bank.Transfer;
import bank.Payment;
import bank.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        PrivateBank Bank1 = new PrivateBank("Bank", 0.05, 0.05);
        Transfer T1 = new Transfer("2.8.2000", 1000, "Geld1");
        Transfer T2 = new Transfer("3.8.2000", 2000, "Geld2");
        Transfer T3 = new Transfer("4.8.2000", 3000, "Geld3");

        Payment P1 = new Payment("2.8.2000", 1000, "Geld1", 0.05, 0.05);
        Payment P2 = new Payment("3.8.2000", 2000, "Geld2", 0.05, 0.05);
        Payment P3 = new Payment("4.8.2000", 3000, "Geld3", 0.05, 0.05);

        try {
            Bank1.createAccount("Konto1");
        } catch (AccountAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Bank1 + "\n");

        try{
            Bank1.addTransaction("Konto1",P1);
        }
        catch(TransactionAlreadyExistException e){
            throw new RuntimeException(e);
        }
        catch(AccountDoesNotExistException e){
            throw new RuntimeException(e);
        }
        catch(TransactionAttributeException e){
            throw new RuntimeException(e);
        }
        try{
            Bank1.addTransaction("Konto1",P2);
        }
        catch(TransactionAlreadyExistException e){
            throw new RuntimeException(e);
        }
        catch(AccountDoesNotExistException e){
            throw new RuntimeException(e);
        }
        catch(TransactionAttributeException e){
            throw new RuntimeException(e);
        }

        System.out.println(Bank1);
        System.out.println("Konto1 Guthaben: " + Bank1.getAccountBalance("Konto1") + "€" + "\n" );

        try{
            Bank1.removeTransaction("Konto1",P1);
        }
        catch(AccountDoesNotExistException e){
            throw new RuntimeException(e);
        }
        catch(TransactionDoesNotExistException e){
            throw new RuntimeException(e);
        }
        System.out.println(Bank1 + "\n");

        //Fehler!
        System.out.println(Bank1.containsTransaction("Konto1", P1));
        System.out.println(Bank1.containsTransaction("Konto1", P2));

        System.out.println("Konto1 Guthaben: " + Bank1.getAccountBalance("Konto1") + "€");

        System.out.println(Bank1.getTransactions("Konto1"));


        PrivateBank Bank2 = new PrivateBank("Bank2",0.05,0.05);

        try{
            Bank2.createAccount("Konto2",List.of(
                    new Payment("2.8.2000", 1000, "P1", 0.01, 0.01),
                    new Payment("3.8.2000", 2000, "P2"),
                    new Transfer("4.8.2000",3000,"T1")
            ));
        }
        catch(AccountAlreadyExistsException e){
            throw new RuntimeException(e);
        }
        catch(TransactionAlreadyExistException e){
            throw new RuntimeException(e);
        }
        catch(TransactionAttributeException e){
            throw new RuntimeException(e);
        }

    }
}

