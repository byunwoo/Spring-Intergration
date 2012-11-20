package test;
public class ThreadTest {
	public static void main( String[] args ) {
        System.out.println( "프로그램 시작" );
        ThdClass t = new ThdClass(); // 3. run() 메서드를 포함한 클래스의 생성
        Thread thd = new Thread( t ); // 4. 3번에서 생성된 클래스를 초기 인자로 하여 스레드 객체를 생성한다.
        thd.start(); // 5. 스레드 객체의 start() 메서드를 이용하여 스레드 시작.
        System.out.println( "프로그램 종료" );
    }
}
