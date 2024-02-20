package reserveplace.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserveplace.domain.*;
import reserveplace.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentCancelApproved extends AbstractEvent {

    private Long payId;
    private Long orderId;
    private String usrId;
    private String status;
    private Double amount;
    private Long placeId;
    private Integer qty;

    public PaymentCancelApproved(PaymentHistory aggregate) {
        super(aggregate);
    }

    public PaymentCancelApproved() {
        super();
    }
}
//>>> DDD / Domain Event
