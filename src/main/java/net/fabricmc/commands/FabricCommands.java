/*
 * Copyright 2016 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.commands;

import net.fabricmc.api.Hook;
import net.fabricmc.base.Fabric;
import net.fabricmc.base.loader.Init;
import net.fabricmc.commands.events.RegisterCommandEvent;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandManager;
import net.minecraft.command.CommandManagerServer;
import net.minecraft.server.MinecraftServer;

public class FabricCommands {

	@Init
	public void init() {
		Fabric.getLoadingBus().subscribe(this);
	}

	@Hook(name = "fabric-commands:modsInitialized", before = {}, after = "fabric:modsInitialized")
	public void postInit() {
		MinecraftServer server = Fabric.getSidedHandler().getServerInstance();
		if (server != null && server.isDedicated()) {
			Fabric.getEventBus().publish(new RegisterCommandEvent((CommandManager) server.getCommandManager()));
			if (server.getCommandManager() instanceof CommandManagerServer) {
				CommandBase.setCommandManager((CommandManagerServer) server.getCommandManager());
			}
		}
	}

}
