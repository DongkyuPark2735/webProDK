package com.lec.ex2_datastream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

//파일에 저장된 재고들을 출력
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
				int ps = dis.readInt();// 순서를 알수없고 입력된 순서대로 가져온다
				product.add(new Product(name, price, ps));
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("재고 데이터는 다음과 같습니다.");// 더이상 읽을게 없을떄 발생하는 에러
		} finally {
			try {
				if (dis != null)dis.close();
				if (fis != null)fis.close();
			} catch (IOException e) {}
		}
		if(product.isEmpty()) {
			System.out.println("입력된 재고량이 없습니다.");
		}else {
			for(Product p : product) {
				System.out.println(product);
			}
			System.out.println("이상 물품 "+ product.size()+"가지 입력됨");
			
		}	
	}
}
