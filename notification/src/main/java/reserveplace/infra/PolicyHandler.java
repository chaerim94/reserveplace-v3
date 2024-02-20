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
    LogRepository logRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReservationStatusChanged'"
    )
    public void wheneverReservationStatusChanged_NotifedUser(
        @Payload ReservationStatusChanged reservationStatusChanged
    ) {
        ReservationStatusChanged event = reservationStatusChanged;
        System.out.println(
            "\n\n##### listener NotifedUser : " +
            reservationStatusChanged +
            "\n\n"
        );

        // Sample Logic //
        Log.notifedUser(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
