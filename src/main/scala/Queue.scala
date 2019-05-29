trait Queue[T] {

  def isEmpty: Boolean

  def enQueue(t: T): Queue[T]

  def deQueue: Queue[T]

  def head: Option[T]

}

case class QueueImpl[T](inputStack: List[T], cachedQueue: List[T]) extends Queue[T] {

  override def isEmpty: Boolean = inputStack.isEmpty && cachedQueue.isEmpty

  override def enQueue(t: T): Queue[T] = QueueImpl(t :: inputStack, cachedQueue)

  override def deQueue: Queue[T] = (inputStack, cachedQueue) match {
    case (Nil, Nil) => throw new IllegalArgumentException
    case (Nil, c) => QueueImpl(inputStack, c.tail)
    case (i, c) => QueueImpl(c, i.reverse.tail)
  }

  override def head: Option[T] =
    if (cachedQueue.isEmpty) inputStack.lastOption else cachedQueue.headOption

}

object Queue {

  def apply[T](ts: T*): Queue[T] = QueueImpl[T](Nil, ts.toList)

  def empty[T]: Queue[T] = QueueImpl(Nil, Nil)

}