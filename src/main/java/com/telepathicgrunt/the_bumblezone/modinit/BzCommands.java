package com.telepathicgrunt.the_bumblezone.modinit;

import com.telepathicgrunt.the_bumblezone.commands.NoneOpCommands;
import org.quiltmc.qsl.command.api.CommandRegistrationCallback;

public class BzCommands {
    public static void registerCommand() {
        CommandRegistrationCallback.EVENT.register((dispatcher, integrated, dedicated) -> NoneOpCommands.createCommand(dispatcher));
    }
}