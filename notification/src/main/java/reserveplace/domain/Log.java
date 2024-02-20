package reserveplace.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import reserveplace.NotificationApplication;

@Entity
@Table(name = "Log_table")
@Data
//<<< DDD / Aggregate Root
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long logId;

    private String usrId;

    public static LogRepository repository() {
        LogRepository logRepository = NotificationApplication.applicationContext.getBean(
            LogRepository.class
        );
        return logRepository;
    }

    //<<< Clean Arch / Port Method
    public static void notifedUser(
        ReservationStatusChanged reservationStatusChanged
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */

        /** Example 2:  finding and process
        
        repository().findById(reservationStatusChanged.get???()).ifPresent(log->{
            
            log // do something
            repository().save(log);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
