/**
* Name: Divneet Kaur
* CSE8B login : cs8bwi20im
* Date: 2020 March 12th
*Sources: Lecture notes, Introduction to Java Programming book, Lecture,piazza
*/
/**
*This file represents the various instance variables and methods required for
*for creating a String Builder class.
*/
/**
*The MyStringBuilderClass will be used to construct, store, and modify character
*in a specific order. This class has three instance variables - firstNode,
*lastNode and charNodeLen. There are three constructors and few methods like
*length, append, toString, insert, remove, delete, substring and concat.
*/
public class MyStringBuilder{
  protected CharNode firstNode; //reference to first node
  protected CharNode lastNode; //reference to last CharNode
  protected int charNodeLen; //number of CharNodes in current MyStringBuilder

  /**
  *public constructor that takes in one parameter: a char and creates a
  *MyStringBuilder object with single input CharNode
  *@param inputChar char that is used to create a MyStringBuilder object
  */
  public MyStringBuilder(char inputChar){
    CharNode newNode = new CharNode(inputChar); //creating new CharNode object
    firstNode = newNode; //setting firstNode to the newly created object
    lastNode = newNode; //setting lastNode to the newly created object
    charNodeLen = 1;//sets length of charNodes in MyStringBuilder as 1
  }

  /**
  *public constructor that takes in one parameter: a string and creates a
  *MyStringBuilder object with the string added at the end
  *@param str String that is added at the end
  */
  public MyStringBuilder(String str) throws BadInputException{
    //if paramter string is null, BadInputException is thrown
    if(str == null){
      throw new BadInputException
      (Constants.FROM_CONSTRUCTOR,Constants.MESSAGE_CONSTRUCTOR);
    }
    //if string length in empty then sets the first and last node as null
    if (str.length() == 0) {
      this.firstNode = null;
      this.lastNode = null;
    }
    //if string is not empty it appends string to the end of the current
    //MyStringBuilder object
    else {
      this.append(str);
    }
  }

  /**
  *public constructor that takes in one parameter: a MyStringBuilder object and
  *creates a deep copy of the passed in object. If MyStringBuilder object is
  *null, BadInputException is thrown.
  *@param newObj MyStringBuilder object whose deep copy is made
  */
  public MyStringBuilder(MyStringBuilder otherObj) throws BadInputException{

    //if otherObj is null, BadInputException is thrown
    if(otherObj == null){
      throw new BadInputException
      (Constants.FROM_DEEPCOPY_CONSTRUCTOR,
      Constants.MESSAGE_DEEPCOPY_CONSTRUCTOR);
    }

    //setting first node of this object equal to the argument object
    this.charNodeLen = otherObj.charNodeLen;
    //creating two temporary CharNodes
    CharNode thisNode = null;
    CharNode otherNode = null;
    //setting the otherNode to firstNode of the otherObject
    otherNode = otherObj.firstNode;
    //creating a new node with data of the otherNode and setting it to thisNode
    thisNode = new CharNode(otherNode.getData());
    //setting this.firstNode to thisNode
    this.firstNode = thisNode;
    //loop over the charNodes
    for(int i = 1; i < charNodeLen; i++){
      //set otherNode to the following Node
      otherNode = otherNode.getNext();
      //getting data of othernode and setting that newNodes data to the next
      //of thisNode
      thisNode.setNext(new CharNode(otherNode.getData()));
      //setting thisNode to the following node
      thisNode = thisNode.getNext();
    }
    //setting lastNode to thisNode
    this.lastNode = thisNode;
  }

  /**
  *This method returns the length of the current MyStringBuilder object.
  *@return int returns the length of current MyStringBuilder object
  */
  public int length(){
    return this.charNodeLen;
  }

  /**
  *This method takes in a character inserts that character at the end of current
  *MyStringBuilder object.
  *@param c character to be inserted at the end of the MyStringBuilder object
  *@return MyStringBuilder returns the modified this object.
  */
  public MyStringBuilder append(char c){
    //if current MyStringBuilder is empty
    if(this.charNodeLen == 0){
      //creating new CharNode with paramter character
      CharNode newC = new CharNode(c);
      //setting first and last Node equal to the new node created
      this.firstNode = newC;
      this.lastNode = newC;
      charNodeLen++; //increasing charNode length
    }
    //if current MyStringBuilder is not empty
    else {
      //creating new CharNode with paramter character
      CharNode newC = new CharNode(c);
      //setting next of current lastNode to the new node
      this.lastNode.setNext(newC);
      //setting new node as the new last node
      this.lastNode = newC;
      charNodeLen++; //increasing charNode length
    }
    return this; //returning the modified object
  }

