package reserveplace.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import reserveplace.PlaceApplication;
import reserveplace.domain.ReservationCanceled;
import reserveplace.domain.ReservationPlaced;

@Entity
@Table(name = "Accommodation_table")
@Data
//<<< DDD / Aggregate Root
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private String placeNm;

    private String placeId;

    private String status;

    private String usrId;

    private Date strDt;

    private Date endDt;

    private Integer qty;

    private Double amount;

    @PostPersist
    public void onPostPersist() {
        ReservationPlaced reservationPlaced = new ReservationPlaced(this);
        reservationPlaced.publishAfterCommit(getOrderId());
    }

    @PrePersist
    public void onPrePersist() {}

    @PreRemove
    public void onPreRemove() {
        ReservationCanceled reservationCanceled = new ReservationCanceled(this);
        reservationCanceled.publishAfterCommit(getOrderId());
    }

    public static AccommodationRepository repository() {
        AccommodationRepository accommodationRepository = PlaceApplication.applicationContext.getBean(
            AccommodationRepository.class
        );
        return accommodationRepository;
    }

    //<<< Clean Arch / Port Method
    public void reservationStatusUpdate() {
        //implement business logic here:

        ReservationStatusChanged reservationStatusChanged = new ReservationStatusChanged(
            this
        );
        reservationStatusChanged.publishAfterCommit(getOrderId());
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
