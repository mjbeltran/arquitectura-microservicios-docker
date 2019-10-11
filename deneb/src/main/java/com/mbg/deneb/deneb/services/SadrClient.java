package com.mbg.deneb.deneb.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.client.RestTemplate;

import com.mbg.model.PingRequest;
import com.mbg.model.PingResponse;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@ConfigurationProperties(prefix="sadr")
public class SadrClient {

    private static Logger logger = LoggerFactory.getLogger(SadrClient.class);

//    private String pingUrl;

	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
    private EurekaClient eurekaClient;


    @HystrixCommand(fallbackMethod="retrieveFallbackPingSadr")
    public PingResponse pingSadr(PingRequest pingRequest){

    	Application application = eurekaClient.getApplication("sadr");
//    	String pingUrl = application.getInstances().get(0).getIPAddr()+":"+application.getInstances().get(0).getPort()
//    			+"/sadr";
    	String pingUrl = "locahl"+":"+application.getInstances().get(0).getPort()
    			+"/sadr";
        logger.debug("--> pingSadr received - id: {} - content: {}", pingRequest.getId(), pingRequest.getMessage());
        logger.debug("--> sadr endpoint: {}",pingUrl);
        return restTemplate.postForObject(pingUrl, pingRequest, PingResponse.class);
    }

    public PingResponse retrieveFallbackPingSadr(PingRequest pingRequest){
        return new PingResponse("Error pinging sadr. This is a fallback message");
    }
    
//    public String getPingUrl() {
//		return pingUrl;
//	}
//
//	public void setPingUrl(String pingUrl) {
//		this.pingUrl = pingUrl;
//	}
}
