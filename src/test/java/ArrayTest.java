import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest {

	private Array array;

	@Before
	public void initialize() {
		array = new Array();
	}

	// Method to test insertion in array
	@Test
	public void testInsert() {
		int[] expected = { 100, 200, 300, 400 };

		// Act
		Array.insert(100, 0);
		Array.insert(300, 1);
		Array.insert(400, 2);
		Array.insert(200, 1);

		// Assert
		for (int i = 0; i < Array.size; i++) {
			assertEquals(expected[i], Array.array[i]);
		}
	}

	// Method to test deletion in array
	@Test
	public void testDelete() {
		int[] expected = { 100, 200, 400 };

		Array.insert(100, 0);
		Array.insert(300, 1);
		Array.insert(400, 2);
		Array.insert(200, 1);

		// Act
		Array.delete(2);

		// Assert
		for (int i = 0; i < Array.size; i++) {
			assertEquals(expected[i], Array.array[i]);
		}
	}

	// *****************************
	// Methods to test linear search
	// *****************************

	@Test
	public void testLinearSearchSuccess() {
		int key = 200;

		Array.insert(100, 0);
		Array.insert(300, 1);
		Array.insert(400, 2);
		Array.insert(200, 1);

		// Act
		boolean found = Array.linearSearch(key);

		// Assert
		assertTrue(found);
	}

	@Test
	public void testLinearSearchFail() {
		int key = -1;

		Array.insert(100, 0);
		Array.insert(300, 1);
		Array.insert(400, 2);
		Array.insert(200, 1);

		// Act
		boolean found = Array.linearSearch(key);

		// Assert
		assertFalse(found);
	}

	// Method to test bubble sort
	@Test
	public void testBubbleSort() {
		int[] expected = { 100, 200, 300, 400, 500 };

		Array.insert(500, 0);
		Array.insert(200, 1);
		Array.insert(400, 2);
		Array.insert(300, 3);
		Array.insert(100, 4);

		// Act
		Array.bubbleSort();

		// Assert
		for (int i = 0; i < Array.size; i++) {
			assertEquals(expected[i], Array.array[i]);
		}
	}

	// *****************************
	// Methods to test binary search
	// *****************************

	@Test
	public void testBinarySearchSuccess() {
		int key = 800;

		Array.insert(100, 0);
		Array.insert(200, 1);
		Array.insert(300, 2);
		Array.insert(400, 3);
		Array.insert(500, 4);
		Array.insert(600, 5);
		Array.insert(700, 6);
		Array.insert(800, 7);
		Array.insert(900, 8);
		Array.insert(1000, 9);

		boolean found = Array.binarySearch(key, 0, Array.size - 1);

		assertTrue(found);
	}

	@Test
	public void testBinarySearchFail() {
		int key = 10;

		Array.insert(100, 0);
		Array.insert(200, 1);
		Array.insert(300, 2);
		Array.insert(400, 3);
		Array.insert(500, 4);
		Array.insert(600, 5);
		Array.insert(700, 6);
		Array.insert(800, 7);
		Array.insert(900, 8);
		Array.insert(1000, 9);

		boolean found = Array.binarySearch(key, 0, Array.size - 1);

		assertFalse(found);
	}
}