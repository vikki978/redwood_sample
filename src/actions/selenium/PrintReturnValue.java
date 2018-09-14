package actions.selenium;

import java.util.*;

class PrintReturnValue{
    public void run(HashMap<String, Object> params){
        
        System.out.println(params.get("rvalue"));
        
    }
}