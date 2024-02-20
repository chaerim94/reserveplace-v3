package reserveplace.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import reserveplace.infra.AbstractEvent;

@Data
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
