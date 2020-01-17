package com.study.netty.tcp.demo2.server.encoder;

import com.study.netty.tcp.demo2.protocol.TcpProtocol;
import com.study.netty.tcp.demo2.protocol.TcpProtocol_2_0;
import com.study.netty.tcp.demo2.protocol.TcpProtocol_3_0;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.log4j.Logger;

/**
 * @author valiantzh
 * @version 1.0
 */
public class EncoderHandler extends MessageToByteEncoder {
    private Logger logger = Logger.getLogger(this.getClass());
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        if (msg instanceof TcpProtocol){
            TcpProtocol protocol = (TcpProtocol) msg;
            out.writeByte(protocol.getHeader());
            out.writeInt(protocol.getLen());
            out.writeBytes(protocol.getData());
            out.writeByte(protocol.getTail());
            logger.debug("TcpProtocol数据编码成功："+out);
        } else if(msg instanceof TcpProtocol_2_0) {
            TcpProtocol_2_0 protocol = (TcpProtocol_2_0) msg;
            out.writeByte(protocol.getHeader());
            out.writeByte(protocol.getType());
            out.writeInt(protocol.getLen());
            out.writeBytes(protocol.getData());
            out.writeByte(protocol.getTail());
            logger.debug("TcpProtocol_2_0数据编码成功："+out);
        } else if(msg instanceof TcpProtocol_3_0){
            TcpProtocol_3_0 protocol = (TcpProtocol_3_0) msg;
            out.writeByte(protocol.getHeader());
            out.writeByte(protocol.getType());
            out.writeByte(protocol.getClassLen());
            out.writeInt(protocol.getLen());
            out.writeBytes(protocol.getClassName());
            out.writeBytes(protocol.getData());
            out.writeByte(protocol.getTail());
            logger.debug("TcpProtocol_3_0 数据编码成功："+out);
        }else {
            logger.info("不支持的数据协议："+msg.getClass()+"\t期待的数据协议类是："+TcpProtocol.class);
        }
    }
}
