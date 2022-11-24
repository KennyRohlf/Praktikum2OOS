package bank.exceptions;

public class TransactionDoesNotExistException extends Exception{
    TransactionDoesNotExistException(String ausgabe){super(ausgabe);}
}
