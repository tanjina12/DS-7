package server;

import server.event.Event;
import server.utility.CommandType;

import java.util.Vector;

public class GameState {
    private Battlefield battlefield;
    private int simulationTime;
    private Vector<Event> events;

    public void setBattlefield(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

    public void setSimulationTime(int simulationTime) {
        this.simulationTime = simulationTime;
    }

    public void setEvents(Vector<Event> events) {
        this.events = events;
    }

    public Battlefield getBattlefield() {
        return battlefield;
    }

    public int getSimulationTime() {
        return simulationTime;
    }

    public Vector<Event> getEvents() {
        return events;
    }

    public void runCommand(Event e){
        CommandType cmd= e.getCommandType();

        if(cmd==CommandType.ATTACK)
            e.attack();
        else if (cmd==CommandType.HEAL)
            e.heal();
        else if (cmd==CommandType.MOVE)
            e.move();
        else if (cmd==CommandType.CONNECT)
            e.connect(battlefield);
        else if (cmd==CommandType.DISCONNECT)
            e.disconnect(battlefield);
    }
}
