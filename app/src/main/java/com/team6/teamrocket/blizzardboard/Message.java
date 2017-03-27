package com.team6.teamrocket.blizzardboard;

/**
 * @author Jordan Kieltyka
 * @date March 22, 2017
 * @brief This class defines a message that is sent
 * 		  between one or more users.
 */
public class Message {

	private User sender;						//the user sending the message
	private DoublyLinkedList<User> receiver;	//the user(s) getting the message
	private String message = new String();		//the contents of the message
	
	/**
	 * Helps construct the message object.
	 * 
	 * @param sender - The user sending the message.
	 * @param receiver - The user(s) getting the message.
	 * @param message - Contents of the message to be read.
	 */
	private void messageConstructor(User sender, DoublyLinkedList<User> receiver, String message){
		setSender(sender);
		setReceiver(receiver);
		setMessage(message);
	}
	
	//constructors
	public Message(){messageConstructor(sender, receiver, message);}
	public Message(User sender){messageConstructor(sender, receiver, message);}
	public Message(DoublyLinkedList<User> receiver){messageConstructor(sender, receiver, message);}
	public Message(User sender, DoublyLinkedList<User> receiver){messageConstructor(sender, receiver, message);}
	public Message(User sender, String message){messageConstructor(sender, receiver, message);}
	public Message(DoublyLinkedList<User> receiver, String message){messageConstructor(sender, receiver, message);}
	public Message(User sender, DoublyLinkedList<User> receiver, String message){messageConstructor(sender, receiver, message);}
	
	//constructor
	public Message(User sender, User receiver){
		getReceiver().add(receiver);
		messageConstructor(sender, getReceiver(), message);
	}
	
	//constructor
	public Message(User sender, User receiver, String message){
		getReceiver().add(receiver);
		messageConstructor(sender, getReceiver(), message);
	}
	
	//set methods
	public void setSender(User sender){this.sender = sender;}
	public void setReceiver(DoublyLinkedList<User> receiver){this.receiver = receiver;}
	public void setMessage(String message){this.message = message;}
	
	//get methods
	public User getSender(){return sender;}
	public DoublyLinkedList<User> getReceiver(){return receiver;}
	public String getMessage(){return message;}
}
