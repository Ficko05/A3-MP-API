/**
 * GeoIPService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package as.ff.nl.a3mpapi.Rest.ipsoapservice;

public interface GeoIPService extends javax.xml.rpc.Service {

/**
 * <b>A web service which performs GetIpAddress Lookups.</b>
 */
    public java.lang.String getGeoIPServiceSoapAddress();

    public as.ff.nl.a3mpapi.Rest.ipsoapservice.GeoIPServiceSoap_PortType getGeoIPServiceSoap() throws javax.xml.rpc.ServiceException;

    public as.ff.nl.a3mpapi.Rest.ipsoapservice.GeoIPServiceSoap_PortType getGeoIPServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getGeoIPServiceSoap12Address();

    public as.ff.nl.a3mpapi.Rest.ipsoapservice.GeoIPServiceSoap_PortType getGeoIPServiceSoap12() throws javax.xml.rpc.ServiceException;

    public as.ff.nl.a3mpapi.Rest.ipsoapservice.GeoIPServiceSoap_PortType getGeoIPServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
