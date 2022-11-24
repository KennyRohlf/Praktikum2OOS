package bank.exceptions;

public class TransactionAlreadyExistException extends Exception{
    TransactionAlreadyExistException(String ausgabe){super(ausgabe);}
}
