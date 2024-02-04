//Node class for linked list
import React from "react";
// the node class defines the structure, and youll need aseparate linked list interface
export class Node{
    #data;  // private feilds
    #next;  // private feilds

    constructor(data, next = null){
        this.#data = data;
        this.#next = next;
    }

    getData(){
        return this.#data;
    }

    getNext(){
        return this.#next;
    }

    setData(data){
        this.#data = data;
    }

    setNext(next){
        this.#next = next
    }
}

