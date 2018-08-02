package de.memepool.thing.boundary;

import de.memepool.thing.control.ThingControl;
import de.memepool.thing.entity.Thing;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("thing")
public class ThingResource {

    @Inject
    ThingControl thingControl;

    @GET
    @Path("id")
    public Thing getThingDetails(Long id) {
        return thingControl.getThing(id);
    }

    @POST
    public Thing createThing(Thing thingToCreate) {
        return thingControl.createThing(thingToCreate);
    }

    @PUT
    @Path("id")
    public Thing updateThing(Thing thingToUpdate) {
        return thingControl.updateThing(thingToUpdate);
    }
}
