package seshop.com.sds.seshop.lib;

//파일과 관련한 유요한 기능들을 지원하는 나만의 클래스
public class FileManager {
	
	public static String getExt(String filename) {	
		//선택한 파일에서 "."까지 이전 문자열은 지우고 반환
		String ext =filename.substring(filename.lastIndexOf(".")+1,filename.length() ); //확장자
		System.out.println("확장자는 "+ext);
		
		return ext; //확장자 명 반환
	}

}
