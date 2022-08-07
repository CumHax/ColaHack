package me.cumhax.colahack.event;

import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraft.entity.EntityLivingBase;

public class LocalPlayerUpdateEvent extends Event {

    EntityLivingBase entityLivingBase;

    public LocalPlayerUpdateEvent(EntityLivingBase entity) {
        this.entityLivingBase = entity;
    }

    public EntityLivingBase getEntityLivingBase() {
        return entityLivingBase;
    }
}
