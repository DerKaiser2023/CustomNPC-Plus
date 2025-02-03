package noppes.npcs.client;

import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import noppes.npcs.CustomNpcs;
import noppes.npcs.Server;


import java.io.IOException;

public class Client {

	public static void sendData(final EnumPacketServer enu, final Object... obs) {
		ByteBuf buffer = Unpooled.buffer();
		try {
			if(!Server.fillBuffer(buffer, enu, obs))
				return;
			CustomNpcs.Channel.sendToServer(new FMLProxyPacket(buffer, "CustomNPCs"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
