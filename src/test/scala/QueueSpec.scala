import org.scalatest.{FunSpec, Matchers}

class QueueSpec extends FunSpec with Matchers {

  describe("isEmpty") {

    it("should return true if queue is empty") {
      val queue = Queue()
      val jQueue = new ImmutableQueueImpl[Int]

      assert(queue.isEmpty)
      assert(jQueue.isEmpty)
    }

    it("should return false if queue is not empty") {
      val queue = Queue(2, 3, 5)
      val jQueue = new ImmutableQueueImpl[Int](2, 3, 5)

      assert(!queue.isEmpty)
      assert(!jQueue.isEmpty)
    }

  }

  describe("enQueue") {

    it("should return a new Queue that added an element on last") {
      val expected = Queue(2, 3, 5, 7, 9)
      val actual = Queue(2, 3, 5, 7).enQueue(9)
      assert(expected === actual)

      // TODO jQueue, confirm is `new`
    }

  }

  describe("deQueue") {

    it("should return a new Queue that removed an element at the beginning") {
      val expected = Queue(3, 5, 7, 9)
      val actual = Queue(2, 3, 5, 7, 9).deQueue
      assert(expected === actual)

      // TODO jQueue, confirm is `new`
    }

  }

  describe("head") {

    it("should return a front optional value if exist") {
      assert(Some(2) === Queue(2, 3, 5, 7).head)
    }

    it("should return a front value if exist"){
      val jQueue = new ImmutableQueueImpl[Int](2, 3, 5)
      assert(2 === jQueue.head())
    }

    it("should return a none if queue is empty") {
      assert(None === Queue().head)
    }

    it("should be exception if queue is empty"){
      val jQueue = new ImmutableQueueImpl[Int]
      intercept[IndexOutOfBoundsException] {
        jQueue.head()
      }
    }

  }

}
