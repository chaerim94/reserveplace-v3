package reserveplace.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class ReservationInformCommand {

    private Integer stock;
    private Long orderId;
}
