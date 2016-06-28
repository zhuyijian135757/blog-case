package net.flyingfat.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtobufTest {

	public static void main(String[] args) throws Exception {
		encode();
	}
	
	public static void encode() throws Exception{
		Request.msg.Builder builder=Request.msg.newBuilder();
		builder.setCmd("ontouch");
		builder.setKeycode(10);
		Request.msg  request=builder.build();
		byte[] buffer=request.toByteArray();
		
		
		Request.msg msg=Request.msg.parseFrom(buffer);
		System.out.println(msg.getCmd());
		
	}

}
