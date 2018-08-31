package mx.com.interware.compropago.services

import groovy.json.JsonSlurper
import mx.com.interware.compropago.command.ChargeRequest
import mx.com.interware.compropago.command.ChargeResponse

import wslite.http.auth.HTTPBasicAuthorization
import wslite.rest.ContentType
import wslite.rest.RESTClient
import wslite.rest.RESTClientException

class ChargeServiceImpl implements ChargeService {

    @Override
    ChargeResponse create(ChargeRequest charge, String keyUser) {
        def client = new RESTClient('http://api.compropago.com')
        client.authorization = new HTTPBasicAuthorization("${keyUser}:", '')
        def response
        try {
            response = client.post(path: '/v1/charges', accept: ContentType.JSON) { json charge.properties }
        } catch (RESTClientException ex) {
            ex.printStackTrace()
            return null;
        }
        def jsonSlurper = new JsonSlurper()
        def object = jsonSlurper.parseText(response.contentAsString)
        new ChargeResponse(object)
    }

    @Override
    Map<String, Object> get(String chargeId, String keyUser) {
        def client = new RESTClient('http://api.compropago.com')
        client.authorization = new HTTPBasicAuthorization("${keyUser}:", '')
        def response
        try {
            response = client.get(path: "/v1/charges/${chargeId}", query:[:])
        } catch (RESTClientException ex) {
            System.println("ERROR: ${ex.getMessage()}");
            ex.printStackTrace()
            return null;
        }
        new JsonSlurper().parseText(response.contentAsString)
    }

    @Override
    List<Map> findAll() {
        def client = new RESTClient('http://api.compropago.com')
        def response
        try {
            response = client.get(path: '/v1/providers/true', query:[:])
        } catch (RESTClientException ex) {
            ex.printStackTrace()
            return null;
        }
        def jsonSlurper = new JsonSlurper()
        def object = jsonSlurper.parseText(response.contentAsString)
        List<Map> list = new ArrayList<>()
        object.each {
            list.add([idForma: it.internal_name, nombre: it.name, url: it.image_medium])
        }
        list
    }

    @Override
    Map findById(String id) {
        return findAll().find {it.idForma == id}
    }

    @Override
    Map findByName(String name) {
        return findAll().find {it.nombre == name}
    }
}
