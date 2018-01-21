package com.sxtanna.ver

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer
import net.minecraft.server.v1_8_R3.PacketPlayOutChat
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
import org.bukkit.entity.Player

class Compat1_8 : Compat {

    override fun sendActionBar(player : Player, message : String) {
        val chat = PacketPlayOutChat(ChatSerializer.a("{\"text\": \"$message\"}"), 2)
        (player as CraftPlayer).handle.playerConnection.sendPacket(chat)
    }

}