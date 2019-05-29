import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableQueueSpec {

  private final ImmutableQueue<Integer> emptyQueue = new ImmutableQueueImpl<>();
  private final ImmutableQueue<Integer> queue = new ImmutableQueueImpl<>(2, 3, 5);

  @Test
  void testIsEmpty() {
    assertTrue(emptyQueue.isEmpty());
  }

  @Test
  void testIsEmpty_noneEmpty() {
    assertFalse(queue.isEmpty());
  }

  @Test
  void testHead() {
    assertEquals(2, (int) queue.head());
  }

  @Test
  void testHead_throwsException() {
    assertThrows(IndexOutOfBoundsException.class, emptyQueue::head);
  }

  @Test
  void testEnQueue_and_DeQueue_immutable() {
    ImmutableQueue<Integer> q1 = queue.enQueue(7);
    ImmutableQueue<Integer> q2 = q1.deQueue();
    ImmutableQueue<Integer> q3 = q2.deQueue();
    ImmutableQueue<Integer> q4 = q3.deQueue();

    assertEquals(7, (int) q4.head());
    assertEquals(2, (int) queue.head());
  }

}
