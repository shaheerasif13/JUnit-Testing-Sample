import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	private LinkedList linkedList;

	@Before
	public void initialize() {
		linkedList = new LinkedList();
	}

	// Method to test push front
	@Test
	public void testPushFront() {
		int[] expected = { 100, 200, 300, 400 };

		// Act
		LinkedList.pushFront(400);
		LinkedList.pushFront(300);
		LinkedList.pushFront(200);
		LinkedList.pushFront(100);

		// Assert
		for (int i = 0; i < LinkedList.size; i++) {
			assertEquals(expected[i], LinkedList.head.key);
			LinkedList.head = LinkedList.head.next;
		}
	}

	// Method to test push back
	@Test
	public void testPushBack() {
		int[] expected = { 100, 200, 300, 400 };

		// Act
		LinkedList.pushBack(100);
		LinkedList.pushBack(200);
		LinkedList.pushBack(300);
		LinkedList.pushBack(400);

		// Assert
		for (int i = 0; i < LinkedList.size; i++) {
			assertEquals(expected[i], LinkedList.head.key);
			LinkedList.head = LinkedList.head.next;
		}
	}

	// *************************
	// Methods to test pop front
	// ************************

	@Test
	public void testPopFront() {
		int[] expected = { 300, 400 };

		LinkedList.pushBack(100);
		LinkedList.pushBack(200);
		LinkedList.pushBack(300);
		LinkedList.pushBack(400);

		// Act
		LinkedList.popFront();
		LinkedList.popFront();

		// Assert
		for (int i = 0; i < LinkedList.size; i++) {
			assertEquals(expected[i], LinkedList.head.key);
			LinkedList.head = LinkedList.head.next;
		}
	}

	@Test
	public void testPopFrontIfListEmpty() {

		// Act
		LinkedList.popFront();

		// Assert
		assertEquals(0, LinkedList.size);
		assertNull(LinkedList.head);
	}

	// ************************
	// Methods to test pop back
	// ************************

	@Test
	public void testPopBack() {
		int[] expected = { 100, 200 };

		LinkedList.pushBack(100);
		LinkedList.pushBack(200);
		LinkedList.pushBack(300);
		LinkedList.pushBack(400);

		// Act
		LinkedList.popBack();
		LinkedList.popBack();

		// Assert
		for (int i = 0; i < LinkedList.size; i++) {
			assertEquals(expected[i], LinkedList.head.key);
			LinkedList.head = LinkedList.head.next;
		}
	}

	@Test
	public void testPopBackIfListEmptyOrHasOneElement() {

		LinkedList.pushBack(100);

		// Act
		LinkedList.popBack();
		LinkedList.popBack();

		// Assert
		assertEquals(0, LinkedList.size);
		assertNull(LinkedList.head);
	}

	// ******************************************
	// Methods to test pop from specific position
	// ******************************************

	@Test
	public void testPop() {
		int[] expected = { 200, 500, 600 };

		LinkedList.pushBack(100);
		LinkedList.pushBack(200);
		LinkedList.pushBack(300);
		LinkedList.pushBack(400);
		LinkedList.pushBack(500);
		LinkedList.pushBack(600);

		// Act
		LinkedList.pop(0);
		LinkedList.pop(1);
		LinkedList.pop(1);
		LinkedList.pop(10); // Invalid

		// Assert
		for (int i = 0; i < LinkedList.size; i++) {
			assertEquals(expected[i], LinkedList.head.key);
			LinkedList.head = LinkedList.head.next;
		}
	}

	@Test
	public void testPopIfListEmpty() {

		// Act
		LinkedList.pop(0);

		// Assert
		assertEquals(0, LinkedList.size);
		assertNull(LinkedList.head);
	}
}