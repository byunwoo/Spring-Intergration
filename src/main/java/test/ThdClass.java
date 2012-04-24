package test;

public class ThdClass implements Runnable { // 1. Runnable 인터페이스를 상속 받는다.
    public void run() { // 2. 해당 클래스에 run() 메서드를 구현한다.
        for ( int i=0; i<50; i++ ) {
            System.out.println( i + "\t" );
        }
    }
}
