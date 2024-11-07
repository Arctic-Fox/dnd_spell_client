package org.kcs.dnd.rest.client;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientCharacterClass {
	
	private static final Logger LOG = LogManager.getLogger(ClientCharacterClass.class);
	private static final String API_URL = "https://www.dnd5eapi.co/api/spells";

    public static void getDataFromRestApi() {
    	LOG.debug("Starting...");
        try (CloseableHttpClient closeableHttpclient = HttpClients.createDefault()) {
        	LOG.debug("Client instantiated.");
        	ClassicHttpRequest httpGet = ClassicRequestBuilder.get(API_URL).build();
        	closeableHttpclient.execute(httpGet, response -> {
                LOG.debug(response.getCode() + " " + response.getReasonPhrase());
                final HttpEntity entity1 = response.getEntity();
                ContentDisplayer.displayContent(entity1.getContent().toString());
                EntityUtils.consume(entity1);
                return null;
            });
        } catch (Exception e) {
        	LOG.error("Unable to coinnect to the API.", e);
        }
    }  	
}