package designpatterns.creational;

class SingletonEagerInit {

	private SingletonEagerInit() {
	}

	/* Eager initialization */
	private static SingletonEagerInit instance = new SingletonEagerInit();

	public static SingletonEagerInit getInstance() {
		return instance;
	}

}

class SingletonLazyInit {
	/* Lazy initialization */
	private static SingletonLazyInit instance = null;

	private SingletonLazyInit() {
	}

	public static SingletonLazyInit getInstance() {
		if (instance == null) {
			instance = new SingletonLazyInit();
		}
		return instance;
	}

}

/* Thread safe ways of Singleton patterns */
/* 1. make method synchronized */
class SingletonLazyThreadsafeInit1 {
	private static SingletonLazyThreadsafeInit1 instance = null;

	private SingletonLazyThreadsafeInit1() {
	}

	public static synchronized SingletonLazyThreadsafeInit1 getInstance() {
		if (instance == null) {
			instance = new SingletonLazyThreadsafeInit1();
		}
		return instance;
	}
}

/* 2. Use synchronized block */
class SingletonLazyinitThreadsafe2 {
	/*
	 * instruct JVM threads to read the value of volatile variable from main memory
	 * and don't cache it locally
	 */ private static volatile SingletonLazyinitThreadsafe2 instance = null;

	private SingletonLazyinitThreadsafe2() {

	}

	public static SingletonLazyinitThreadsafe2 getInstamce() {
		if (instance == null) {
			synchronized (SingletonLazyinitThreadsafe2.class) {
				if (instance == null) {
					instance = new SingletonLazyinitThreadsafe2();
				}
			}
		}
		return instance;
	}
}

class SingletonLazyinitThreadsafe3 {
	private SingletonLazyinitThreadsafe3() {

	}

	private static class ObjSupplier {
		private static final SingletonLazyinitThreadsafe3 instance = new SingletonLazyinitThreadsafe3();
	}

	public static SingletonLazyinitThreadsafe3 getInstance() {
		return ObjSupplier.instance;
	}
}

public class SingletonPattern {

	public static void main(String[] args) {
		SingletonEagerInit eager1 = SingletonEagerInit.getInstance();
		System.out.println(eager1);
		SingletonEagerInit eager2 = SingletonEagerInit.getInstance();
		System.out.println(eager2);

		SingletonLazyInit lazy1 = SingletonLazyInit.getInstance();
		System.out.println(lazy1);
		SingletonLazyInit lazy2 = SingletonLazyInit.getInstance();
		System.out.println(lazy2);

	}

}
