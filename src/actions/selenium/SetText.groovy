package actions.selenium

import actions.selenium.utils.Element
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

class SetText{
  
  public static void run(def params){
    WebElement element = Element.find(params,Browser.Driver)
    
    element.clear()
    element.sendKeys(params."Text")    
    
    
  }
}