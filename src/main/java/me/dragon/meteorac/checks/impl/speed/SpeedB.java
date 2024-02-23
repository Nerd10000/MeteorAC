package me.dragon.meteorac.checks.impl.speed;

import me.dragon.meteorac.checks.Check;
import me.dragon.meteorac.utils.MovementProcessor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class SpeedA implements Listener {

    private static final float MAX_WB = 0.5454136310569225F;

    @EventHandler
    public void onMove(PlayerMoveEvent e){

        double fx = e.getFrom().getX();
        double fz = e.getFrom().getZ();
        double argument = Math.max(0, e.getTo().getX() - fx + e.getTo().getZ() - fz);
        double sqrt = Math.sqrt(argument);

        //Check.debug(e.getPlayer(), "sqrt=" + sqrt + " jumping=" + MovementProcessor.isJumping(e) + " isRotate=" + MovementProcessor.isRotate(e) + " falling?=" + MovementProcessor.isFalling(e));
        //Check.debug(e.getPlayer(), "rotationYaw= from=" + e.getFrom().getYaw() + " to=" + e.getTo().getYaw());

        if (sqrt > MAX_WB && !Double.isNaN(sqrt) && !MovementProcessor.isFalling(e.getPlayer()) && !MovementProcessor.isJumping((e.getPlayer())) && !e.getPlayer().isFlying()){//Check.flag(e.getPlayer(), "SpeedA", "sqrt= " + sqrt + "> max=" + MAX_WB, 100, true);
            //e.getPlayer().teleport(e.getFrom());

        }
    }
}
