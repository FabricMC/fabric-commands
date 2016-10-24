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

package net.fabricmc.commands.mixin.client;

import net.fabricmc.commands.FabricCommands;
import net.minecraft.client.player.EntityPlayerClient;
import net.minecraft.command.ICommandManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = EntityPlayerClient.class, remap = false)
public abstract class MixinEntityPlayerClient implements ICommandManager {
	@Inject(method = "sendChatMessage(Ljava/lang/String;)V", at = @At("HEAD"), cancellable = true)
	public void sendChatMessage(String message, CallbackInfo info) {
		if (FabricCommands.getClientManager().tryExecute(((EntityPlayerClient) (Object) this), message)) {
			info.cancel();
		}
	}
}
