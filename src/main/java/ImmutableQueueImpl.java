import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImmutableQueueImpl<T> implements ImmutableQueue<T> {

  private List<T> queue;

  public ImmutableQueueImpl() {
    this.queue = new ArrayList<>();
  }

  @SafeVarargs
  public ImmutableQueueImpl(T...ts) {
    this.queue = Arrays.asList(ts);
  }

  @Override
  public ImmutableQueue<T> enQueue(T t) {
    return null;
  }

  @Override
  public ImmutableQueue<T> deQueue() {
    return null;
  }

  @Override
  public T head() {
    return null;
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

}