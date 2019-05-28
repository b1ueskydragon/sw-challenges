import org.scalatest.{FunSpec, Matchers}

class QueueSpec extends FunSpec with Matchers {

  describe("isEmpty") {

    it("should return true if queue is empty") {
      val queue = MyQueue(Nil)
      assert(queue.isEmpty)
    }

    it("should return false if queue is not empty") {
      val queue = MyQueue(List(1, 3, 5, 7, 11))
      assert(!queue.isEmpty)
    }

  }

}
