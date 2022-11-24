
package bank;

import java.util.Objects;

abstract class Transaction implements CalculateBill{
    /**
     * Private Attribute
     */
    protected String date;
    protected String description;
    protected double amount;

    /**
     * Getter Methoden
     * @return // Der Wert des Objektes wird zurückgegeben.
     */

    public String getDate(){return date;}
    public String getDescription(){return description;}
    public double getAmount(){return amount;}

    /**
     * Setter Methoden.
     * @param x  // Es wird der passende Parameter x immer übergeben
     */
    public void setDate(String x){date = x;}
    public void setDescription(String x){description = x;}
    public void setAmount(double x){amount = x;}

    /**
     * Es handelt sich hierbei um den Konstruktor der Abstrakten Klasse Transaction
     * welcher für die beiden Unterklassen Payment und Transfer benutzt wird.
     * @param date // wird in das Attribut date überführt des Objektes.
     * @param description // wird in das Attribut description überführt des Objektes.
     */
    Transaction(String date, String description, double amount){
        this.setDate(date);
        this.setDescription(description);
        this.setAmount(amount);
    }

    /**
     * Überschreibe die toString Methode von der Superklasse, sodass das komplette Objekt ausgegeben wird.
     */
    @Override
    public String toString(){
        return "Date: " + this.getDate() + "\n" + "Description: "
                + this.getDescription() + "\n" + "Amount" + calculate();
    }

/*
    @Override
    public boolean equals(Object other){
        if (other instanceof Transaction equals){
            return (this.date == equals.date && this.amount == equals.amount && this.description == equals.description);
        }
        else{
            return false;
        }
    }

 */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(date, that.date) && Objects.equals(description, that.description);
    }
}