/**
* CMSI 2120. Data Structures. Assignment 3.
* 
*
* 
*/

public class A3 {

    // Decimal to binary method
    public static int Binary (int n){
        if (n == 0){
            return 0;
        }
        else {
            return (n%2) + 10*(Binary(n/2));
        }
    }


    // Sum and recSum
    public static int Sum(int n){
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum = sum + (i+10);
        }
        return sum;
    }

    public static int recSum(int n){
        if (n == 1) {
            return (n+9);
        }
        return (n+9) + recSum(n-1);
    }

    /**
     * Displays the student name, id and class section.
     */

    public static void displayStudentInfo( ) {

// is this what he wants, or is it an algorithm to print this out or smt else
System.out.println( "Student Name: Atul Venkatesan" );
System.out.println( "Student ID: 913425518" );
System.out.println( "CMSI 2120 - Data Structures" );
System.out.println( "Section: 2" );
System.out.println();

    }

    /**
     * Returns a copy of the array 'in' where each word occurring in
     * the array 'what' has been replaced by the word occurring in the
     * corresponding position in the array 'with'.
     *
     * @param in an array of Strings;
     * @param what an array of words to be replaced;
     * @param with an array of replacement words;
     * @return a new array idententical to 'in' except that all the
     * occurrences of words found in 'what' have been replaced by the
     * corresponding word from 'with'.
     */

public static String[] findAndReplace( String[] in, String[] what, 
String[] with ) {

String affiche [] ;
int a;
int k;
a=in.length;
affiche =new String [a];
int i=0;
while ( i<a)
{
 for ( int j=0; j<what.length-1; j=j+1)
  {
  affiche[j]=with[j];
  }
  for ( int j=0; j<what.length; j=j+1)
  {
 k= what[j].compareTo(in[i]);
   if ( k==0 )
    {
      affiche[i]=with[j];
    }
    else
    {
      affiche[i]=in[i];
    }
  }
    i=i+1;
  }

return affiche;
    }

    /**
     * The main method is automatically called by the Java Virtual Machine.
     *
     * > java A3
     */

    public static void main( String[] args ) {

        int result1 = Sum(4);
        int result2 = recSum(4);
        int result3 = Binary(6);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

displayStudentInfo();

String[] text;
text = new String[ 10 ];

text[ 0 ] = new String( "I" );
text[ 1 ] = new String( "have" );
text[ 2 ] = new String( "never" );
text[ 3 ] = new String( "let" );
text[ 4 ] = new String( "my" );
text[ 5 ] = new String( "schooling" );
text[ 6 ] = new String( "interfere" );
text[ 7 ] = new String( "with" );
text[ 8 ] = new String( "my" );
text[ 9 ] = new String( "education" );

String[] query;
query = new String[ 3 ];

query[ 0 ] = text[ 0 ];
query[ 1 ] = text[ 1 ];
query[ 2 ] = text[ 4 ];

String[] replacement;
replacement = new String[ 3 ];

replacement[ 0 ] = new String( "You" );
replacement[ 1 ] = new String( "should" );
replacement[ 2 ] = new String( "your" );

String[] result;
result = findAndReplace( text, query, replacement );

if ( result == null ) {
     System.err.println( "findAndReplace should not return a null value" );
     System.exit( 1 );
}

// We now know that result cannot be null

for ( int i=0; i<result.length; i++ ) {
     if ( i > 0 ) {
  System.out.print( " " );
     }
     System.out.print( result[ i ] );
}
System.out.println( "." );
    }

    // not sure whether to use scanner or not
    private static double computeAvgMark(double grade1, double grade2, double grade3, double grade4, double grade5){
        double sum = grade1+grade2+grade3+grade4+grade5;
        return (sum/500);
    }
}




