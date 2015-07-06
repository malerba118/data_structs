import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;


public class Test {

	public static void main(String[] args){
		
		ArrayList<String> letters = new ArrayList<String>();
		letters.add("A");
		letters.add("B");
		letters.add("C");
		letters.add("D");
		letters.add("E");
		
		Node head = createLinkedList(letters);
		System.out.println("Linked list: " + head);
		System.out.println("Reversed: " + reverseLinkedList(head));
	}
	
	
	public static Node createLinkedList(List<String> letters){
		if (letters.isEmpty()){
			return null;
		}
		else{
			
			return new Node(letters.get(0), createLinkedList(letters.subList(1, letters.size())));
		}
		
	}
	
	public static Node reverseLinkedList(Node head){
		
		if (head.getNext() == null){
			return head;
		}
		
		Node tail;
		Node current;
		current = head;
		
		while (current.getNext() != null){
			current = current.getNext();
		}
		tail = current;
		
		current = head;
		while (!current.getNext().equals(tail)){
			current = current.getNext();
		}
		
		current.setNext(null);
		
		
		return tail.setNext(reverseLinkedList(head));

	}
}
