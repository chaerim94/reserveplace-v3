package reserveplace.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import reserveplace.config.kafka.KafkaProcessor;
import reserveplace.domain.*;

@Service
public class MypageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationPlaced_then_CREATE_1(
        @Payload ReservationPlaced reservationPlaced
    ) {
        try {
            if (!reservationPlaced.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setOrderId(reservationPlaced.getOrderId());
            mypage.setUsrId(reservationPlaced.getUsrId());
            mypage.setPlaceNm(reservationPlaced.getPlaceNm());
            mypage.setPlaceId(reservationPlaced.getPlaceId());
            mypage.setStatus(reservationPlaced.getStatus());
            mypage.setAmount(reservationPlaced.getAmount());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentApproved_then_UPDATE_1(
        @Payload PaymentApproved paymentApproved
    ) {
        try {
            if (!paymentApproved.validate()) return;
            // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findByOrderId(
                paymentApproved.getOrderId()
            );

            if (mypageOptional.isPresent()) {
                Mypage mypage = mypageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setAmount(paymentApproved.getAmount());
                mypage.setStatus(paymentApproved.getStatus());
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCancelApproved_then_UPDATE_2(
        @Payload PaymentCancelApproved paymentCancelApproved
    ) {
        try {
            if (!paymentCancelApproved.validate()) return;
            // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findByOrderId(
                paymentCancelApproved.getOrderId()
            );

            if (mypageOptional.isPresent()) {
                Mypage mypage = mypageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setAmount(paymentCancelApproved.getAmount());
                mypage.setStatus(paymentCancelApproved.getStatus());
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationStatusChanged_then_UPDATE_3(
        @Payload ReservationStatusChanged reservationStatusChanged
    ) {
        try {
            if (!reservationStatusChanged.validate()) return;
            // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findByOrderId(
                reservationStatusChanged.getOrderId()
            );

            if (mypageOptional.isPresent()) {
                Mypage mypage = mypageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setStatus(reservationStatusChanged.getStatus());
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
