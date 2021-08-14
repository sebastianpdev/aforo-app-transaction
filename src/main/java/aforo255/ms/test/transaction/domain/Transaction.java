package aforo255.ms.test.transaction.domain;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "transaction")
public class Transaction {

    @BsonId
    private Long idTransaction;

    private Long idInvoice;

    private double amount;

    private Instant date;


    public Long getIdTransaction() {
        return idTransaction;
    }

    public Transaction setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
        return this;
    }

    public Long getIdInvoice() {
        return idInvoice;
    }

    public Transaction setIdInvoice(Long idInvoice) {
        this.idInvoice = idInvoice;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public Transaction setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public Instant getDate() {
        return date;
    }

    public Transaction setDate(Instant date) {
        this.date = date;
        return this;
    }
}
