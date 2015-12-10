//Team HexPecs -- Andrew Lin and Owen Zeng
//APCS1 pd9
//HW43 -- This or That or Fourteen Other Things
//2015-12-08

public class Hexadecimal implements Comparable {

    private int _decNum;
    private String _hexNum;
    private final static String HEXDIGITS = "0123456789ABCDEF"; 


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _hexNum to "0"
      =====================================*/
    public Hexadecimal() { 
	_decNum = 0;
	_hexNum = "0";
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _hexNum to equiv string of bits
      =====================================*/
    public Hexadecimal( int n ) {
	_decNum = n;
	_hexNum = decToHexR (n);
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _hexNum to decimal equiv
      =====================================*/
    public Hexadecimal( String s ) {
	_decNum = hexToDecR (s);
	_hexNum = s;
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return _hexNum;
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      String decToHex(int) -- converts base-10 input to base-16
      pre:  n >= 0
      post: returns String of bits
      =====================================*/
    public static String decToHex( int n ) {
	//Uses Algorithm discussed in class
	String retStr = "";
	while (n > 16) {
       String temp = HEXDIGITS.substring (n % 16, n % 16 + 1);
	    retStr = temp + retStr;
	    n = n/16; }
	retStr += HEXDIGITS.substring (n , n + 1);
	return retStr;
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      String decToHexR(int) -- converts base-10 input to base-16, recursively
      pre:  n >= 0
      post: returns String of bits
      =====================================*/
	 public static String decToHexR (int n) {
   if (n < 16) {return HEXDIGITS.substring(n, n + 1);}
   else {
      int remainder = n % 16;
      String temp = HEXDIGITS.substring(remainder, remainder + 1);
  	  return decToHexR (n/16) + temp;
  	}
  	/****** YOUR IMPLEMENTATION HURRR ******/   
      }


    /*=====================================
      String binToDec(String) -- converts base-10 input to base-16
      pre:  s represents non-negative base-16 number
      post: returns decimal equivalent as int
      =====================================*/
      public static int hexToDec( String s ) {
  	//Takes the reverse index # of the String char as the exponent.
  	//Truncates String s so only the first char in s is examined
  	int decNum = 0;
  	for (int counter = s.length() - 1; counter >= 0; counter --) {
  	    int temp = HEXDIGITS.indexOf (s.substring(0,1));
  	    decNum += ((int)(Math.pow (16.0, (double)counter)))*temp;
  	    s = s.substring(1); }
  	return decNum;
     }
	
    


    /*=====================================
      String binToDecR(String) -- converts base-10 input to base-16, recursively
      pre:  s represents non-negative base-16 number
      post: returns decimal equivalent as int
      =====================================*/
   
    public static int hexToDecR( String s ) {
  	if (s.length() == 0) {return 0;}
	else {
	    return hexToDecR(s.substring(1)) + ((int)(Math.pow (16.0, (double)(s.length()-1))))*HEXDIGITS.indexOf (s.substring(0,1)); }
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) {
      return this.compareTo(other) == 0;
	/*boolean retVal = this == other;
	if (!retVal) {
	    retVal = other instanceof Hexadecimal && this.compareTo((Hexadecimal)other) == 0; }
	return retVal;*/
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }

     public int getValue () {
	return hexToDec(_hexNum); }

    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
      
     public int compareTo( Object other ) {
      if (!(other instanceof Comparable)){
        throw new ClassCastException("Bad Input" + "compareTo() input not a Hexadecimal.");
      }
      if (other == null) {throw new NullPointerException ("Nothing in Object");}
      double value = 0.0;
      if (other instanceof Binary) {
	  int a = this._decNum;
	  int b =((Binary)other).getValue();
	  value = (double) (a - b);

      }
      else if (other instanceof Hexadecimal) {
	  int a = this._decNum;
	  int b = ((Hexadecimal)other)._decNum;
          value = (double)( a - b); }
   

      else {
	  double a = ((double)this._decNum);
	  double b = ((Rational)other).floatValue();
	  value = (double)(a - b); }

      if (value > 0.0) {return 1;}
      if (value == 0.0) {return 0;}
      else {return -1;}
	/****** YOUR IMPLEMENTATION HURRR ******/   
   }


    //main method for testing
    public static void main( String[] args ) {

	
	System.out.println();
	System.out.println( "Testing the new hex converters..." );
	
	Hexadecimal first = new Hexadecimal(9001);
	Hexadecimal second = new Hexadecimal(159);
	Hexadecimal third = new Hexadecimal (0);
	Hexadecimal fourth = new Hexadecimal (160);
	
	System.out.println("Expect 2329: " + first);
	System.out.println("Expect 9F: " + second);
	System.out.println("Expect 0: " + third);// k
	System.out.println("Expect A0: " + fourth);
	
	System.out.println();
  System.out.println("These are the old ones but updated.");
	Hexadecimal b1 = new Hexadecimal(5);
	Hexadecimal b2 = new Hexadecimal(5);
	Hexadecimal b3 = b1;
	Hexadecimal b4 = new Hexadecimal(7);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );       

	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos
	  
    }//end main()

} //end class
