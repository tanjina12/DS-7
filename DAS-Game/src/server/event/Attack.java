package server.event;

import server.entity.Entity;
import server.utility.CommandType;

public class Attack extends Event{

    private Entity victim;
    private CommandType commandType;

    private int attackerId; // Or maybe attacker.entity_id

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public Entity getVictim() {
        return victim;
    }

    public void setVictim(Entity victim) {
        this.victim = victim;
    }

    public int getAttackerId() {
        return attackerId;
    }

    public void setAttackerId(int attackerId) {
        this.attackerId = attackerId;
    }
    @Override
    public void applyAction(){

    }
}
