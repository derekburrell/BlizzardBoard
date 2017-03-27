package com.team6.teamrocket.blizzardboard;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Data structure to hold the Posts used on the phone side for display.
 * @author Jacob Gould
 */
public class DoublyLinkedList<V> implements Iterable<V> {
    
    /**
     * Class that holds a value in list and points to the previous and next Node.
     *               |-------|
     *      prev <-- | value | --> next
     *               |-------|
     */
    public class Node {
        
        private Node prev, next;    //Pointers to the previous and next node.
        private V value;            //Value held inside the node.
        
        private Node( V value, Node prev, Node next ) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
        
        private Node( V value ) {
            this( value, null, null );
        }
        
        public V getValue() { return value; }
        private void setValue( V value ) { this.value = value; }
        
        private Node getPrev() { return prev; }
        void setPrev( Node prev ) { this.prev = prev; }
        
        private Node getNext() { return next; }
        private void setNext( Node next ) { this.next = next; }
        
        private boolean isStart() { return prev == null; }
        private boolean isEnd() { return next == null; }
        
    }
    
    private int size;               //The size of the list.
    private Node start;             //A pointer to the first node in the list.
    private Node end;               //A pointer to the last node in the list.
    
    /**
     * Parses information sent from server into a DoublyLinkedList.
     * Time Complexity = O(n).
     * @param loadedFromServer11 data sent by server.
     */
    public DoublyLinkedList( String loadedFromServer11 ) {
        size = 0;
        start = null;
        end = null;
        //Pasrse string and add to list.
    }
    
    /**
     * Constructor to make an empty array of type V.
     * Time Complexity = O(1).
     */
    public DoublyLinkedList() {
        this( "" );
    }
    
    /**
     * Appends the value to the end of the list.
     * Time Complexity = O(1).
     * @param value to be held in the node.
     * @return a pointer to the new node.
     */
    public Node add( V value ) {
        Node temp = new Node( value, end, null );
        end = temp;
        if ( temp.isStart() ) {
            start = temp;
        }
        else {
            temp.getPrev().setNext( temp );
        }
        size++;
        return temp;
    }
    
    /**
     * Inserts value into list at index i.
     * Time Complexity = O(n).
     * @param i the index to be inserted to.
     * @param value of the new node.
     * @return a pointer to the new node.
     */
    public Node add( int i, V value ) {
        if ( i < 0 || i > size ) {
            throw new IndexOutOfBoundsException();
        }
        return add( get( i ), value );
    }
    
    /**
     * Inserts value into list prior to Node node.
     * Time Complexity = O(1).
     * @param node the node to be inserted in front of.
     * @param value of the new node.
     * @return a pointer to the new node.
     */
    public Node add( Node node, V value ) {
        if ( node == null ) {
            return add( value );
        }
        Node temp = new Node( value, node.getPrev(), node );
        node.setPrev( temp );
        if ( temp.isStart() ) {
            start = temp;
        }
        else {
            temp.getPrev().setNext( temp );
        }
        size++;
        return temp;
    }
    
    /**
     * Append list to the end of this DoublyLinkedList.
     * Time Complexity = O(1).
     * @param list the list to be appended.
     * @return a pointer to the start of list.
     */
    public Node addAll( DoublyLinkedList<V> list ) {
        if ( list.isEmpty() ) {
            return end;
        }
        Node listStart = list.start();
        list.start().setPrev( end );
        end = list.end;
        if ( list.start().isStart() ) {
            start = list.start;
        }
        else {
            list.start().getPrev().setNext( list.start() );
            list.start = start;
        }
        size += list.size();
        return listStart;
    }
    
    /**
     * Insert list into this DoublyLinkedList at index i.
     * Time Complexity = O(n).
     * @param i the index to be inserted at.
     * @param list the list to be inserted.
     * @return a pointer to the start of list.
     */
    public Node addAll( int i, DoublyLinkedList<V> list ) {
        if ( i < 0 || i > size ) {
            throw new IndexOutOfBoundsException();
        }
        return addAll( get( i ), list );
    }
    
    /**
     * Insert list into this DoublyLinkedList before Node node.
     * Time Complexity = O(1).
     * @param node the node to be inserted before.
     * @param list the list to be inserted.
     * @return a pointer to the start of list.
     */
    public Node addAll( Node node, DoublyLinkedList<V> list ) {
        if ( node == null ) {
            return addAll( list );
        }
        if ( list.isEmpty() ) {
            return node;
        }
        Node listStart = list.start();
        list.start().setPrev( node.getPrev() );
        list.end().setNext( node );
        node.setPrev( list.end() );
        list.end = end;
        if ( list.start().isStart() ) {
            start = list.start;
        }
        else {
            list.start().getPrev().setNext( list.start() );
            list.start = start;
        }
        size += list.size();
        return listStart;
    }
    
