public interface ImmutableQueue<T> {
  ImmutableQueue<T> enQueue(T t);

  //Removes the element at the beginning of the immutable queue, and returns the new queue.
  ImmutableQueue<T> deQueue();

  T head();

  boolean isEmpty();
}