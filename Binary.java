//Andrew Lin
//APCS1 pd9
//HW43 -- This or That
//2015-12-07

public class Binary implements Comparable {

    private int _decNum;
    private String _binNum;


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
	_decNum = 0;
	_binNum = "0";
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
	_decNum = n;
	_binNum = decToBin (n);
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
	_decNum = binToDec (s);
	_binNum = s;
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return _binNum;
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ) {
	//Uses Algorithm discussed in class
	String retStr = "";
	while (n > 1) {
	    retStr = n % 2 + retStr;
	    n = n/2; }
	retStr = n + retStr;
	return retStr;
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/
    public static String decToBinR( int n ) {
	if (n < 2) {return n + "";}
	else {
	    return decToBinR (n/2) + Integer.toString(n % 2);
	}
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      String binToDec(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
    public static int binToDec( String s ) {
	//Takes the reverse index # of the String char as the exponent.
	//Truncates String s so only the first char in s is examined.
	int decNum = 0;
	for (int counter = s.length() - 1; counter >= 0; counter --) {
	    int temp = Integer.parseInt(s.substring(0, 1));
	    decNum += ((int)(Math.pow (2.0, (double)counter)))*temp;
	    s = s.substring(1); }
	return decNum;
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      String binToDecR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
   
    public static int binToDecR( String s ) {
	if (s.length() == 0) {return 0;}
	else {
	    return binToDecR(s.substring(1)) + ((int)(Math.pow (2.0, (double)(s.length()-1))))*Integer.parseInt(s.substring(0, 1)); }
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) {
	return this.compareTo (other) == 0;
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }

    public int getValue () {
	return binToDec(_binNum); }

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
	  int a = binToDec(this._binNum);
	  int b = binToDec(((Binary)other)._binNum);
	  value = (double) (a - b);

      }
      else if (other instanceof Hexadecimal) {
	  int a = binToDec(this._binNum);
	  int b = ((Hexadecimal)other).getValue();
          value = (double)( a - b); }
   

      else {	
	  double a = ((double)binToDec(this._binNum));
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
	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	Binary b4 = new Binary(7);

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
