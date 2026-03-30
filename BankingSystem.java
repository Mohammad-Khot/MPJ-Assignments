import java.io.*;
import java.util.*;

class InvalidAmountException extends Exception {
    public InvalidAmountException(String msg) {
        super(msg);
    }
}

class InvalidCIDException extends Exception {
    public InvalidCIDException(String msg) {
        super(msg);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class Customer {
    int cid;
    String cname;
    double amount;

    Customer(int cid, String cname, double amount) {
        this.cid = cid;
        this.cname = cname;
        this.amount = amount;
    }

    public String toString() {
        return cid + " " + cname + " " + amount;
    }
}

public class BankingSystem {

    static final String FILE_NAME = "customers.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        createAccount(sc);
                        break;
                    case 2:
                        withdraw(sc);
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void createAccount(Scanner sc) throws Exception {
        System.out.print("Enter CID (1-20): ");
        int cid = sc.nextInt();

        if (cid < 1 || cid > 20)
            throw new InvalidCIDException("CID must be between 1 and 20");

        System.out.print("Enter Name: ");
        String cname = sc.next();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        if (amount < 0)
            throw new InvalidAmountException("Amount must be positive");

        if (amount < 1000)
            throw new InvalidAmountException("Minimum balance is Rs. 1000");

        Customer c = new Customer(cid, cname, amount);

        FileWriter fw = new FileWriter(FILE_NAME, true);
        fw.write(c.toString() + "\n");
        fw.close();

        System.out.println("Account Created Successfully!");
    }

    static void withdraw(Scanner sc) throws Exception {
        System.out.print("Enter CID: ");
        int cid = sc.nextInt();

        System.out.print("Enter withdrawal amount: ");
        double wth = sc.nextDouble();

        if (wth < 0)
            throw new InvalidAmountException("Withdrawal must be positive");

        File file = new File(FILE_NAME);
        Scanner fileReader = new Scanner(file);

        List<Customer> list = new ArrayList<>();
        boolean found = false;

        while (fileReader.hasNext()) {
            int id = fileReader.nextInt();
            String name = fileReader.next();
            double amt = fileReader.nextDouble();

            if (id == cid) {
                found = true;
                if (wth > amt)
                    throw new InsufficientBalanceException("Insufficient balance");

                amt -= wth;
                System.out.println("Withdrawal successful. Remaining balance: " + amt);
            }

            list.add(new Customer(id, name, amt));
        }

        fileReader.close();

        if (!found) {
            System.out.println("Customer not found");
            return;
        }

        FileWriter fw = new FileWriter(FILE_NAME);
        for (Customer c : list) {
            fw.write(c.toString() + "\n");
        }
        fw.close();
    }
}
