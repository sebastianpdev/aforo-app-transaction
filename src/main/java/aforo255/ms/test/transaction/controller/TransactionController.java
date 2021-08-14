package aforo255.ms.test.transaction.controller;

import aforo255.ms.test.transaction.domain.Transaction;
import aforo255.ms.test.transaction.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions/all")
    public ResponseEntity<Iterable<Transaction>> getAllTransactions() {
        Iterable<Transaction> transactions = transactionService.findAll();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/transactions/invoice/{idInvoice}")
    public ResponseEntity<?> findAllByIdInvoice(@PathVariable("idInvoice") Long idInvoice) {
        Iterable<Transaction> transactions = transactionService.findByIdInvoice(idInvoice);
        return ResponseEntity.ok(transactions);
    }
}
