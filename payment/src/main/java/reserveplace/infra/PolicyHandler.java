package reserveplace.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import reserveplace.config.kafka.KafkaProcessor;
import reserveplace.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PaymentHistoryRepository paymentHistoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReservationPlaced'"
    )
    public void wheneverReservationPlaced_createPay(@Payload PaymentHistory paymentHistory) {

        paymentHistory.setStatus("결제완료");
        paymentHistoryRepository.save(paymentHistory);

     //   PaymentApproved paymentApproved = new PaymentApproved(paymentHistory);
     //   paymentApproved.publishAfterCommit();
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReservationCancelConfirmed'"
    )
    public void wheneverReservationCancelConfirmed_decreatePay(@Payload PaymentHistory paymentHistory) {

        paymentHistory.setStatus("결제취소");
        paymentHistoryRepository.save(paymentHistory);

        PaymentCancelApproved paymentCancelApproved = new PaymentCancelApproved(paymentHistory);
        paymentCancelApproved.publishAfterCommit();
    }
}
//>>> Clean Arch / Inbound Adaptor
