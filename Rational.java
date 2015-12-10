//Team EZ PZ -- Andrew Lin and Ziyan Lin
//APCS1 pd9
//HW41 -- In America, the Driver Sits on the Left
//2015-12-03

public class Rational implements Comparable{

    //instance vars
    private int num;
    private int den;
    
    //default constructor
    public Rational() {
	num = 0;
	den = 1;
    }
    
    //overloaded constructor
    public Rational (int x, int y) {
	this();
	if (y==0) {
	    System.out.println("Error: divide by zero");
	}
	else {
	    num = x;
	    den = y;
	}
    }
    
    public static int gcd(int a, int b) {
	if (b == 0) return a;
	//if b > a, they will flip
	return gcd(b, a%b);
    }

    public void reduce() {
	int gcd = gcd(num, den);
	if (gcd != 1) {//already reduced as much as possible
	    num /= gcd; //updates num
	    den /= gcd; //updates den
	}
    }

    public String toString() {
	reduce();
	String frac = num  + "/" + den;
	//String dec  = "Decimal form: " + floatValue() + "\n";
	return frac;
    }
    
    public double floatValue() {
	return num * 1.0 / den;
    } 
    
    public void multiply (Rational og) {
	num *= og.num; //updates num
	den *= og.den; //updates den
    }
    
    public void divide(Rational og) {
	if (og.num == 0) {
	    System.out.println("Error: divide by zero");//undefined much?
	}
	else {
	    num *= og.den; //updates num
	    den *= og.num; //updates den
	}
    	//when dividing r by s, r is multiplied by reciprocal of s
    }

    public void add(Rational og) {
	int gcd = gcd(den, og.den);
	int x = den / gcd;//x and y are scale factors so both numbers can share a common denom
	int y = og.den / gcd;
        num = num * y + og.num * x;
	den *= y;
    }

    public void subtract(Rational og) {
	int gcd = gcd(den, og.den);
	int x = den / gcd;
	int y = og.den / gcd;
	num = num * y - og.num * x;//same algo as add but with -
	den *= y;
    }
    
    //re: add() and subract()
    /* by multiplying the num and den of one factor by the den/gcd of 
       the other we are essentially finding the lcm of both denominators */

     public int compareTo( Object other ) {
      if (!(other instanceof Comparable)){
        throw new ClassCastException("Bad Input" + "compareTo() input not a Hexadecimal.");
      }
      if (other == null) {throw new NullPointerException ("Nothing in Object");}
      double value = 0.0;
      if (other instanceof Binary) {
	  double a = this.floatValue();
	  int b = ((Binary)other).getValue();
	  value = (double) (a - b);

      }
      else if (other instanceof Hexadecimal) {
	  double a = this.floatValue();
	  int b = ((Hexadecimal)other).getValue();
          value = (double)( a - b); }
   

      else {	
	this.reduce();
	((Rational)other).reduce();
	if (this.num==((Rational)other).num&& this.den == ((Rational)other).den) return 0;
	else if (this.num > ((Rational)other).num && this.den< ((Rational)other).den )  return 1;
	return -1;
    }
      if (value > 0.0) {return 1;}
      if (value == 0.0) {return 0;}
      else {return -1;}
	/****** YOUR IMPLEMENTATION HURRR ******/   
   }

    /* equals
	Takes 1 Object as input X
	Returns true if input is of class Rational and of equal value to calling instance of Rational
	Returns false otherwise*/
    
    
    
    public boolean equals(Object og) {
        return this.compareTo (og) == 0; }

    /*public static void main(String[] args) {
	
   
	/*Rational r = new Rational();
	Rational s = new Rational(8, 18);
	Rational t = new Rational(4, 6);
	Rational v = new Rational(7, 21);
	Rational w = new Rational(7, 21); */
	/*
	System.out.println("~~--------------------------------~~");
	
	System.out.println("Testing toString(): \n");
	System.out.println();
	System.out.println("Rational r:");
	System.out.println(r);
	System.out.println("Rational s:");
	System.out.println(s);
	System.out.println("Rational t:");
	System.out.println(t);
	System.out.println("Rational v:");
	System.out.println(v);
	
	System.out.println("~~--------------------------------~~");

	System.out.println("Testing multiply(): ");
	System.out.println();
	System.out.println("s * v");
	System.out.println();
	System.out.println("BEFORE:");
	System.out.println("Rational s:");
	System.out.println(s);
	System.out.println("Rational v:");
	System.out.println(v);
	s.multiply(v);
	System.out.println("AFTER:");
	System.out.println("Rational s:");
	System.out.println(s);
	System.out.println("Rational v:");
	System.out.println(v);

	System.out.println("~~--------------------------------~~");

	System.out.println("Testing divide(): ");
	System.out.println();
	System.out.println("v / s"); } */
    
}
