package reserveplace.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import reserveplace.infra.AbstractEvent;

@Data
public class PaymentCancelApproved extends AbstractEvent {

    private Long payId;
    private Long orderId;
    private String usrId;
    private String status;
    private Double amount;
    private Long placeId;
    private Integer qty;
}
