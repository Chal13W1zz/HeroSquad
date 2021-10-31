package models;

import java.util.Objects;

public class Squad {
    private int id;
    private String squadName;
    private String squadCause;
    private int maxSize;
    private boolean squadFull;

    public Squad(String squadName, String squadCause, int maxSize) {
        this.squadName = squadName;
        this.squadCause = squadCause;
        this.maxSize = maxSize;
        this.squadFull = false ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squad squad = (Squad) o;
        return id == squad.id && maxSize == squad.maxSize && squadFull == squad.squadFull && Objects.equals(squadName, squad.squadName) && Objects.equals(squadCause, squad.squadCause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, squadName, squadCause, maxSize, squadFull);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public String getSquadCause() {
        return squadCause;
    }

    public void setSquadCause(String squadCause) {
        this.squadCause = squadCause;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isSquadFull() {
        return squadFull;
    }

    public void setSquadFull(boolean squadFull) {
        this.squadFull = squadFull;
    }
}
