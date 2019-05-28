trait Queue[T] {

  def isEmpty: Boolean

  def enQueue(t: T): Queue[T]

  // Removes the element at the beginning of the immutable queue and returns the new queue.
  def deQueue: Queue[T]

  def head: Option[T]

}

case class QueueImpl[T](queue: List[T]) extends Queue[T] {

  override def isEmpty: Boolean = queue.isEmpty

  override def enQueue(t: T): Queue[T] = QueueImpl(queue ::: List(t))

  override def deQueue: Queue[T] = QueueImpl(queue.tail)

  override def head: Option[T] = queue.headOption

}

object Queue {

  def apply[T](ts: T*): Queue[T] = QueueImpl[T](ts.toList)

  def empty[T]: Queue[T] = QueueImpl(Nil)

}