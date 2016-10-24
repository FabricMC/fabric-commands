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

package net.fabricmc.commands.test;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.TextComponentString;
import net.minecraft.text.TextFormat;

public class TestCommand extends CommandBase {
	private final String name;
	private final TextFormat format;

	public TestCommand(String name, TextFormat format) {
		this.name = name;
		this.format = format;
	}

	@Override
	public int getMinPermissionLevel() {
		return 0;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getUsage(ICommandSender iCommandSender) {
		return name;
	}

	@Override
	public void execute(MinecraftServer minecraftServer, ICommandSender iCommandSender, String[] strings) throws CommandException {
		iCommandSender.appendCommandFeedback(new TextComponentString(format + "Hello"));
	}
}
