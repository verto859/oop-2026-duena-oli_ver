# Single Responsibility Principle

## BAD

```java
import java.time.LocalDateTime;

public class Main {
  public static void main(String[] args) {
    Transaction t1 = new Transaction(1, "000012345", 1000, TransactionType.DEBIT, "2001");
    t1.print();
  }
}

enum TransactionType {
  DEBIT,
  CREDIT,
}

class Transaction {
  private long id;
  private String account;
  private double amount;
  private LocalDateTime timestamp;
  private TransactionType type;
  private String tellerId;

  public Transaction(long id, String account, double amount, TransactionType type, String tellerId) {
    this.id = id;
    this.account = account;
    this.amount = amount;
    this.type = type;
    this.tellerId = tellerId;
    this.timestamp = LocalDateTime.now();
  }

  public long getId() {
    return id;
  }

  public String getAccount() {
    return account;
  }

  public double getAmount() {
    return amount;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public TransactionType getType() {
    return type;
  }

  public String getTellerId() {
    return tellerId;
  }

  public void print() {
    System.out.println("Transaction #" + String.valueOf(id));
    System.out.println("Account #" + account);
    System.out.println("Type: " + type.toString());
    System.out.println("Amount: " + String.valueOf(amount));
    System.out.println("Transaction Date: " + String.valueOf(timestamp));
    System.out.println("Teller ID: " + tellerId);
  }
}
```


## GOOD

```java
import java.time.LocalDateTime;

public class Main {
  public static void main(String[] args) {
    Transaction t1 = new Transaction(1, "000012345", 1000, TransactionType.DEBIT, "2001");
    TransactionPrinter.print(t1);
  }
}

enum TransactionType {
  DEBIT,
  CREDIT,
}

class Transaction {
  private long id;
  private String account;
  private double amount;
  private LocalDateTime timestamp;
  private TransactionType type;
  private String tellerId;

  public Transaction(long id, String account, double amount, TransactionType type, String tellerId) {
    this.id = id;
    this.account = account;
    this.amount = amount;
    this.type = type;
    this.tellerId = tellerId;
    this.timestamp = LocalDateTime.now();
  }

  public long getId() {
    return id;
  }

  public String getAccount() {
    return account;
  }

  public double getAmount() {
    return amount;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public TransactionType getType() {
    return type;
  }

  public String getTellerId() {
    return tellerId;
  }
}

class TransactionPrinter {
  public static void print(Transaction t) {
    System.out.println("Transaction #" + String.valueOf(t.getId()));
    System.out.println("Account #" + t.getAccount());
    System.out.println("Type: " + t.getType().toString());
    System.out.println("Amount: " + String.valueOf(t.getAmount()));
    System.out.println("Transaction Date: " + String.valueOf(t.getTimestamp()));
    System.out.println("Teller ID: " + t.getTellerId());
  }
}
```
