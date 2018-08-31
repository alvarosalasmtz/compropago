package mx.com.interware.compropago.command

/**
 * Created by developer on 01/08/16.
 */
class ChargeResponse {
    String id
    String short_id
    String object
    String status
    Long created
    Long exp_date
    Boolean live_mode
    Order order_info
    FeeDetails fee_details
    Instructions instructions
    String api_version
    String message
    String type
}

class Order {
    String order_id
    String order_name
    String order_price
    String image_url
    String exchange
}

class FeeDetails {
    String amount
    String tax
    Integer tax_percent
    String currency
    String type
    String description
    Integer amount_refunded
}

class Instructions {
    String description
    String step_1
    String step_2
    String step_3
    String note_extra_comition
    String note_expiration_date
    String note_confirmation
    Details details
}

class Details {
    String payment_amount
    String payment_store
    String amount
    String store
    String bank_account_number
    String bank_name
    String bank_account_holder_name
    String bank_reference
    String company_bank_number
    String company_reference_name
    String company_reference_number
    String order_reference_number
}
