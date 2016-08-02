package mx.com.interware.compropago.services

import groovy.json.JsonSlurper
import mx.com.interware.compropago.command.ChargeRequest
import mx.com.interware.compropago.command.ChargeResponse
import wslite.http.auth.HTTPBasicAuthorization
import wslite.rest.ContentType
import wslite.rest.RESTClient
import wslite.rest.RESTClientException

class ChargeServiceImpl implements ChargeService {

    ChargeResponse create(ChargeRequest charge, String keyUser) {
        def client = new RESTClient('https://api.compropago.com')
        client.authorization = new HTTPBasicAuthorization("${keyUser}:", '')
        def response
        try {
            response = client.post(path: '/v1/charges', accept: ContentType.JSON) { json charge.properties }
        } catch (RESTClientException ex) {
            //response = ex.response
        }
        def jsonSlurper = new JsonSlurper()
        def object = jsonSlurper.parseText(response.contentAsString)
        new ChargeResponse(object)
    }
}
