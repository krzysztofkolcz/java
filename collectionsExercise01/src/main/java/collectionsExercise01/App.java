package collectionsExercise01;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int count = 8;
        String[] array = getStringArray(count);
        for(String el : array){
          System.out.println(el);
        }
    }

    public static String[] getStringArray(int count){
      String[] array = new String[count];
      array[0] = ".";
      for(int i = 1; i<count; i++){
        array[i] = array[i-1]+"a";
      }
      return array;
    }
}
