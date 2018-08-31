package mx.com.interware.compropago.services

import mx.com.interware.compropago.command.ChargeRequest
import mx.com.interware.compropago.command.ChargeResponse

/**
 * Created by developer on 01/08/16.
 */
interface ChargeService {

    ChargeResponse create(ChargeRequest charge, String keyUser)

    Map<String, Object> get(String chargeId, String keyUser)

    List<Map> findAll();

    Map findById(String id);

    Map findByName(String name);
}