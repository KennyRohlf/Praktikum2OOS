package bank.exceptions;

public class AccountAlreadyExistsException extends Exception{
    AccountAlreadyExistsException(String ausgabe){ super(ausgabe); }
}
