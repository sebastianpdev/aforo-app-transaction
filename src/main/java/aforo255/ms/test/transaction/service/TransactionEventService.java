package aforo255.ms.test.transaction.service;

import aforo255.ms.test.transaction.domain.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@Service
public class TransactionEventService {

    private final TransactionService transactionService;
    private final ObjectMapper objectMapper;

    public TransactionEventService(TransactionService transactionService, ObjectMapper objectMapper) {
        this.transactionService = transactionService;
        this.objectMapper = objectMapper;
    }

    public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
        //Invoice invoice = objectMapper.convertValue(consumerRecord.value(), Invoice.class);
        Transaction transaction = objectMapper.readValue(consumerRecord.value(), Transaction.class);
        transactionService.save(transaction);
    }

}
