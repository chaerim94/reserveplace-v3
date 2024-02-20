package reserveplace.external;

import java.util.Date;
import lombok.Data;

@Data
public class ReservationManagement {

    private Long placeId;
    private Long orderId;
    private String status;
    private Integer stock;
    private String placeNm;
}
