package stream.copy;
/*
파일을 복사해본다 
■ Stream 이란? 
	- 강의 지류, 물줄기 등 흐르는 물을 의미 
	- 컴퓨터 분야에서는 물의 흐름이 아닌 데이터의 흐름을 의미한다 
■ 방향성에 따른 구분 (IO)
	- Input(입력) : 실행중인 프로그램으로 데이터가 들어오는 모습
	- Output(출력) : 실행중인 프로그램에서 데이터가 나가는 모습 
*/
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;//파일없으면 어떡할래 예외
import java.io.IOException; //읽거나 쓸때 발생이 예상되는 예외

public class ImageCopy {
	FileInputStream fis; //파일을 대상으로 한 입력스트림 객체 
						//이 클래스를 이용하면 실행중인 자바 프로그램으로 파일을 이루고 
						//있는 바이트 데이터들을 읽어 마실 수 있다
	FileOutputStream fos;//파일을 대상으로 한 출력스트림 객체 
									//이 클래스를 이용하면, 실행중인 자바 프로그램에서 지정한 파일로
									//바이트 데이터를 출력할 수 있다(쓰기)

	//String filename="D:/java_workspace/app0307/res/RetroMario.webp";
	String filename="D:/java_workspace/app0307/res/fruit.txt";
	String destname="D:/java_workspace/app0307/res/fruit_copy.txt";

	public ImageCopy(){
		/*
		문법적으로 문제가 없다 하여, 언제나 안전한 실행을 보장하는 게 아니다. 
		프로그램의 정상 수행을 방해하는 요인을 예외(Exception)라 한다.

		프로그램의 정상 수행을 방해하는 요인은 크게 2가지가 있다.
		1) 에러 : 사람인 개발자가 감당할 수 없는 경우(예) 전기나감, cpu타버림, 네트워크 끊음)
					이러한 에러들은 프로그램의 관심 대상이 X
		2) 예외 : 프로그래머가 복구할순 없지만, 프로그램의 비정상적 흐름을 정상 흐름으로 돌려놓을 수 있슴
		*/
		

		//비정상 수행이 예상되는 코드에 try문으로 감싼 후, 우려가 되었던 상황이 발생하면 
		//프로그램의 비정상 수행을 방치하는 것이 아니라, catch문으로 실행부를 진입시켜 
		//알맞는 처리를 할수있도록 지원하는 기술이 예외처리이다.
		try{
			fis = new FileInputStream(filename);//파일에 대해 빨대 꽂기	

			//주의) 파일출력스트림은 객체 인스턴스 생성 시, 빈(empty) 파일을 자동으로 생성해 버린다
			fos = new FileOutputStream(destname);

			System.out.println("파일에 대한 입력스트림 성공");
			//우려했던 상황이 발생하면, jvm이 해당 예외에 대한 정보를 객체 인스턴스로 생성하여 
			//아래의 catch 문의 매개변수로 전달해준다..이때 개발자는 이 객체를 이용하여 적절한 
			//예외 처리를 수행하면 된다..
			//아주 중대하다고 판단되는 예외 상황은 sun 이미 결정해 놓았으므로, 개발자는 컴파일시
			//컴파일러의 안내에 따라 적절한 예외 처리를 하면 된다.
			int data=-1;

			while(true){
				data = fis.read(); //1byte 읽기
				if(data==-1){ //데이터를 읽어들일때 음수가 나오면 파일에 저장된 데이터의 끝에 도달했다는 의미
					break;//현재 진행중인 루프를 빠져나오는 명령
				};//파일의 끝에 도달하면 현재 루프를 빠져나오기
				
				//System.out.print((char)data);

				//읽어들인 바이트 데이터를 출력 대상이 되는 파일에 내려쓰자
				fos.write(data); //1 byte 내려쓰기
			}

		}catch(FileNotFoundException e){
			System.out.println("파일의 경로를 확인해주세요");
		}catch(IOException e){
			System.out.println("데이터 입출력 실패");
		}finally{//try, catch 문이건 무조건 finally 문으로 진입을 시도한다 
			//sun에서는 스트림을 close()할때도 예외 처리를 강요
			//close() 반납은 해당 스트림이 메모리에 올라왔을 때문 수행해 -> null이 아닐때만 수행
			if(fis != null){
				try{
					fos.close();
				}catch(IOException e){
					e.printStackTrace; //에러의 원인을 스택구조로 출력
					//일반 유저들을 위한 메시지x, 콘솔에 출력 주로 엔지어들을 위한 에러메시지 출력
					}
			}
			if(fos != null){
				try{
					fis.close();
				}catch(IOException e){
					e.printStackTrace;
					System.out.print("잠시 후 다시 이용해주세요\n");
				}
			}
	}

	public static void main(String[] args) {
		new ImageCopy();
	}
}