  /**
  *This method takes in a string and adds an entire string to end of current
  *MyStringBuilder object and returns the modified MyStringBuilder object.
  *@param str string to be added at the end of MyStringBuilder object.
  *@return MyStringBuilder modified object which has the string added in the end
  */
  public MyStringBuilder append(String str) throws BadInputException{
    //checking for null string
    if( str == null){
      throw new BadInputException
      (Constants.FROM_APPEND_STR,Constants.MESSAGE_APPREND_STR);
    }

    //iterating over the string
    for(int i = 0; i < str.length(); i++){
      //adding every character of string to MyStringBuilder object
      char c = str.charAt(i);
      this.append(c);
    }
    return this; //return the modified this object
  }

  /**
  *This method returns the string represenatation of sequence of nodes of chars
  *@return String returns the string representation of the chars in CharNode
  */
  public String toString(){
    //if there are no nodes return empty string
    if (charNodeLen == 0) {
      return "";
    }

    String strOfNodes = ""; //creating empty string
    CharNode currNode = this.firstNode;//creating node that tracks the position

    //the data from the first till second last nodes is added in the string
    while(currNode.getNext() != null){
    strOfNodes += currNode.getData();
    currNode = currNode.getNext(); //making currNode point to following node
    }
    //getting data of the last node
    strOfNodes += this.lastNode.getData();
    return strOfNodes; //returning the string formed
  }

  /**
  *This method inserts a string at a particular index. Index should represent
  *the position in MyStringBuilder where the first character of the string
  *to be inserted should start.
  *@param index positionin MyStringBuilder where the first character of string
  *to be inserted should start
  *@param str String to be inserted in the MyStringBuilder object.
  *@return MyStringBuilder returns the modified this object.
  */
  public MyStringBuilder insert (char c, int index)
    throws MSBOutOfBoundsException{
    //checking for out of bounds
    if(index < 0 || index > charNodeLen){
      throw new MSBOutOfBoundsException
      (Constants.FROM_INSERT_CHAR,Constants.MESSAGE_INSERT_CHAR);
    }

    int tracker = 0; //tracker to track what index we are on
    CharNode currNode = this.firstNode; //temporary node to iterate over
    CharNode nodeToInsert = new CharNode(c);
    // all nodes
    if(index == 0){
      //setting reference of current node to the new node created
      nodeToInsert.setNext(this.firstNode);
      this.firstNode = nodeToInsert;
      return this;
    }
    else {
      currNode = findIndex(index - 1);
      //setting reference of current node to the new node created
      nodeToInsert.setNext(currNode.getNext());
      //sets Next of currNode to new node
      currNode.setNext(nodeToInsert);
    }
    //if nodeToInsert points to null then set it as lastNode
    if (nodeToInsert.getNext() == null) {
      this.lastNode = nodeToInsert;
    }
    charNodeLen++; //increasing length of charNode
    return this;
  }

  /**
  *This method inserts a string at a particular index. Index should represent
  *the position in MyStringBuilder where the first character of the string
  *to be inserted should start.
  *@param index position in MyStringBuilder where the first character of string
  *to be inserted should start
  *@param str String to be inserted in the MyStringBuilder object.
  *@return MyStringBuilder returns the modified this object.
  */
  public MyStringBuilder insert (String str, int index)
    throws BadInputException, MSBOutOfBoundsException{
    //checking for null condition
    if(str == null){
      throw new BadInputException
      (Constants.FROM_INSERT_STR,Constants.MESSAGE_INSERT_STR1);
    }

    //checking for out of bounds
    if(index < 0 || index > charNodeLen){
      throw  new MSBOutOfBoundsException
      (Constants.FROM_INSERT_STR,Constants.MESSAGE_INSERT_STR2);
    }

    //loops over the parameter string to insert every character using the
    //earlier insert method
    for(int i = 0; i < str.length(); i++){
      char c = str.charAt(i);
      this.insert(c,index);
      index = index + 1; //increasing index to add the next character at the
      //next index
    }
    return this; //returns modified this object
  }

