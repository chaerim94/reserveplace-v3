package reserveplace.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import reserveplace.PaymentApplication;
import reserveplace.domain.PaymentApproved;
import reserveplace.domain.PaymentCancelApproved;

@Entity
@Table(name = "PaymentHistory_table")
@Data
//<<< DDD / Aggregate Root
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payId;

    private Long orderId;

    private String usrId;

    private Double amount;

    private String status;

    private Long placeId;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {
        PaymentApproved paymentApproved = new PaymentApproved(this);
        paymentApproved.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        PaymentCancelApproved paymentCancelApproved = new PaymentCancelApproved(
            this
        );
        paymentCancelApproved.publishAfterCommit();
    }

    public static PaymentHistoryRepository repository() {
        PaymentHistoryRepository paymentHistoryRepository = PaymentApplication.applicationContext.getBean(
            PaymentHistoryRepository.class
        );
        return paymentHistoryRepository;
    }
}
//>>> DDD / Aggregate Root
