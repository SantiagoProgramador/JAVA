public class BankAccount {

    //Attributes
    private String owner;
    private double balance;

    //Constructors
    public  BankAccount(){}
    public  BankAccount(String owner, double balance){
        this.balance = balance;
        this.owner = owner;
    }
    // Methods
    public void increaseBalance(double scanner){
        double addMoney = scanner;
        if (addMoney <= 0 ) {
            System.out.println("Please type a valid number.");
            return;
        }
        this.balance += addMoney;
        System.out.println("Your new balance its now: " + balance);
    }
    public void decreaseBalance(double scanner){
        double reduceMoney = scanner;
        if (reduceMoney <= 0) {
            System.out.println("Please type a valid ammount.");
        }
        if (this.balance < reduceMoney) {
            System.out.println("You dont have enough money in your account.");
            return;
        }
        this.balance -= reduceMoney;
        System.out.println("Your new balance its now: " + balance);

    }
    // Setters and getters

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    // Object to String
    @Override
    public String toString() {
        return "bankAccount{" +
                "owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}
