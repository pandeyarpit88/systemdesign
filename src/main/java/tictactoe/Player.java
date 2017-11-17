package tictactoe;

/**
 * Created by APandey1 on 17-11-2017.
 */
public class Player {
    String name;
    String moveSymbol;

    Player(String name, String moveSymbol) {
        this.name = name;
        this.moveSymbol = moveSymbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoveSymbol() {
        return moveSymbol;
    }

    public void setMoveSymbol(String moveSymbol) {
        this.moveSymbol = moveSymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Player))
            return false;
        Player player = (Player) o;
        if (getName() != null ? !getName().equals(player.getName()) : player.getName() != null)
            return false;
        return getMoveSymbol() != null ? getMoveSymbol().equals(player.getMoveSymbol()) : player.getMoveSymbol() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getMoveSymbol() != null ? getMoveSymbol().hashCode() : 0);
        return result;
    }
}
