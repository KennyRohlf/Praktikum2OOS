package bank.exceptions;

public class AccountDoesNotExistException extends Exception{
    AccountDoesNotExistException(String ausgabe){super(ausgabe);}
}
