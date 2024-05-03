package amazoninterview

class Q1 {
}



//You need to build a purchase validation system for
//an e-commerce website.
//
//Clients need to know which rules were violated so they
//can take actions to fix the purchase.
//
//
//Implement a validate method that takes a Purchase input and returns a list of Violation output. The client can call this method to know which rules were violated so that they can take actions to fix the purchase. The following uses Java for example. You can use any language you prefer.
//
//
//public List<Violation> validate(Purchase purchase) {
//  //add code
//}
//
//Method input:
//
//@Data //Generates getters and setters
//class Purchase {
//  private PaymentInstrument paymentInstrument;
//  private List<Item> items;
//  private String deliveryAddressId;
//}
//
//@Data //Generates getters and setters
//class Item {
//  private String id;
//  private String category; // category: could be "“GiftCard”"
//  private double cost;
//}
//
//@Data //Generates getters and setters
//class PaymentInstrument {
//  private String id;
//  private String type; // type: “CreditCard” or “GiftCard”
//}
//
//Method output: you can define your Violation model that suffices the need to conveying information about rule violations to the client.
//
//Method business logic:
//
//Implementing the validation logic in the method that check the following rules:
//
//The payment instrument type must be valid
//There must be at least one item in the purchase
//The delivery address id must be set
//
//I am looking for how we can easily add more rules without too much code change.



data class Violation(
  val message: String,
)


interface ViolationChecker {
  /**
  To check the given purchase object contains any violation.
   */
  fun check(purchase: Purchase): List<Violation>
}

object PaymentInstrumentChecker: ViolationChecker {
  private val validType = setOf("CreditCard", "GiftCard")


  /**
  The payment instrument type must be valid.
   */
  override fun check(purchase: Purchase): List<Violation> {
    if (null == purchase.getPaymentInstrument()) {
      return listOf(Violation("Payment Instrument is required"))
    }

    if (null == purchase.getPaymentInstrument().getType()) {
      return listOf(Violation("Payment Instrument type is required"))
    }

    if (!this.validType.contains(purchase.getPaymentInstrument().getType())) {
      return listOf(Violation("The payment instrument type must be valid"))
    }

    return listOf()
  }
}

object ItemsChecker: ViolationChecker {
  /**
  To check the given purchase object contains any violation.
   */
  override fun check(purchase: Purchase): List<Violation> {
    if (null == purchase.getItems() || purchase.getItems().isEmpty()) {
      return listOf(Violation("There must be at least one item in the purchase"))
    }

    return listOf()
  }
}

object DeliveryAddressChecker: ViolationChecker {
  /**
  To check the given purchase object contains any violation.
   */
  override fun check(purchase: Purchase): List<Violation> {
    if (null == purchase.getDeliveryAddressId() || purchase.getDeliveryAddressId().isBlank()) {
      return listOf(Violation("The delivery address id must be set"))
    }

    return listOf()
  }
}

object ViolationExecutor {
  private val checkers = listOf(PaymentInstrumentChecker, ItemsChecker, DeliveryAddressChecker)

  fun validate(purchase: Purchase): List<Violation> {
    val result = mutableListOf<Violation>()
    for (checker in this.checkers) {
      result.addAll(checker.check(purchase))
    }
    return result
  }
}

fun main() {
  // ... 
  val purchase = Purchase() // ...
}


