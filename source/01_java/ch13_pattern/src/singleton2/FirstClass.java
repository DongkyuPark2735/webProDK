package singleton2;


public class FirstClass {
	public FirstClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();//°´Ã¼´Â »ç¶óÁöÁö¾Ê°í //
		System.out.println("½Ì±ÛÅæ °´Ã¼ÀÇ i°ª :" + singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("½Ì±ÛÅæ °´Ã¼ÀÇ i°ª ¼öÁ¤ÈÄ" + singletonObject.getI());
		
	}
}
