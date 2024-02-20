package reserveplace.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import reserveplace.domain.*;

@Component
public class AccommodationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Accommodation>> {

    @Override
    public EntityModel<Accommodation> process(
        EntityModel<Accommodation> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/reservationstatusupdate"
                )
                .withRel("reservationstatusupdate")
        );

        return model;
    }
}
