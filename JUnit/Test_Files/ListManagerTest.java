package junit;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest extends TestCase {
    ListManager manager = new ListManager();

    public void testAddElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 5);
        assertEquals(1, list.size());
        assertTrue(list.contains(5));
    }

    public void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        manager.removeElement(list, 5);
        assertFalse(list.contains(5));

    }

    public void testGetSize() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        assertEquals(1, manager.getSize(list));

    }

}