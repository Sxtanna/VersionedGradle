package com.sxtanna.ver

import org.bukkit.plugin.java.JavaPlugin

class PluginThing : JavaPlugin() {

    lateinit var version : String
        private set

    lateinit var compat : Compat
        private set


    override fun onLoad() {
        INSTANCE = this

        version = server.bukkitVersion.substringBefore('-')
    }

    override fun onEnable() {

        compat = when(version) {
            "1.8.8" -> Compat1_8()
            "1.9.4" -> Compat1_9()
            "1.10.2" -> Compat1_10()
            else -> {
                throw IllegalStateException("Compat for version `$version` is unavailable")
            }
        }

        server.onlinePlayers.forEach { compat.sendActionBar(it, "Hello!!") }

    }


    companion object {

        lateinit var INSTANCE : PluginThing
            private set

    }

}