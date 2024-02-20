package reserveplace.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import reserveplace.domain.*;

@Component
public class LogHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Log>> {

    @Override
    public EntityModel<Log> process(EntityModel<Log> model) {
        return model;
    }
}
