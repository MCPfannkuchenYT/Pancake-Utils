package de.pancakeutils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * All Thread based Utils
 * @author Pancake
 */
public final class Threading {

	/**
	 * Makes the current thread sleep for a given amount of milliseconds
	 * @param milliseconds Milliseconds to sleep for
	 * @return Whether the sleep was interrupted or not
	 */
	public static final boolean sleep(final long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Runs a runnable in a safe environment catching exceptions without reporting them
	 * @param run Runnable to run
	 * @return Whether the Runnable was executed without exceptions
	 */
	public static final boolean runSafe(final Callable<Boolean> run) {
		try {
			return run.call();
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Runs a consumer in a multithreaded environment with it's index given as parameter
	 * @param task Task to be executed
	 * @param threads Threads to use
	 * @param calls Amount of calls for function
	 * @throws Throws InterruptedException when the current thread has been interrupted
	 */
	public static final void multithreadTask(final Consumer<Integer> task, final int threads, final int calls) throws Exception {
		final ExecutorService service = Executors.newFixedThreadPool(threads);
		for (int i = 0; i < calls; i++) {
			final int call = i;
			service.submit(() -> task.accept(call));
		}
		service.shutdown();
		service.awaitTermination(365L, TimeUnit.DAYS);
	}
	
}
