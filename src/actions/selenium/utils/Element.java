package actions.selenium.utils;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class Element
{
    public static WebElement find(HashMap<String,String> params, WebDriver driver)
    {
        WebElement foundElement = null;
        switch (params.get("ID Type")) {
           case "Class Name":
                foundElement = driver.findElement(By.className(params.get("ID")));
	       break;
           case "Xpath":
                foundElement = driver.findElement(By.xpath(params.get("ID")));
	       break;
           case "Css Selector":
                foundElement = driver.findElement(By.cssSelector(params.get("ID")));
	       break;
           case "ID":
                foundElement = driver.findElement(By.id(params.get("ID")));
	       break;
           case "Link Text":
                foundElement = driver.findElement(By.linkText(params.get("ID")));
	       break;
           case "Partial Link Text":
                foundElement = driver.findElement(By.partialLinkText(params.get("ID")));
	       break;
           case "Name":
                foundElement = driver.findElement(By.name(params.get("ID")));
	       break;
           case "Tag Name":
                foundElement = driver.findElement(By.tagName(params.get("ID")));
	       break;
           default:
                 foundElement = driver.findElement(By.id(params.get("ID")));
           break;
}
        return foundElement;
    }
    
    public static  List<WebElement> findAll(HashMap<String,String> params, WebDriver driver)
    {
        List<WebElement> foundElements = null;
        switch (params.get("ID Type")) {
           case "Class Name":
                foundElements = driver.findElements(By.className(params.get("ID")));
	       break;
           case "Xpath":
                foundElements = driver.findElements(By.xpath(params.get("ID")));
	       break;
           case "Css Selector":
                foundElements = driver.findElements(By.cssSelector(params.get("ID")));
	       break;
           case "ID":
                foundElements = driver.findElements(By.id(params.get("ID")));
	       break;
           case "Link Text":
                foundElements = driver.findElements(By.linkText(params.get("ID")));
	       break;
           case "Partial Link Text":
                foundElements = driver.findElements(By.partialLinkText(params.get("ID")));
	       break;
           case "Name":
                foundElements = driver.findElements(By.name(params.get("ID")));
	       break;
           case "Tag Name":
                foundElements = driver.findElements(By.tagName(params.get("ID")));
	       break;
           default:
                 foundElements = driver.findElements(By.id(params.get("ID")));
           break;
}
        return foundElements;
    }
}

