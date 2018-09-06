package actions.selenium;

import actions.selenium.utils.Elements
import org.openqa.selenium.JavascriptExecutor
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class MouseHoverClick{
    public void run(def params){
        WebElement mainItem = Elements.find(["ID":params."Main Item","ID Type":params."Main Item Type"],Browser.Driver)   
        Actions actions = new Actions(Browser.Driver)
        actions.moveToElement(mainItem).moveToElement(Elements.find(["ID":params."Sub Item","ID Type":params."Sub Item Type"],Browser.Driver)).click().build().perform()
    }
}