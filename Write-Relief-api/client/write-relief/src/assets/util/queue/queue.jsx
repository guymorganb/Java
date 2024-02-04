// implement a queue using the linked list as an interface
import React from 'react';
import { LinkedList } from '../linkedList/linkedList';

// Queue class extending LinkedList to provide FIFO (First-In-First-Out) behavior
export class Queue extends LinkedList{ 
    constructor(){ 
        super(); // Calls the constructor of LinkedList to initialize the list
    }

    enqueue(value){
        // Adds an item to the end of the queue
        this.addLast(value); 
    }

    dequeue(){
        // Removes and returns the item at the front of the queue
        const value = this.peek(); // Gets the value at the front without removing it
        this.removeFirst(); // Removes the item at the front
        return value;
    }

    peek(){
        // Returns the value at the front of the queue without removing it
        return this.head ? this.head.data : null;
    }

    isEmpty(){
        // Checks if the queue is empty
        return this.size() === 0;
    }

    printSize() {
        console.log(`The queue currently has ${this.size} item(s).`);
    }
}
