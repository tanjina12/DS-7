package server.entity;

import java.util.Vector;

public class Entity {
    private int entity_id;
    private int initial_hp;
    private int current_hp;
    private int ap;
    private int absolute_position_x;
    private int absolute_position_y;

    public void setEntity_id(int entity_id) {
        this.entity_id = entity_id;
    }

    public void setInitial_hp(int initial_hp) {
        this.initial_hp = initial_hp;
    }

    public void setCurrent_hp(int current_hp) {
        this.current_hp = current_hp;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public void setAbsolute_position_x(int absolute_position_x) {
        this.absolute_position_x = absolute_position_x;
    }

    public void setAbsolute_position_y(int absolute_position_y) {
        this.absolute_position_y = absolute_position_y;
    }

    public void setPosition(int absolute_position_x, int absolute_position_y){
        setAbsolute_position_x(absolute_position_x);
        setAbsolute_position_y(absolute_position_y);
    }

    public int getEntity_id() {
        return entity_id;
    }

    public int getInitial_hp() {
        return initial_hp;
    }

    public int getCurrent_hp() {
        return current_hp;
    }

    public int getAp() {
        return ap;
    }

    public int getAbsolute_position_x() {
        return absolute_position_x;
    }

    public int getAbsolute_position_y() {
        return absolute_position_y;
    }

    public Vector<Integer> getPosition(){
        Vector <Integer> pos= new Vector<>();
        pos.add(absolute_position_x);
        pos.add(absolute_position_y);
        return pos;
    }
}
