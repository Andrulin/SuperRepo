//Team EZ PZ -- Andrew Lin, Ziyan Lin
//APCS pd9
//HW42 -- Array of Titanium
//2015-12-04


/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/

public class SuperArray {
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() 
    { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i <  _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

		
    //double capacity of this SuperArray
    private void expand() 
    { 
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable obj ) 
    { 
 	Comparable temp = _data[index];
	_data[index] = obj;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add (Comparable x) {
        add (_size, x);	
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add (int loc, Comparable x) {
	if (loc > _size) System.out.println("Invalid command.");
	else {
	    if (_size + 1 > _data.length) expand();
	    Comparable temp = x;
	    for (int i = loc; i < _size + 1; i++ ){
		temp = set(i, temp);
		//stores the old value in temp, while setting that spot to what temp was, which is the value of the i-1 index
	    }
	    _size += 1;
	    _lastPos += 1;
	}
    }   
    
    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int loc ) { 
	Comparable temp = new Rational (0, 1);
	for (int i = _lastPos; i >= loc; i--){
	    temp = set(i, temp);
	    //save current item's value in temp, set it to the value of the item following it
	}
	_size -= 1;
	_lastPos -= 1;
    }
    


    //return number of meaningful items in _data
    public int size() { 
	return _size;}

    //isSorted
    public boolean isSorted() {
	int counter = 1;
	while ((_data[counter - 1].compareTo(_data[counter]) < 0) && counter < _data.length) 
	    {counter += 1;}
	return (counter == _data.length - 1);
    }

    //linSearch
    public int linSearch (Comparable obj) {
	int counter = 0;
	while (counter < _data.length) {
	    if (obj.compareTo (_data[counter]) == 0) {return counter;}
	    else {counter += 1;}
	}
	return -1;
    }

    //main method for testing
    public static void main( String[] args ) 
    {
	/*SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,i*2);
	    curtis._size++; //necessary bc no add() method yet
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	System.out.println("testing get()...");
	for( int i = 0; i < curtis._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}

	System.out.println("Expanded SuperArray curtis:");
	curtis.expand();
	System.out.println(curtis); */
	
	SuperArray mayfield = new SuperArray();
	//===============================================//
	
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	//Test Add Methods
	mayfield.add(new Rational (5, 1));
	mayfield.add(new Binary (8));
	mayfield.add(new Hexadecimal (16));
	mayfield.add(new Binary (56));
	mayfield.add(new Rational (6, 2));

	
	
	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);
	
	
	//Test Remove Method
	mayfield.remove(3);
	System.out.println("Printing ListInt mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing ListInt mayfield post-remove...");
	System.out.println(mayfield); 

	
	//Test Add-at-Index
	mayfield.add(2,new Binary (56));
	System.out.println("Printing ListInt mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,new Binary (58));
	System.out.println("Printing ListInt mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,new Binary (57));
	System.out.println("Printing ListInt mayfield post-insert...");
	System.out.println(mayfield);
	
	
	//Test Size 
	System.out.println("Printing ListInt mayfield size");
	System.out.println (mayfield.size());
	
	//isSorted Test
	System.out.println (mayfield.isSorted());

	//linSearch Test
	System.out.println (mayfield.linSearch (new Binary (8)));

	/*//Testing Get
	System.out.println("Printing ListInt mayfield at index 5");
	System.out.println (mayfield.get(5));
	System.out.println("Printing ListInt mayfield at index 4");
	System.out.println (mayfield.get(4));
	System.out.println("Printing ListInt mayfield at index 3");
	System.out.println (mayfield.get(3));
	System.out.println("Printing ListInt mayfield at index 2");
	System.out.println (mayfield.get(2));
	System.out.println("Printing ListInt mayfield at index 1");
	System.out.println (mayfield.get(1));
	System.out.println("Printing ListInt mayfield at index 0");
	System.out.println (mayfield.get(0)); */

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	//*****INSERT ANY ADDITIONAL TEST CALLS HERE***** 

    }//end main
		
}//end class
