package server.commons.rows;

import java.util.concurrent.LinkedBlockingQueue;

import server.commons.domain.GenericCommand;

public class RowF3 {
	
	private static volatile LinkedBlockingQueue<GenericCommand> f3 = new LinkedBlockingQueue<>();
	
	public static LinkedBlockingQueue<GenericCommand> getFifo() {
		return f3;
	}
	
	public static synchronized void addItem(GenericCommand item) {
		f3.offer(item);
	}
}
