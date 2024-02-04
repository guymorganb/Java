import { Node } from "./NodeClass";
import React from "react";

export class LinkedList{
    #head;
    #tail;
    #size;

    constructor(){
        this.#head = null;
        this.#tail = null;
        this.#size = 0;
    }

    get size(){
        return this.#size;
    }

    addFirst(data){
        // the Node class takes data, and a next as parameters
        const newNode = new Node(data, this.#head);
        this.#head = newNode;
        this.#size++;
    }

    addLast(data){
        const newNode = new Node(data);
        // if there isnt a head make it the head
        if(!this.#head){    
            this.#head = newNode;
            this.#tail = newNode; // Also set the tail
            return;
        } else {
            // Use the tail to append the new node directly, avoiding traversal
            this.#tail.setNext(newNode);
            this.#tail = newNode; // Update the tail reference to the new node
        }
        this.#size++;
    }
    
    insertAt(data, index){
        // check for out of bounds
        if(index > this.#size + 1){
            console.error("Index out of bounds");
            return;
        }
        // Special case: inserting at the beginning
        if(index == 1){
            this.addFirst(data);
            return;
        }
        // Special case: inserting at the end
        if(index === this.#size+1){
            this.addLast(data);
            return;
        }
        // General case: inserting in the middle
        let current = this.#head;
        const newNode = new Node(data);
        let i = 1;
        while(i < index-1){
            current = current.getNext();
            i++;
        }
        // inserting new node, points to current.next
        newNode.setNext(current.getNext());
        // set current node to point to next
        current.setNext(newNode);
        this.#size++;
    }

    removeHead(){
        // Removes the node at the beginning of the list
        if(!this.#head){ 
            return;
        }else if(!this.#head.getNext()){
            this.#head = null;
            return;
        }else{
            this.#head = this.#head.getNext();
            this.#size--;
        }           
    }

    removeLast(){
         // If the list is empty or has only one node
        if(!this.#head || !this.#head.getNext()){
            this.#head = null;
            this.#tail = null;
            this.#size = 0;
            return;
        }
        let i = 1;
        let current = this.#head;
        // Traverse to the second-to-last node
        while(i < this.#size-1){
            current = current.getNext();
            i++;
        }
        // Remove the last node and update the tail
        current.setNext(null);
        this.#tail = current;
        this.#size--;
    }

    removeAt(index) {
        // Check for valid index
        if (index < 0 || index >= this.#size) {
            console.error("Index out of bounds");
            return;
        }
    
        // Special case for removing the first node
        if (index === 0) {
            this.removeHead();
            return;
        }
    
        let current = this.#head;
        for (let i = 0; i < index - 1; i++) { // Iterate to the node just before the target
            current = current.getNext();
        }
    
        // If removing the last node, update tail, otherwise link past the node to remove
        if (index === this.#size - 1) {
            this.#tail = current;
            current.setNext(null);
        } else {
            // Link the current node to the next of the next node, bypassing the node to remove
            current.setNext(current.getNext().getNext());
        }
    
        this.#size--; // Decrement size
    
        // Additional check if list is now empty
        if (this.#size === 0) {
            this.#head = null;
            this.#tail = null;
        }
    }
}