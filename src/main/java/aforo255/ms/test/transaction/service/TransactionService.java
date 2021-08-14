package aforo255.ms.test.transaction.service;

import aforo255.ms.test.transaction.dao.TransactionRepository;
import aforo255.ms.test.transaction.domain.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements CRUD<Transaction> {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Iterable<Transaction> findByIdInvoice(Long idInvoice){
        return transactionRepository.findByIdInvoice(idInvoice);
    }

    @Override
    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public Transaction save(Transaction record) {
        return transactionRepository.save(record);
    }

    @Override
    public Iterable<Transaction> findAll() {
        return transactionRepository.findAll();
    }
}
