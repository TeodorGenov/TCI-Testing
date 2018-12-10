public class Money {
    private final int Amount;
    private final String Currency;

    public Money(int amount, String currency)
    {
        this.Amount = amount;
        this.Currency = currency;
    }

    public int getAmount(){
        return Amount;
    }

    public String getCurrency()
    {
        return Currency;
    }
}