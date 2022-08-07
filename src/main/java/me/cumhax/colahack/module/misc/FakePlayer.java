package me.cumhax.colahack.module.misc;

import com.mojang.authlib.GameProfile;
import me.cumhax.colahack.module.Category;
import me.cumhax.colahack.module.Module;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import java.util.UUID;

public class FakePlayer extends Module {
	
   public FakePlayer() {
      super("FakePlayer", "FakePlayer", Category.MISC);
   }

   public void onEnable() {
      if (mc.world == null) {
         return;
      }

      EntityOtherPlayerMP fakePlayer = new EntityOtherPlayerMP((World)mc.world, new GameProfile(UUID.fromString("9d10a205-dead-4560-aae5-74a269a99919"), "Test Slave"));
      fakePlayer.copyLocationAndAnglesFrom((Entity)mc.player);
      fakePlayer.rotationYawHead = mc.player.rotationYawHead;
      mc.world.addEntityToWorld(-100, (Entity)fakePlayer);
   }

   public void onDisable() {
      mc.world.removeEntityFromWorld(-100);
   }
}