    /**
     * Removes the node at index i.
     * Time Complexity = O(n).
     * @param i the index to be removed.
     * @return the value the node held.
     */
    public V remove( int i ) {
        if ( i < 0 || i >= size ) {
            throw new IndexOutOfBoundsException();
        }
        return remove( get( i ) );
    }
    
    /**
     * Removes node from list.
     * Time Complexity = O(1).
     * @param node the node to be removed.
     * @return the value the node held.
     */
    public V remove( Node node ) {
        if ( node == null ) {
            return null;
        }
        if ( node.isStart() ) {
            start = node.getNext();
        }
        else {
            node.getPrev().setNext( node.getNext() );
        }
        if ( node.isEnd() ) {
            end = node.getPrev();
        }
        else {
            node.getNext().setPrev( node.getPrev() );
        }
        size--;
        return node.getValue();
    }
    
    /**
     * Remove all nodes from index i to j from list.
     * Time Complexity = O(n).
     * @param i the starting index to be removed (inclusive).
     * @param j the ending index to be removed (exclusive).
     * @return an Iterable of the values held by the removed nodes.
     */
    public Iterable<V> remove( int i, int j ) {
        if ( i < 0 || i >= size || j < 0 || j >= size ) {
            throw new IndexOutOfBoundsException();
        }
        if ( i > j ) {
            return remove( j, i );
        }
        ArrayList<V> values = new ArrayList<V>();
        Node temp = get( i );
        if ( temp == null ) {
            return null;
        }
        while ( !temp.isEnd() && i < j ) {
            values.add( remove( temp ) );
            temp = temp.getNext();
            i++;
        }
        size -= values.size();
        return values;
    }
    
    /**
     * Get the Node at index i in list.
     * Tune Complexity = O(n).
     * @param i the index of the node.
     * @return a pointer to the node.
     */
    public Node get( int i ) {
        if ( i < 0 || i >= size ) {
            return null;
        }
        int mid = size / 2;
        Node temp;
        if ( i < mid ) {
            temp = start;
            for ( ; i > 0; i-- ) {
                temp = temp.getNext();
            }
        }
        else {
            temp = end;
            for ( ; i < size-1; i++ ) {
                temp = temp.getPrev();
            }
        }
        return temp;
    }
    
    /**
     * Get the index of the first node in list with V value.
     * Time Complexity = O(n).
     * @param value the matching criteria.
     * @return the index of the node. -1 if not found.
     */
    public int indexOf( V value ) {
        Node temp = start;
        for ( int i = 0; i < size; i++ ) {
            if ( temp.getValue().equals( value ) ) {
                return i;
            }
            temp = temp.getNext();
        }
        return -1;
    }
    
    /**
     * Sets the value of the node at index i to V value.
     * Time Complexity = O(n),
     * @param i the index.
     * @param value the replacement value.
     * @return the old value.
     */
    public V set( int i, V value ) {
        if ( i < 0 || i >= size ) {
            throw new IndexOutOfBoundsException();
        }
        return set( get( i ), value );
    }
    
    /**
     * Sets the value of Node node to V value.
     * Time Complexity = O(1).
     * @param node the node.
     * @param value the replacement value.
     * @return the old value.
     */
    public V set( Node node, V value ) {
        if ( node == null ) {
            return null;
        }
        V temp = node.getValue();
        node.setValue( value );
        return temp;
    }
    
    /**
     * Get the previous node in list.
     * Time Complexity = O(1).
     * @param node the node to get the previous of.
     * @return a pointer to the previous node.
     */
    public Node prev( Node node ) {
        if ( node == null ) {
            return null;
        }
        return node.getPrev();
    }
    
    /**
     * Get the next node in list.
     * Time Complexity = O(1).
     * @param node the node to get the next of.
     * @return a pointer to the next node.
     */
    public Node next( Node node ) {
        if ( node == null ) {
            return null;
        }
        return node.getNext();
    }
    
    /**
     * Get the start of list.
     * Time Complexity = O(1).
     * @return a pointer to the first element in list.
     */
    public Node start() {
        return start;
    }
    
    /**
     * Get the end of list.
     * Time Complexity = O(1).
     * @return a pointer to the last element in list.
     */
    public Node end() {
        return end;
    }
    
    /**
     * Get the size of list.
     * Time Complexity = o(1).
     * @return the number of elements in list. 
     */
    public int size() {
        return size;
    }
    
    /**
     * Get whether list has any elements.
     * Time Complexity = O(1).
     * @return true if the list is empty. false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Get an Iterator of the values in the nodes.
     * @return an Iterator of V.
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            Node node = start;

            public void remove() {}

            @Override
            public boolean hasNext() {
                return !node.isEnd();
            }

            @Override
            public V next() {
                Node temp = node;
                node = node.getNext();
                return temp.getValue();

            }
        };
    }
    
}