package server.event;

import server.Battlefield;
import server.entity.Entity;
import server.utility.CommandType;
import server.utility.EntityType;

public class Event {

    private int starter_id;
    private int target_id;
    private int requestTime;
    private CommandType commandType;

    public void setStarter_id(int starter_id) {
        this.starter_id = starter_id;
    }

    public void setTarget_id(int target_id) {
        this.target_id = target_id;
    }

    public void setRequestTime(int requestTime) {
        this.requestTime = requestTime;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public int getStarter_id() {
        return starter_id;
    }

    public int getTarget_id() {
        return target_id;
    }

    public int getRequestTime() {
        return requestTime;
    }

    public CommandType getCommandType() {
        return commandType;
    }



    //different types of commands

    public boolean attack(){
        if (commandType!=CommandType.ATTACK)
            return false;
        // TODO: 11/29/17 calculate hp and ap of sender and target ,use battlefiled method(changeHp and changeAp and maybe remove) to update both entities
        return true;
    }

    public boolean heal(){
        if (commandType!=CommandType.HEAL)
            return false;
        // TODO: 11/29/17 calculate hp and ap of sender and target ,use battlefield method(changeHp and changeAp) to update both entities
        return true;
    }

    public boolean move(int pos_x,int pos_y){
        if (commandType!=CommandType.MOVE)
            return false;
        // TODO: 11/29/17 evaluate whether pos_x and pos_y is valid destination for movement or not
        // TODO: 11/29/17 use battlefield method (changePosition) to update entity
        return true;
    }

    public boolean connect(Battlefield battlefield){
        if (commandType!=CommandType.CONNECT)
            return false;
        Entity e=battlefield.createNewPlayer();
        battlefield.addEntity(e);
        return true;
    }

    public boolean disconnect(Battlefield battlefield){
        if (commandType!=CommandType.DISCONNECT)
            return false;
        battlefield.removeEntity(starter_id);
        return true;
    }
}
