package server.event;

import server.Battlefield;
import server.entity.Entity;
import server.utility.CommandType;


public class Event {

    private int starter_id;
    private int target_id;
    private int simulationTime;
    private int executionTime;
    private CommandType commandType;
    private int pos_x;
    private int pos_y;

    public void setStarter_id(int starter_id) {
        this.starter_id = starter_id;
    }

    public void setTarget_id(int target_id) {
        this.target_id = target_id;
    }

    public void setSimulationTime(int simulationTime) {
        this.simulationTime = simulationTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }



    public int getStarter_id() {
        return starter_id;
    }

    public int getTarget_id() {
        return target_id;
    }

    public int getSimulationTime() {
        return simulationTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
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

    public boolean move(){
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
