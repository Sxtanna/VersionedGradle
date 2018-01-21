package com.sxtanna.ver

import net.minecraft.server.v1_9_R2.IChatBaseComponent.ChatSerializer
import net.minecraft.server.v1_9_R2.PacketPlayOutChat
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer
import org.bukkit.entity.Player

class Compat1_9 : Compat {

    override fun sendActionBar(player : Player, message : String) {
        val chat = PacketPlayOutChat(ChatSerializer.a("{\"text\": \"$message\"}"), 2)
        (player as CraftPlayer).handle.playerConnection.sendPacket(chat)
    }

}