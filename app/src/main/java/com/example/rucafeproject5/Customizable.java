package com.example.rucafeproject5;

/**
 * Customizable that gets implemented by other classes and their methods (add and remove) overriden by others.
 * Important to ensure proper addition and removal of objects
 * @author Manveer Singh, Prasidh Sriram
 */
public interface Customizable {
    boolean add(Object obj);
    boolean remove(Object obj);
}