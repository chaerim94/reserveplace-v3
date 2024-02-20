package reserveplace.domain;

import java.util.*;
import lombok.*;
import reserveplace.domain.*;
import reserveplace.infra.AbstractEvent;

@Data
@ToString
public class PaymentApproved extends AbstractEvent {

    private Long payId;
    private Long orderId;
    private String usrId;
    private String status;
    private Double amount;
    private Long placeId;
    private Integer qty;
}
