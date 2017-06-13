package com.btr.pdfmeta;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/*****************************************************************************
 * Used for i18n  
 * @author Bernd Rosstauscher (java@rosstauscher.de) Copyright 2010
 ****************************************************************************/

public class Messages {
	private static final String BUNDLE_NAME = "com.btr.pdfmeta.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	/*************************************************************************
	 * Constructor
	 ************************************************************************/
	
	private Messages() {
		super();
	}

	/*************************************************************************
	 * Get a translated string message.
	 * @param key to get the message for,
	 * @return the message for the given key.
	 ************************************************************************/
	
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}

/*
 * $Log: $
 */