package aforo255.ms.test.transaction.dao;

import aforo255.ms.test.transaction.domain.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, Long> {

    @Query("{'idInvoice':?0}")
    public Iterable<Transaction> findByIdInvoice(Long idInvoice);

}
