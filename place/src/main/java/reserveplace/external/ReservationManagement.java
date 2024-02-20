package reserveplace.external;

import java.util.Date;
import lombok.Data;

@Data
public class ReservationManagement {

    private Long rsvId;
    private Long orderId;
    private String status;
    private String usrId;
    private Integer stock;
}
