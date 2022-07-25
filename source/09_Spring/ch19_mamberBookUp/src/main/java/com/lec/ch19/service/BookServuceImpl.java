package com.lec.ch19.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dao.BookDAO;
import com.lec.ch19.model.Book;
import com.lec.ch19.util.Paging;

@Service
public class BookServuceImpl implements BookService {
	
	@Autowired
	private BookDAO bookdao;
	String backupPath = "D:\\webProDK\\source\\09_Spring\\ch19_mamberBookUp\\src\\main\\webapp\\bookImgFileUpload";
	
	@Override
	public List<Book> mainList() {
		return bookdao.mainList();
	}

	@Override
	public List<Book> bookList(String pageNum) {
		Paging paging = new Paging(bookdao.totCntBook(), pageNum, 3, 3); 
		Book book = new Book();
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		return bookdao.bookList(book);
	}

	@Override
	public int totCntBook() {
		return bookdao.totCntBook();
	}

	@Override
	public Book getDetailBook(int bnum) {
		return bookdao.getDetailBook(bnum);
	}

	@Override
	public int registerBook(Book book, MultipartHttpServletRequest mReques) {
		String uploadPath = mReques.getRealPath("bookImgFileUpLoad/");
		Iterator<String> params = mReques.getFileNames(); // tempBimg1, tempBimg2
		String[] bimg = {"",""}; /* new String [2]*/
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mReques.getFile(param); // 파라미터에 첨부된 파일 객체
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx] != null && !bimg[idx].equals("")) {// 첨부함
				if(new File(uploadPath+bimg[idx]).exists()) {
					//new file??
					//첨부한 파일과 같은 이름의 파일이 서버에 이미 저장된 경우					
					bimg[idx] = System.currentTimeMillis()+"_"+bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));//서버에 저장
					System.out.println("서버파일 : "+uploadPath + bimg[idx]);
					System.out.println("백업파일 : "+backupPath + bimg[idx]);
					boolean result = filecopy(uploadPath + bimg[idx], backupPath+bimg[idx]);
					System.out.println(result==true? idx + "번째 백업성공":idx+"번째 백업 실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}else {
				//파일첨부 안하면 bimg[idx] = ""
				bimg[idx] = ""; //안해도됨?
			}
			idx++;
		}//whlie
		book.setBimg1(bimg[0]); 
		book.setBimg2(bimg[1]);
		return bookdao.registerBook(book);
	}

	
	
	
	@Override
	public int modifyBook(Book book, MultipartHttpServletRequest mReques) {
		String uploadPath = mReques.getRealPath("bookImgFileUpLoad/");
		Iterator<String> params = mReques.getFileNames(); // tempBimg1, tempBimg2
		String[] bimg = {"",""}; /* new String [2]*/
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mReques.getFile(param); // 파라미터에 첨부된 파일 객체
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx] != null && !bimg[idx].equals("")) {// 첨부함
				
				if(new File(uploadPath+bimg[idx]).exists()) {
					//new file??
					//첨부한 파일과 같은 이름의 파일이 서버에 이미 저장된 경우					
					bimg[idx] = System.currentTimeMillis()+"_"+bimg[idx];
				}
				
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));//서버에 저장
					System.out.println("서버파일 : "+uploadPath + bimg[idx]);
					System.out.println("백업파일 : "+backupPath + bimg[idx]);
					boolean result = filecopy(uploadPath + bimg[idx], backupPath+bimg[idx]);
					System.out.println(result==true? idx + "번째 백업성공":idx+"번째 백업 실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}else {
				//파일첨부 안하면 bimg[idx] = ""
				bimg[idx] = ""; //안해도됨?
			}
			idx++;
		}//whlie
		
		book.setBimg1(bimg[0]); 
		book.setBimg2(bimg[1]);
		
		return bookdao.modifyBook(book);

	}

	private boolean filecopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		FileInputStream is = null; 
		OutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(serverFile);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int)file.length()];
			
			while(true) {
				int nReadByte = is.read(buff);
				if(nReadByte == -1)break;
				os.write(buff, 0, nReadByte);
			}
			isCopy = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return isCopy;
	}
}




















