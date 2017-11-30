package server.tss;

import server.GameState;
import server.event.Event;

import java.util.Vector;

public class TSS {
    private int max_delay;
    // TODO: 11/30/17 throwing exception
    private int states_num;
    private GameState leading_state;
    private Vector<Event> events;
    private Vector<Integer> delays;
    private Vector<GameState> trailing_states;

    public void setMax_delay(int max_delay) {
        this.max_delay = max_delay;
    }

    public void setStates_num(int states_num) {
        this.states_num = states_num;
    }

    public void setLeading_state(GameState start) {
        this.leading_state = start;
    }

    public void setEvents(Vector<Event> events) {
        this.events = events;
        this.leading_state.setEvents(events);
    }

    public void setDelays(int initial_delay) {
        int delay=initial_delay;
        int i;
        for(i=0;i<states_num;i++){
            delays.add(i,delay);
            delay*=2;
        }
    }

    public void setTrailing_states() {
        int i;
        int simulation_time=leading_state.getSimulationTime();
        for(i=0;i<states_num;i++){
            trailing_states.add(i,leading_state);
            trailing_states.get(i).setSimulationTime(simulation_time - delays.get(i));
        }
    }

    public Event receiveEvent(Event e){
        Event accepted_event= e;
        events.add(accepted_event);

        int i;
        if(accepted_event.getSimulationTime() > leading_state.getSimulationTime()){

        }
        for(i=states_num-2; i>=0; i++){
           if(accepted_event.getSimulationTime()>trailing_states.get(i).getSimulationTime()){
               //out of sync
                GameState pre_state= new GameState();
                pre_state=trailing_states.get(i+1);
                trailing_states.set(i,pre_state);
           }
        }

        return accepted_event;
    }
}
