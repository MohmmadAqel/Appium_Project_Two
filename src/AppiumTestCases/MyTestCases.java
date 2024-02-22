package AppiumTestCases;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
public class MyTestCases {
	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;
	@BeforeTest
	public void MySetup() {
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Aqel");
		File MyApp = new File("src/My_Applications/calculator.apk");
		caps.setCapability(MobileCapabilityType.APP, MyApp.getAbsolutePath());
	}
	@Test(enabled = false)
	public void MyTestOne() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
		String Result = driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
		System.out.println(Result);
		Assert.assertEquals(false, "30");
	}
	@Test(enabled = false)
	public void MyTestTwo() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		List<WebElement> AllButton = driver.findElements(By.className("android.widget.ImageButton"));
		for (int i = 0; i < AllButton.size(); i++) {
			if (AllButton.get(i).getAttribute("resource-id").contains("digit")) {
				AllButton.get(i).click();
			} else {
				continue;
			}
		}
	}
	@Test()
	public void MyTestThree() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		List<WebElement> AllButton = driver.findElements(By.className("android.widget.ImageButton"));
		for (int i = 0; i < AllButton.size(); i++) {
			if (AllButton.get(i).getAttribute("resource-id").contains("digit_2")
					|| AllButton.get(i).getAttribute("resource-id").contains("digit_4")
					|| AllButton.get(i).getAttribute("resource-id").contains("digit_6")
					|| AllButton.get(i).getAttribute("resource-id").contains("digit_8")
					|| AllButton.get(i).getAttribute("resource-id").contains("digit_0")) {
				AllButton.get(i).click();
			} else {
				continue;
			}
		}
	}
	@AfterTest
	public void MyPostTesting() {
	}
}
