package org.palu.thing.control;

import org.palu.thing.entity.Thing;

public class ThingControl {
    public Thing getThing(Long id) {
        // query kafka streams view "thingPerId"
        return null;
    }

    public Thing createThing(Thing thingToCreate) {
        // check if thing is already there
        // add to thing stream
        // maybe add to locations stream, or let stream figure this one out on its own
        return null;
    }

    public Thing updateThing(Thing thingToUpdate) {
        // check if thing is there at all
        // figure out which command is actually given
        // TODO maybe figure out CQRS patterns already in the frontend
        // pipe command into the proper queues
        // - location change or add
        // - thing updates
        // <tbd>
        return null;
    }
}
