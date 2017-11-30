package server;

import server.entity.Entity;
import server.utility.EntityType;

import java.util.Vector;

public class Battlefield {
    private int[][] map;
    private Vector<Entity> entities;

    public void initMap(int[][] map) {
        int i,j;
        for(i=0;i<25;i++){
            for(j=0;j<25;j++){
                map[i][j]=-1;
            }
        }
    }

    public int isExistEntity(int entity_id){
        int i;
        for(i=0;i<entities.size();i++){
            if (entities.get(i).getEntity_id()==entity_id)
                return 1;
        }

        return 0;
    }

    public int findEntity(int entity_id){
        int index=-1,i;
        for(i=0;i<entities.size();i++){
            if (entities.get(i).getEntity_id()==entity_id)
                index=i;
        }
        return index;
    }

    // TODO: 11/29/17  randomness for setting x and y editing following method
    public Vector<Integer> randomPos(){
        Vector<Integer> pos= new Vector<>();
        return pos;
    }
    // TODO: 11/29/17  randomness for entity initial hp and ap by editing following methods
    public int randomHp(){
        int hp=0;
        return hp;
    }
    public int randomAp(){
        int ap=0;
        return ap;
    }

    // TODO: 11/29/17 create dragons

    public Entity createNewPlayer(){
        Vector<Integer> pos= randomPos();
        int initial_hp= randomHp();
        int ap=randomAp();

        Entity e=new Entity();
        e.setType(EntityType.Player);
        e.setEntity_id(entities.size());
        e.setInitial_hp(initial_hp);
        e.setCurrent_hp(initial_hp);
        e.setAp(ap);
        e.setPosition(pos.get(0),pos.get(1));
        return e;
    }

    public boolean addEntity(Entity e){
        int x= e.getAbsolute_position_x();
        int y= e.getAbsolute_position_y();
        if (map[x][y]!=-1)
            return false;
        map[x][y]= e.getEntity_id();
        entities.add(e);
        return true;
    }

    public boolean changeEntityPosition(int entity_id,int x,int y){
        int index= findEntity(entity_id);
        if(index==-1)
            return false;
        int current_x= entities.get(index).getAbsolute_position_x();
        int current_y= entities.get(index).getAbsolute_position_y();

        map[current_x][current_y]=-1;
        map[x][y]=entity_id;
        entities.get(index).setAbsolute_position_x(x);
        entities.get(index).setAbsolute_position_y(y);
        return true;
    }

    public boolean changeEntityHP(int entity_id,int hp){
        int index=findEntity(entity_id);
        if(index==-1)
            return false;
        entities.get(index).setCurrent_hp(hp);
        return true;
    }

    public boolean isEmptyCell(int pos_x, int pos_y)
    {
        if(map[pos_x][pos_y] == -1)
            return true;
        return false;
    }

    public boolean changeEntityAP(int entity_id,int ap){
        int index=findEntity(entity_id);
        if(index==-1)
            return false;
        entities.get(index).setAp(ap);
        return true;
    }

    public boolean removeEntity(int entity_id){
        int index= findEntity(entity_id);
        if(index==-1)
            return false;
        int current_x= entities.get(index).getAbsolute_position_x();
        int current_y= entities.get(index).getAbsolute_position_y();
        map[current_x][current_y]=-1;
        entities.remove(index);
        return true;
    }

    public int[][] getMap() {
        return map;
    }

    public Vector<Entity> getEntities() {
        return entities;
    }

    public Entity getEntity(int entity_id){
        int index=findEntity(entity_id);
        return entities.get(index);
    }
}
