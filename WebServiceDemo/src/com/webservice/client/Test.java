
package com.webservice.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Test", targetNamespace = "http://server.webservice.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Test {


    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "squared", targetNamespace = "http://server.webservice.com/", className = "com.webservice.client.Squared")
    @ResponseWrapper(localName = "squaredResponse", targetNamespace = "http://server.webservice.com/", className = "com.webservice.client.SquaredResponse")
    @Action(input = "http://server.webservice.com/Test/squaredRequest", output = "http://server.webservice.com/Test/squaredResponse")
    public int squared(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}