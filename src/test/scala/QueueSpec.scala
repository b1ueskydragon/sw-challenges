import org.scalatest.{FunSpec, Matchers}

class QueueSpec extends FunSpec with Matchers {

  describe("isEmpty") {

    it("should return true if emptyQueue is empty") {
      val queue = Queue()
      assert(queue.isEmpty)
    }

    it("should return false if emptyQueue is not empty") {
      val queue = Queue(2, 3, 5)
      assert(!queue.isEmpty)
    }

  }

  describe("enQueue") {

    it("should return a new Queue that added an element on last") {
      val expected = Queue(2, 3, 5, 7, 9)
      val actual = Queue(2, 3, 5, 7).enQueue(9)
      assert(expected === actual)
    }

  }

  describe("deQueue") {

    it("should return a new Queue that removed an element at the beginning") {
      val expected = Queue(3, 5, 7, 9)
      val actual = Queue(2, 3, 5, 7, 9).deQueue
      assert(expected === actual)
    }

  }

  describe("head") {

    it("should return a front optional value if exist") {
      assert(Some(2) === Queue(2, 3, 5, 7).head)
    }

    it("should return a none if emptyQueue is empty") {
      assert(None === Queue().head)
    }

  }

}
