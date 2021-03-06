package com.study.netty.tcp.demo2.server.decoder;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.study.netty.tcp.demo2.dto.DTObject;
import com.study.netty.tcp.demo2.utils.JacksonUtils;
import com.study.netty.tcp.demo2.utils.ProtocolUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * @author valiantzh
 * @version 1.0
 */
public class DecoderHandler_2_0 extends ByteToMessageDecoder {
    private Logger logger = Logger.getLogger(this.getClass());

    //最小的数据长度：开头标准位1字节
    private static int MIN_DATA_LEN = 6 + 1 + 1 + 1;
    //数据解码协议的开始标志
    private static byte PROTOCOL_HEADER = 0x58;
    //数据解码协议的结束标志
    private static byte PROTOCOL_TAIL = 0x63;

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() > MIN_DATA_LEN) {
            logger.debug("开始解码数据……");
            //标记读操作的指针
            in.markReaderIndex();
            byte header = in.readByte();
            if (header == PROTOCOL_HEADER) {
                logger.debug("数据开头格式正确");
                //读取class类型
                byte type = in.readByte();
                int dataLen = in.readInt();
                if (dataLen < in.readableBytes()) {
                    byte[] data = new byte[dataLen];
                    in.readBytes(data);
                    byte tail = in.readByte();
                    try {
                        if (tail == PROTOCOL_TAIL) {
                            ObjectMapper objectMapper = JacksonUtils.getInstanceObjectMapper();
                            DTObject dtObject = objectMapper.readValue(data, DTObject.class);
                            Class<?> Type = Class.forName(dtObject.getClassName());
                            logger.debug("数据解码成功");
                            logger.debug("开始封装数据……");
                            if (type == ProtocolUtils.OBJ_TYPE) {
                                Object o = objectMapper.readValue(dtObject.getObject(), Type);
                                out.add(o);
                            } else if (type == ProtocolUtils.MAP_TYPE) {
                                JavaType javaType = TypeFactory.defaultInstance().constructMapType(Map.class, String.class, Type);
                                Object o = objectMapper.readValue(dtObject.getObject(), javaType);
                                out.add(o);
                            } else if (type == ProtocolUtils.LIST_TYPE) {
                                JavaType javaType = TypeFactory.defaultInstance().constructCollectionType(List.class, Type);
                                Object o = objectMapper.readValue(dtObject.getObject(), javaType);
                                out.add(o);
                            }
                            //如果out有值，且in仍然可读，将继续调用decode方法再次解码in中的内容，以此解决粘包问题
                        } else {
                            logger.debug(String.format("数据解码协议结束标志位:%1$d [错误!]，期待的结束标志位是：%2$d", tail, PROTOCOL_TAIL));
                            return;
                        }
                    } catch (ClassNotFoundException e) {
                        logger.error(String.format("反序列化对象的类找不到,注意包名匹配！ "));
                        return;
                    } catch (Exception e) {
                        logger.error(e);
                        return;
                    }

                } else {
                    logger.debug(String.format("数据长度不够，数据协议len长度为：%1$d,数据包实际可读内容为：%2$d正在等待处理拆包……", dataLen, in.readableBytes()));
                    in.resetReaderIndex();
                    /*
                     **结束解码，这种情况说明数据没有到齐，在父类ByteToMessageDecoder的callDecode中会对out和in进行判断
                     * 如果in里面还有可读内容即in.isReadable位true,cumulation中的内容会进行保留，，直到下一次数据到来，将两帧的数据合并起来，再解码。
                     * 以此解决拆包问题
                     */
                    return;
                }
            } else {
                logger.debug("开头不对，可能不是期待的客服端发送的数，将自动略过这一个字节");
            }
        } else {
            logger.debug("数据长度不符合要求，期待最小长度是：" + MIN_DATA_LEN + " 字节");
            return;
        }
    }
}
