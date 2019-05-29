import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableQueueImpl<T> implements ImmutableQueue<T> {

  private final List<T> queue;

  private ImmutableQueueImpl(List<T> queue) {
    this.queue = queue;
  }

  public ImmutableQueueImpl() {
    queue = new ArrayList<>();
  }

  @SafeVarargs
  public ImmutableQueueImpl(T... ts) {
    List<T> newQueue = new ArrayList<>();
    Collections.addAll(newQueue, ts);
    queue = newQueue;
  }

  @Override
  public ImmutableQueue<T> enQueue(T t) {
    List<T> newQueue = new ArrayList<>(queue);
    newQueue.add(t);
    return new ImmutableQueueImpl<>(newQueue);
  }

  @Override
  public ImmutableQueue<T> deQueue() {
    return new ImmutableQueueImpl<>(queue.subList(1, queue.size()));
  }

  @Override
  public T head() {
    if (queue.isEmpty()) throw new IndexOutOfBoundsException();
    return queue.get(0);
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

}
