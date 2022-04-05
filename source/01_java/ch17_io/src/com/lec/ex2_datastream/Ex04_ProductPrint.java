package com.lec.ex2_datastream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

//���Ͽ� ����� ������ ���
public class Ex04_ProductPrint {

	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream dis = null;
		ArrayList<Product> product = new ArrayList<Product>();

		try {
			fis = new FileInputStream("src/com/lec/ex2_datastream/product.dat");
			dis = new DataInputStream(fis);

			while (true) {
				String name = dis.readUTF();
				int price = dis.readInt();
				int ps = dis.readInt();// ������ �˼����� �Էµ� ������� �����´�
				product.add(new Product(name, price, ps));
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("��� �����ʹ� ������ �����ϴ�.");// ���̻� ������ ������ �߻��ϴ� ����
		} finally {
			try {
				if (dis != null)dis.close();
				if (fis != null)fis.close();
			} catch (IOException e) {}
		}
		if(product.isEmpty()) {
			System.out.println("�Էµ� ����� �����ϴ�.");
		}else {
			for(Product p : product) {
				System.out.println(product);
			}
			System.out.println("�̻� ��ǰ "+ product.size()+"���� �Էµ�");
			
		}	
	}
}
