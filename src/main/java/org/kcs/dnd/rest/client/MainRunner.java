package org.kcs.dnd.rest.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainRunner {
	private static final Logger LOG = LogManager.getLogger(MainRunner.class);

	public static void main(String args[]) {
		LOG.debug("Let's do this");
		ClientCharacterClass.getDataFromRestApi();
	}
}
