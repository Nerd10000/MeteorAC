package me.dragon.meteorac.checks.impl.speed;
import me.dragon.meteorac.checks.Check;
import me.dragon.meteorac.utils.MovementProcessor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

//Speed bhop check
public class SpeedB implements Listener {
    @EventHandler
    public void onCheck(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Vector FromVelo = event.getFrom().toVector();
        Vector ToVelo = event.getTo().toVector();

        double deltaX = ToVelo.getX() - FromVelo.getX();
        double deltaZ = ToVelo.getZ() - FromVelo.getZ();

        double deltaXZ = Math.hypot(deltaX, deltaZ);
        double max =  0.29F; //0.280615982024032;


        MovementProcessor.ldxz = deltaXZ;

        double absDeltaXZ = Math.abs(deltaXZ);





        if (absDeltaXZ > max && !player.isFlying() && player.isOnGround() && player.isSprinting()) {
            Check.flag(player, "Speed(A)", "DeltaXZ= " + absDeltaXZ + " > " + max, 10, true);
        }
        //Bhop Speed = 0.31290023284169877 = ~0.38

    }
}