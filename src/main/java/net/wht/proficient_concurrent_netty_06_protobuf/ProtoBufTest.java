package net.wht.proficient_concurrent_netty_06_protobuf;

import net.wht.proficient_concurrent_netty_06_protobuf.DataInfo.Student;

public class ProtoBufTest {

	public static void main(String[] args) throws Exception {
		Student studnet = DataInfo.Student.newBuilder().setName("张三").setAge(28).setAddress("广州").build();
		byte[] studnet2ByteArry = studnet.toByteArray();
		
		Student student2 = DataInfo.Student.parseFrom(studnet2ByteArry);
		System.out.println(student2.getName());
		System.out.println(student2.getAge());
		System.out.println(student2.getAddress());
	}
}
