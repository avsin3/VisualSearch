/**
 * @author avsin3
 *
 */
package com.visualsearch.config.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.visualsearch.beans.PropertiesBean;
import com.visualsearch.util.VisualSearchConstants;

/**
 * @author avsin3
 *
 */
public class PropertyValueHandler {

	public static PropertiesBean valueHandler() {

		Properties prop = new Properties();
		InputStream input = null;

		PropertiesBean bean = new PropertiesBean();

		try {
			input = new FileInputStream("config.properties");

			prop.load(input);

			bean.setAccessKey(prop.getProperty(VisualSearchConstants.ACCESS_KEY));
			bean.setSecretKey(prop.getProperty(VisualSearchConstants.SECRET_KEY));

			bean.setScoreMax(Float.valueOf(prop.getProperty(VisualSearchConstants.SCORE_MAX)));
			bean.setScoreMin(Float.valueOf(prop.getProperty(VisualSearchConstants.SCORE_MIN)));
			bean.setSearchlimit(Integer.valueOf(prop.getProperty(VisualSearchConstants.SEARCH_LIMIT)));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bean;
	}
}