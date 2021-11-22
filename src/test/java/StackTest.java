import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

	private MyStack stack;

	@Before
	public void initialize() {
		stack = new MyStack(5);
	}

	// ****************************
	// Methods tests push operation
	// ****************************

	@Test
	public void testPushSuccess() throws Exception {
		int[] expected = { 300, 200, 100 };

		// Act
		stack.push(100);
		stack.push(200);
		stack.push(300);

		// Assert
		for (int i = 0; i < stack.size(); i++) {
			assertEquals(expected[i], stack.top());
			stack.pop();
		}
	}

	@Test(expected = Exception.class)
	public void testPushFail() throws Exception {
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
		stack.push(500);
		stack.push(600);
	}

	// Method to test top operation
	@Test(expected = Exception.class)
	public void testTopFail() throws Exception {
		stack.top();
	}

	// Method to test pop operation
	@Test(expected = Exception.class)
	public void testPopFail() throws Exception {
		stack.pop();
	}
}