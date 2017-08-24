
//File:  SaveInfo.java

import java.io.* ;

class SaveInfo implements Serializable
{
 int numberGames  = 0 ;
 int numberWins   = 0 ;
 int numberLosses = 0 ;
 int highScore    = 0 ;
 
 void clearHistory()
 {
     numberGames = 0 ;
     numberWins  = 0 ;
     numberLosses = 0 ;
     highScore   = 0 ;    
 }
 
 String returnStatus()
 {
     return ("    Wins " + numberWins + 
             "  Losses " + numberLosses + 
             "  High Score " + highScore) ;
 }

 void gameResult (boolean win, int score)
 {
     numberGames = numberGames+1 ;
     if (win==true)
     {
         numberWins  = numberWins+1 ;
     }
     else
     {
         numberLosses = numberLosses+1 ;
     }
     if (score>highScore)
     {
         highScore = score ;
     }            
 }
 
 void saveHistory()
 {
     try
     {
         FileOutputStream historyFileStream = 
             new FileOutputStream("GameHistory.ser") ;
         ObjectOutputStream historyObjectStream = 
             new ObjectOutputStream(historyFileStream) ;
         historyObjectStream.writeObject(this) ;
         historyObjectStream.close() ;
         historyFileStream.close() ;
     }
     catch (IOException e)
     {
         System.out.println ("Save game history failed") ;
     }
 }

}

