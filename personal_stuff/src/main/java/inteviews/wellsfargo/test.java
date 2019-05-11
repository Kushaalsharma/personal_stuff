package inteviews.wellsfargo;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {

	public static void main(String[] args) {
		System.out.println("hello world");

			System.out.println("1");
			synchronized (args) {

				System.out.println("2");
				try {
					args.wait();
				}
				catch (Exception e) {
					System.out.println("3");}
			}
	}

}