  /**
  *This method should find the character at a given index and return CharNode
  *at that index.
  *@param index position at which character is to be found
  *@return CharNode returns the node at the specified inde
  */
  protected CharNode findIndex(int index) throws MSBOutOfBoundsException{
    //checking for out of bounds
    if(index < 0 || index >= charNodeLen){
      throw new MSBOutOfBoundsException
      (Constants.FROM_FIND_INDEX,Constants.MESSAGE_FIND_INDEX);
    }

    //MyStringBuilder is empty,then any value of index would be out of bounds.
    if(this.charNodeLen == 0){
      throw new MSBOutOfBoundsException
      (Constants.FROM_FIND_INDEX,Constants.MESSAGE_FIND_INDEX);
    }
    //tracker to track the current node
    int tracker = 0;

    //creating a new node pointing towards first node
    CharNode currNode = this.firstNode;
    //loops continues till currNode's next reference isnt null
    while(currNode != null && index != tracker) {
      //tracker is increased everytime if condition fails
      tracker = tracker + 1;
      //currNode points to the next node everytime if condition fails
      currNode = currNode.getNext();
    }
    return currNode; //current Node at the required index is returned
  }

  /**
  *This method should remove the CharNode at a given index. The index represents
  *the position of the node which we want to remove. After this node is removed,
  *the previous node at position index + 1 should be at position index.
  *This method throws MSBOutOfBounds error if index is bigger than length of
  *charNodes or if negative
  *@param index position of the node to be removed
  *@return MyStringBuilder returns the modified object
  */
  public MyStringBuilder remove(int index) throws MSBOutOfBoundsException{
    //checking for out of Bounds
    if(index < 0 || index >= charNodeLen){
      throw new MSBOutOfBoundsException
      (Constants.FROM_REMOVE,Constants.MESSAGE_REMOVE);
    }

    //tracker to track the current node
    int tracker = 0;
    //creating a new node pointing towards first node
    CharNode currNode = this.firstNode;

    //if index is 0
    if(index == 0){
      //changing the firstNode from current Node to the next Node in line
      this.firstNode = currNode.getNext();
      currNode = this.firstNode;
    }
    //if index != 0
    else{
      //1) while tracker < index - 1
      while(tracker != index-1){
        //changing the currNode to the next Node in line
        currNode = currNode.getNext();
        //increasing tracker by 1
        tracker = tracker + 1;
      }
      //removing the node at particular index by chaning the next of current
      currNode.setNext(currNode.getNext().getNext());
    }

    //if index = charNodeLen -1 , setting lastNode to current node thus
    //removing the last node
    if(index == charNodeLen-1){
      this.lastNode = currNode;
    }
    charNodeLen--; // reducing length of the CharNodes
    //returning modified this object
    return this;
  }

  /**
  *This is a method used to delete a range of characters. startIndex specifies
  *an index in MyStringBuilder. All nodes starting from and including startIndex
  *should be removed from MyStringBuilder.
  *This method throws MSBOutOfBounds error if startIndex is bigger than length
  *of charNodes or if negative
  *@param startIndex integer from where we start deleting the nodes
  *@return MyStringBuilder returns the modified object
  */
  public MyStringBuilder delete(int startIndex) throws MSBOutOfBoundsException{
    //checking for out of bounds
    if(startIndex < 0 || startIndex > charNodeLen){
      throw new MSBOutOfBoundsException
      (Constants.FROM_DELETE_STARTINDEX,
      Constants.MESSAGE_DELETE_STARTINDEX);
    }
    //removing the startIndex till startIndex is smaller than charNode length
    while(startIndex<charNodeLen){
      this.remove(startIndex);
    }
    //return modified object
    return this;
  }

  /**
  *This method deletes a subsequence of characters from MyStringBuilder.
  *The nodes for deletion starts at position startIndex and deletes up to,
  *but not including, the node at position endIndex and returns the changed
  *object.
  *This method throws MSBOutOfBounds error if endIndex and startIndex is bigger
  *than length of charNodes or if negative and BadInputException if endIndex is
  *smaller than startIndex
  *@param startIndex integer from where we start deleting the nodes
  *@param endIndex integer to which we delete the nodes(exclusive)
  *@return MyStringBuilder the changed this object
  */
  public MyStringBuilder delete(int startIndex, int endIndex)
  throws BadInputException, MSBOutOfBoundsException{
    //giving an error if endIndex is smaller than startIndex
    if(endIndex < startIndex){
      throw new BadInputException
      (Constants.FROM_DELETE_STARTINDEX_ENDINDEX,
      Constants.MESSAGE_DELETE_STARTINDEX_ENDINDEX1);
    }
    //checking for out of bounds
    if(startIndex < 0 || startIndex >= charNodeLen || endIndex > charNodeLen ){
      throw new MSBOutOfBoundsException
      (Constants.FROM_DELETE_STARTINDEX_ENDINDEX,
      Constants.MESSAGE_DELETE_STARTINDEX_ENDINDEX2);
    }

    //removing the startIndex till startIndex is smaller than endIndex
    //and reducing the value of endIndex
    while(startIndex<endIndex){
      this.remove(startIndex);
      endIndex--;
    }
    //returning the modified object
    return this;
  }

