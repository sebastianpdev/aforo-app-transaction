package aforo255.ms.test.transaction.listener;

import aforo255.ms.test.transaction.service.TransactionEventService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    private final Logger logger = LoggerFactory.getLogger(ConsumerListener.class);

    private final TransactionEventService transactionEventService;

    public ConsumerListener(TransactionEventService transactionEventService) {
        this.transactionEventService = transactionEventService;
    }

    @KafkaListener(topics = {"transaction-events-test"})
    private void onMessageReceived(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
        logger.info("--------- Message received on Transaction microservice ---------");
        logger.info("Consumer info was : {}", consumerRecord.value());

        transactionEventService.processTransactionEvent(consumerRecord);
    }
}
