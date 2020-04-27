
package com.webservice.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.webservice.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SquaredResponse_QNAME = new QName("http://server.webservice.com/", "squaredResponse");
    private final static QName _Squared_QNAME = new QName("http://server.webservice.com/", "squared");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.webservice.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Squared }
     * 
     */
    public Squared createSquared() {
        return new Squared();
    }

    /**
     * Create an instance of {@link SquaredResponse }
     * 
     */
    public SquaredResponse createSquaredResponse() {
        return new SquaredResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SquaredResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.com/", name = "squaredResponse")
    public JAXBElement<SquaredResponse> createSquaredResponse(SquaredResponse value) {
        return new JAXBElement<SquaredResponse>(_SquaredResponse_QNAME, SquaredResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Squared }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.com/", name = "squared")
    public JAXBElement<Squared> createSquared(Squared value) {
        return new JAXBElement<Squared>(_Squared_QNAME, Squared.class, null, value);
    }

}
