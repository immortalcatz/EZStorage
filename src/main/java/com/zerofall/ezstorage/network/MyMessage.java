package com.zerofall.ezstorage.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MyMessage implements IMessage {
    
    public int index;
    public int button;
    public int mode;

    public MyMessage() { }

    public MyMessage(int index, int button, int mode) {
        this.index = index;
        this.button = button;
        this.mode = mode;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        index = ByteBufUtils.readVarInt(buf, 5);
        button = ByteBufUtils.readVarInt(buf, 5);
        mode = ByteBufUtils.readVarInt(buf, 5);
    }

    @Override
    public void toBytes(ByteBuf buf) {
    	ByteBufUtils.writeVarInt(buf, index, 5);
        ByteBufUtils.writeVarInt(buf, button, 5);
        ByteBufUtils.writeVarInt(buf, mode, 5);
    }
}
