package UtilsLayer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseLayer.BaseClass;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Utils extends BaseClass {

	// Retrieve the current URL
	public String getUrl() {
		try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			System.err.println("Error retrieving the current URL: " + e.getMessage());
			return null;
		}
	}

	// Retrieve the current page title
	public String getTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.err.println("Error retrieving the current page title: " + e.getMessage());
			return null;
		}
	}

	// Take a regular screenshot of the current page
	public void takeScreenshot(String projectName, String fileName) throws IOException {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);

			// Create timestamp for file uniqueness
			String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
			String filePath = System.getProperty("user.dir") + "\\" + projectName + "\\" + fileName + timestamp
					+ ".png";

			// Save the screenshot
			File dest = new File(filePath);
			FileUtils.copyFile(src, dest);
			System.out.println("Screenshot saved at: " + filePath);

		} catch (Exception e) {
			System.err.println("Error while taking screenshot: " + e.getMessage());
			throw e;
		}
	}

	// Take a full-page screenshot
	public void fullScreenshot(String projectName, String fileName) throws IOException {
		try {
			// Initialize AShot and take the screenshot
			AShot ashot = new AShot();
			ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000));
			Screenshot sc = ashot.takeScreenshot(driver);

			// Check if the screenshot image is null
			BufferedImage src = sc.getImage();
			if (src == null) {
				System.err.println("Error: Screenshot capture failed, BufferedImage is null!");
				return;
			}

			// Sanitize the file name
			String sanitizedFileName = fileName.replaceAll("[^a-zA-Z0-9-_]", "_");

			// Create timestamp for file uniqueness
			String date1 = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

			// Ensure the directory exists
			File destDir = new File(System.getProperty("user.dir") + "\\" + projectName);
			if (!destDir.exists()) {
				destDir.mkdirs(); // Create directory if it doesn't exist
			}

			// Define the file path
			File destFile = new File(destDir, sanitizedFileName + date1 + ".png");

			// Write the image to the file
			ImageIO.write(src, "PNG", destFile);

			System.out.println("Full-page screenshot saved at: " + destFile.getAbsolutePath());
		} catch (Exception e) {
			System.err.println("Error while taking full-page screenshot: " + e.getMessage());
			throw e;
		}
	}

}
