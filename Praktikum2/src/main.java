import bank.*;
import bank.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args){

        PrivateBank Bank1 = new PrivateBank("Bank", 0.00, 0.00);

        try{
            Payment P1 = new Payment("2.8.2000", 1000, "Geld1", 0.01, 0.01);
            Payment P2 = new Payment("3.8.2000", -2000, "Geld2", 0.02, 0.02);
            Payment P3 = new Payment("4.8.2000", 3000, "Geld3", 0.03, 0.03);
            Payment P4 = new Payment("5.8.2000", -4000, "Geld4", 0.04, 0.04);
            Payment P5 = new Payment("6.8.2000", 5000, "Geld5", 0.05, 0.05);
            Payment P6 = new Payment("7.8.2000", -6000, "Geld6", 0.06, 0.06);
            IncomingTransfer T1 = new IncomingTransfer("2.8.2000" , 2500,"Geld7","Konto1","konto2");
            OutgoingTransfer T2 = new OutgoingTransfer("2.8.2000" , 2500,"Geld8","Konto2","konto1");

            PrivateBankAlt Bank2 = new PrivateBankAlt("Bank", 0.00, 0.00);
            try {
                Bank2.createAccount("Konto1");
            } catch (AccountAlreadyExistsException e) {
                throw new RuntimeException(e);
            }

            try{
                Bank2.addTransaction("Konto1",P1);
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
                Bank2.addTransaction("Konto1",P2);
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
                Bank2.addTransaction("Konto1",P3);
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
            //
            System.out.println(Bank2.getAccountBalance("Konto1"));

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

            try{
                Bank1.addTransaction("Konto1",P3);
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

            //System.out.println(Bank1);
            System.out.println("Konto1 Guthaben: " + Bank1.getAccountBalance("Konto1") + "€" + "\n" );
            /*
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

            System.out.println("Konto1 Guthaben: " + Bank1.getAccountBalance("Konto1") + "€");

            System.out.println(Bank1.containsTransaction("Konto1", P1));
            System.out.println(Bank1.containsTransaction("Konto1", P2));

            try{
                Bank1.addTransaction("Konto1",P3);
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
                Bank1.addTransaction("Konto1",P6);
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
                Bank1.addTransaction("Konto1",P4);
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
                Bank1.addTransaction("Konto1",P5);
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

            System.out.println(Bank1.getTransactions("Konto1"));

            System.out.println(Bank1.getTransactionsSorted("Konto1",true));

            System.out.println(Bank1.getTransactionsByType("Konto1", false));

            System.out.println(Bank1.getAccountBalance("Konto1"));

            try{
                Bank1.addTransaction("Konto1",T1);
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

            System.out.println(Bank1.getAccountBalance("Konto1"));

            try{
                Bank1.addTransaction("Konto1",T2);
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

            System.out.println(Bank1.getAccountBalance("Konto1"));


            PrivateBankAlt Bank2 = new PrivateBankAlt("Bank2",0.01,0.01);
            */
        }
        catch(AttributeException e){
            throw new RuntimeException(e);
        }
    }
}