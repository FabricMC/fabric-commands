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

import net.minecraft.client.MinecraftGame;
import net.minecraft.command.CommandManager;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandManagerClient extends CommandManager {
	public boolean tryExecute(ICommandSender sender, String message) {
		String cmdMessage = message.trim();
		if (cmdMessage.startsWith("/")) {
			cmdMessage = cmdMessage.substring(1);
			String command = cmdMessage.split(" ")[0];
			if (getRegisteredCommands().containsKey(command)) {
				executeCommand(sender, message);
				return true;
			}
		}

		return false;
	}

	@Override
	public MinecraftServer getServer() {
		return MinecraftGame.getInstance().getServer();
	}
}
