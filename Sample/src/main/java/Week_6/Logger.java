package Week_6;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Logger {
   private static Logger instance;

   private Logger(){
        log.info("Logger Class Initialised");
   }

   public static synchronized Logger getInstance(){
       if(instance==null){
                   instance = new Logger();
               }
       return instance;
   }

   public static void main(String args[]){
       Logger logNew = null;
       logNew.getInstance();
   }
}
