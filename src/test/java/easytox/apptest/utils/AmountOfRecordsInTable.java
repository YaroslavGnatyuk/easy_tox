package easytox.apptest.utils;
/**
 * When you need to set amount of records in table you can use this enum.
 * **/
public enum AmountOfRecordsInTable {
   FIFTEEN , THIRTY, SIXTY, ONE_HUNDRED, TWO_HUNDRED, ALL;
   public static String getValue(AmountOfRecordsInTable amount){
       switch (amount){
           case FIFTEEN: {return "15";}
           case THIRTY: {return "30";}
           case SIXTY: {return "60";}
           case ONE_HUNDRED: {return "100";}
           case TWO_HUNDRED: {return "200";}
           case ALL: {return "All";}
       }

       return null;
   }
}
