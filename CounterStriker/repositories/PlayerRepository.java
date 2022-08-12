package CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PlayerRepository implements Repository<Player>{
    public Collection<Player> models;

    public PlayerRepository() {

        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Player player) {
        if (player == null){
            throw new NullPointerException(ExceptionMessages.INVALID_PLAYER_REPOSITORY);
        }
        models.add(player);

    }

    @Override
    public boolean remove(Player player) {
        return models.remove(player);
    }

    @Override
    public Player findByName(String name) {
        return models.stream().filter(s->s.getUsername().equals(name)).findFirst().orElse(null);
    }
}
