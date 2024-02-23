package me.dragon.meteorac.checks.impl.fly;

import com.github.retrooper.packetevents.event.PacketListener;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerFlying;
import me.dragon.meteorac.checks.Check;
import me.dragon.meteorac.utils.MovementProcessor;
import org.bukkit.entity.Player;

public class FlyHack implements PacketListener {


    //I was stupid to write my own, so I use Grim's!Please forgive me.I will write my own later.
    @Override
    public void onPacketReceive(PacketReceiveEvent event) {
        Player player = (Player) event.getPlayer();
        WrapperPlayClientPlayerFlying wrapper = new WrapperPlayClientPlayerFlying(event);
        MovementProcessor.ly = wrapper.getLocation().getY();

        MovementProcessor.y = player.getLocation().getY();

        



    }
}
