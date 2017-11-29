package server;

public class GameState {
    private Battlefield battlefield;
    private int simulationTime;

    public void setBattlefield(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

    public void setSimulationTime(int simulationTime) {
        this.simulationTime = simulationTime;
    }

    public Battlefield getBattlefield() {
        return battlefield;
    }

    public int getSimulationTime() {
        return simulationTime;
    }
}
