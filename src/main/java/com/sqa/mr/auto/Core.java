/**
 * File Name: Core.java<br>
 * Raley, Mike<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jun 29, 2017
 */
package com.sqa.mr.auto;

import org.apache.log4j.*;
import org.openqa.selenium.*;

/**
 * Core //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Raley, Mike
 * @version 1.0.0
 * @since 1.0
 */
public class Core {

	private Logger log = Logger.getLogger(this.getClass());

	private String baseURL;

	private WebDriver driver;

	private int screenshotCount = 1;

	protected String testingName = "Auto Test";

	private BasicTest relTest;

	public Core(BasicTest test) {
		super();
		this.baseURL = test.getBaseURL();
		this.driver = test.getDriver();
		this.setRelTest(test);
	}

	/**
	 * @param baseURL
	 * @param driver
	 */
	public Core(String baseURL, WebDriver driver) {
		super();
		this.baseURL = baseURL;
		this.driver = driver;
	}

	public String getBaseURL() {
		return this.baseURL;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	/**
	 * @return the log
	 */
	public Logger getLog() {
		return this.log;
	}

	public String getProp(String propName) {
		return AutoBasics.getProp(propName, "src/main/resources/", "config.properties", getLog());
	}

	/**
	 * @return the relTest
	 */
	public BasicTest getRelTest() {
		return this.relTest;
	}

	public boolean isPresent(By by) {
		return AutoBasics.isElementPresent(getDriver(), by, getLog());
	}

	/**
	 * @param relTest
	 *            the relTest to set
	 */
	public void setRelTest(BasicTest relTest) {
		this.relTest = relTest;
	}

	public boolean takeScreenshot() {
		boolean tookScreenshot = AutoBasics.takeScreenshot("screenshots", this.testingName + this.screenshotCount,
				getDriver(), getLog());
		if (tookScreenshot) {
			this.screenshotCount++;
		}
		return tookScreenshot;
	}

	public boolean takeScreenshot(String fileName) {
		return AutoBasics.takeScreenshot("screenshots", fileName, getDriver(), getLog());
	}

	/**
	 * @param driver
	 *            the driver to set
	 */
	protected void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
