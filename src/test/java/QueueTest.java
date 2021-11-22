import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {

	private Queue queue;

	@Before
	public void initialize() {
		queue = new Queue(5);
	}

	// *********************************
	// Methods to test enqueue operation
	// *********************************

	@Test
	public void testEnqueueSuccess() throws Exception {
		int[] expected = { 100, 200, 300, 400 };

		// Act
		queue.enqueue(100);
		queue.enqueue(200);
		queue.enqueue(300);
		queue.enqueue(400);

		// Assert
		for (int i = 0; i < queue.sizeofQueue; i++) {
			assertEquals(expected[i], queue.dequeue());
		}
	}

	@Test(expected = Exception.class)
	public void testEnqueueFail_1() throws Exception {
		queue.enqueue(100);
		queue.enqueue(200);
		queue.enqueue(300);
		queue.enqueue(400);
		queue.enqueue(500);
		queue.enqueue(600);
	}

	@Test(expected = Exception.class)
	public void testEnqueueFail_2() throws Exception {
		queue.enqueue(100);
		queue.enqueue(200);
		queue.enqueue(300);
		queue.enqueue(400);
		queue.enqueue(500);
		queue.dequeue();
		queue.enqueue(600);
		queue.enqueue(700);
	}

	// *********************************
	// Methods to test dequeue operation
	// *********************************

	@Test
	public void testDequeueSuccess() throws Exception {
		queue.enqueue(100);
		queue.enqueue(200);
		queue.enqueue(300);
		queue.enqueue(400);
		queue.enqueue(500);

		// Act and assert
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(600);
		assertFalse(queue.empty());
		queue.dequeue();
		assertTrue(queue.empty());
		assertEquals(0, queue.size());
	}

	@Test(expected = Exception.class)
	public void testDequeueFail() throws Exception {
		queue.dequeue();
	}
}