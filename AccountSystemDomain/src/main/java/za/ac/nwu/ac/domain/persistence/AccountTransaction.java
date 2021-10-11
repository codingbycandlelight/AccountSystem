package za.ac.nwu.ac.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TYPE", schema = "VIT_RSA_SANDBOX")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = -1420294317019175746L;

    private long transactionID;
    private AccountType accountType;
    private long amount;
    private LocalDate transactionDate;

    public AccountTransaction() {
    }

    public AccountTransaction(long transactionID, AccountType accountType, long amount, LocalDate transactionDate) {
        this.transactionID = transactionID;
        this.accountType = accountType;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    private static final long serialVersionID = -1420294317019175746L;
    @Id
    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "VIT_RSA_SANDBOX.VIT_RSA_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")

    @Column(name = "ACCOUNT_TRANSACTIONS_ID")
    public long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Column(name = "TRANSACTION_AMOUNT")
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Column(name = "TRANSACTION_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return transactionID == that.transactionID && amount == that.amount && Objects.equals(accountType, that.accountType) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, accountType, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionID=" + transactionID +
                ", accountType=" + accountType +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}

