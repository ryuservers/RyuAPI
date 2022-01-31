package com.ryuservers.api.methods;

import com.ryuservers.api.RyuAPI;
import com.ryuservers.api.callbacks.JavaCallback;
import com.ryuservers.api.utils.http.RyuAPICallback;
import org.bukkit.entity.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListOnlinePlayers extends JavaCallback implements RyuAPICallback, Serializable {
    @Override
    public Object callWithParams(Map<String, String> params) {
        List<Player> players = new ArrayList<>();

        for(Player player : RyuAPI.getInstance().getServer().getOnlinePlayers()) {
            players.add(player);
        }

        return players;
    }
}
