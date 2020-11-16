/**
* Name: Divneet Kaur
* CSE8B login : cs8bwi20im
* Date: 2020 March 12th
*Sources: Lecture notes, Introduction to Java Programming book, Lecture,piazza
*/
/**
*This file is used to represent a CharNode object and its properties
*/
/**
*This class is used to create CharNode objects. Each charNode has a character
*named data and a reference named next. This class has only one parameterized
*constructor and getters and setters method for data and next.
*/
public class CharNode{
  private char data; //instance variable that stores the character in a node
  private CharNode next;//next is reference to the next CharNode

  /**
  *public constructor that takes in one parameter: a char and initializes the
  *instance char letter. It changes the next reference as null.
  *@param charC char that initializes the instance char data
  */
  public CharNode(char charC){
    this.data = charC;
    next = null;
  }

  /**
  *getter method to access the instance variable data
  *@return char instance char variable is returned.
  */
  public char getData(){
    return this.data;
  }

  /**
  * getter method to access the instance variable CharNode
  *@return CharNode  object CharNode next is returned
  */
  public CharNode getNext(){
    return this.next;
  }

  /**
  * setter method that takes in a parameter newData and sets the instance
  *variable data to the parameter
  *@param newData of type character which is the new value of instance varialbe
  *data.
  *@return this char which is new data of instance variable
  */
  public CharNode setData(char newData){
    this.data = newData; //sets this data to a new data(passed in parameter)
    return this;
  }

  /**
  * setter method that takes in a parameter newNext and sets the object
  *variable next to the parameter.Setters are usually void return types but
  *here the setters are returning the objects for the purpose of testing.
  *@param newNext of type CharNode which new value of CharNode object next.
  *@return this CharNode which is new next reference of instance variable
  */
  public CharNode setNext(CharNode newNext){
    this.next = newNext; //sets this next to the next of new CharNode
    return this.next;
  }
}
