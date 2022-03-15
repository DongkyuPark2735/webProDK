//.java ==(컴파일java hello..java)==> .class ==실행 java hello 누구 누구==>결과
//
public class Hello {
	public static void main(String[] args) {
		System.out.print("안녕하세요");
		for (int i = 0; i < args.length; i++) {
			System.out.print(", "+ args[i]);
		}
	}
}
