package server.event;

import server.entity.Entity;
import server.utility.EntityType;

public abstract class Event {

    private Entity starter;
    public abstract void applyAction();
}
