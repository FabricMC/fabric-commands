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

package net.fabricmc.commands.events;

import net.fabricmc.api.Event;
import net.minecraft.command.CommandManager;

/**
 * This event is used to register commands
 */
public abstract class RegisterCommandEvent extends Event.Event1<CommandManager> {

	/**
	 * @return the command manager to register the commands with
	 */
//	public CommandManager getCommandManager() {
//		return handlers.get(0).;
//	}

	public static class Client extends RegisterCommandEvent {

	}

	public static class Server extends RegisterCommandEvent {

	}
}