  /**
  *This method concatenates characters from startIndex till the end and returns
  *the substring.All nodes starting from and including startIndex till last
  *node(inclusive).
  *This method throws MSBOutOfBounds error if startIndex is bigger
  *than length of charNodes or if negative.
  *@param startIndex integer from where we start getting the nodes
  *@return String returns the substring
  */
  public String substring(int startIndex) throws MSBOutOfBoundsException{
    //checking for out of bounds
    if(startIndex < 0 || startIndex > charNodeLen){
      throw new MSBOutOfBoundsException
      (Constants.FROM_SUBSTRING_STARTINDEX,
      Constants.MESSAGE_SUBSTRING_STARTINDEX);
    }
    String reqStr = "";
    //calling toString on MyStringBuilder object
    String msbStr = this.toString();
    //calling String class's substring method on the string form of
    //MyStringBuilder object
    reqStr += msbStr.substring(startIndex);
    return reqStr; //return substring
  }

  /**
  *This method concatenates characters from startIndex to endIndex and returns
  *the substring.All nodes starting from and including startIndex till endIndex,
  *but not including the node at position endIndex are considered.
  *This method throws MSBOutOfBounds error if endIndex and startIndex is bigger
  *than length of charNodes or if negative and BadInputException if endIndex is
  *smaller than startIndex
  *@param startIndex integer from where we start getting the nodes
  *@param endIndex integer to which we get the nodes(exclusive)
  *@return String returns the substring
  */
  public String substring(int startIndex, int endIndex)
  throws MSBOutOfBoundsException,BadInputException{
    //checking for Out of bounds exception
    if(startIndex < 0 || startIndex > charNodeLen || endIndex > charNodeLen){
      throw new MSBOutOfBoundsException
      (Constants.FROM_SUBSTRING_STARTINDEX_ENDINDEX,
      Constants.MESSAGE_SUBSTRING_STARTINDEX_ENDINDEX1);
    }

    //giving an error if endIndex is smaller than startIndex
    if(endIndex < startIndex){
      throw new BadInputException
      (Constants.FROM_SUBSTRING_STARTINDEX_ENDINDEX,
      Constants.MESSAGE_SUBSTRING_STARTINDEX_ENDINDEX2);
    }
    //returning empty string if startIndex is equal to endIndex
    if(startIndex == endIndex){
      return "";
    }

    //calling toString on MyStringBuilder object
    String msbStr = this.toString();
    //calling String class's substring method on the string form of
    //MyStringBuilder object
    String reqStr = msbStr.substring(startIndex,endIndex);
    return reqStr; //returning the substring
  }

  /**
  *This method concatenates two MSB objects together. It takes in a parameter
  *MSB object that is to be concatenated and returns the concatenated MSB object
  **This method throws BadInputException if rightOperand is not a valid input
  *@param rightOperand MyStringBuilder object that should be the second part
  *of the current MSB object.
  *@return MyStringBuilder the concatenated object is returned
  */
  public MyStringBuilder concat(MyStringBuilder rightOperand)
  throws BadInputException{

    //throwing an error if the passed in parameter is not an instance of
    //MyStringBuilder object
    if(!(rightOperand instanceof MyStringBuilder)){
      throw new BadInputException
      (Constants.FROM_CONCAT,Constants.MESSAGE_CONCAT);
    }
    //throwing an error if the passed in parameter is not correct type
    if(rightOperand == null){
      throw new BadInputException
      (Constants.FROM_CONCAT, Constants.MESSAGE_CONCAT);
    }
    //if length of this object is not zero, parameter object is added to end of
    //this object
    if(this.charNodeLen != 0){
      //setting this's next of lastNode to the firstNode of the parameter object
      this.lastNode.setNext(rightOperand.firstNode.getNext());
      //setting the last node of parameter object to last Node of this object
      this.lastNode = rightOperand.lastNode;
      this.charNodeLen = rightOperand.charNodeLen;
    }
    //if length of this object is zero, the first and last node of the this
    // object will be same as that of parameter object
    else{
      this.firstNode.setNext(rightOperand.firstNode.getNext());
      this.lastNode = rightOperand.lastNode;
      this.charNodeLen = this.charNodeLen + rightOperand.charNodeLen;
    }
    return this; //returning concatenated object
  }
}
