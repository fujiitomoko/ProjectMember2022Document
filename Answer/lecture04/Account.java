package lecture04;

public class Account {
    private String number;
    private String name;
    private long balance;

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Account(String name, String number) {
        this.name = name;
        this.number = number;
        this.balance = 0;
    }
}
