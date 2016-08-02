package mx.com.interware.compropago.test.service.unit

import mx.com.interware.compropago.command.ChargeRequest
import mx.com.interware.compropago.command.ChargeResponse
import mx.com.interware.compropago.services.ChargeService
import mx.com.interware.compropago.services.ChargeServiceImpl
import org.junit.Test

/**
 * Created by developer on 02/08/16.
 */
class ChargeServiceUnitTest {

    @Test
    void testCreate() {
        ChargeService chargeService = new ChargeServiceImpl()
        ChargeResponse response = chargeService.create(
                new ChargeRequest([order_id      : "SC${new Date().time}",
                                   order_price   : 99.99,
                                   order_name    : "Esto es una prueba de servicio",
                                   image_url     : "https://test.amazon.com/5f4373",
                                   customer_name : "Test",
                                   customer_email: "${new Date().time}@domain.com",
                                   payment_type  : "OXXO"]),
                "pk_live_735d236103374677ef")
        assert response
    }
}
