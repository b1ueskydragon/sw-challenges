import org.scalatest.{FunSpec, Matchers}

class QueueSpec extends FunSpec with Matchers {

  describe("apply") {

    it("should apply variable argument to List") {
      assert(Queue(2, 3, 5, 7, 11) === QueueImpl(Nil, List(2, 3, 5, 7, 11)))
    }

  }

  describe("isEmpty") {

    it("should return true if queue is empty") {
      val queue = Queue()
      assert(queue.isEmpty)
    }

    it("should return false if queue is not empty") {
      val queue = Queue(2, 3, 5)
      assert(!queue.isEmpty)
    }

  }

  describe("head") {

    it("should return a front optional value if exist") {
      assert(Some(2) === Queue(2, 3, 5, 7).head)
    }

    it("should return a none if queue is empty") {
      assert(None === Queue().head)
    }

  }

  describe("enQueue and deQueue") {

    it("enQueue add a element at last, and deQueue pop a front value") {
      val q0: Queue[Int] = Queue()
      val q1 = q0.enQueue(2)
      assert(Some(2) === q1.head)
    }

    it("should not change initial state") {
      val q0: Queue[Int] = Queue()

      assert(None === q0.head)

      val q1 = q0.enQueue(2)
      val q2 = q1.enQueue(3)

      assert(None === q0.head)

      assert(Some(3) === q2.deQueue.head)
      assert(Some(2) === q2.head)
    }

    it("should throw IllegalArgumentException when deQueue an empty Queue") {
      intercept[IllegalArgumentException] {
        val queue = Queue()
        queue.deQueue
      }
    }

  }

}
