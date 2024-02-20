package reserveplace.domain;

import java.util.*;
import lombok.*;
import reserveplace.domain.*;
import reserveplace.infra.AbstractEvent;

@Data
@ToString
public class ReservationStatusChanged extends AbstractEvent {

    private Long orderId;
    private String placeNm;
    private String status;
    private String usrId;
    private Date strDt;
    private Date endDt;
    private Integer qty;
    private Double amount;
    private Long placeId;
}
