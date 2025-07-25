public class Account {
    private final String name;
    private final int age;
    private final String accountNumber;
    private double balance;
    private double credit;
    private final double originalCredit;

    public Account(String name, int age, String accountNumber, double balance, double credit) {
        this.name = name;
        this.age = age;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.credit = credit;
        this.originalCredit = credit;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getCredit() {
        return credit;
    }

    public double getOriginalCredit() {
        return originalCredit;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

}
