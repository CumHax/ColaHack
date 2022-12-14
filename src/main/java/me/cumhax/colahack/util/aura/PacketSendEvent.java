package me.cumhax.colahack.util.aura;

import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class PacketSendEvent extends Event
{
	private Packet<?> packet;

	public PacketSendEvent(Packet<?> packet)
	{
		this.packet = packet;
	}

	public Packet<?> getPacket()
	{
		return packet;
	}

	public void setPacket(Packet<?> packet)
	{
		this.packet = packet;
	}
}