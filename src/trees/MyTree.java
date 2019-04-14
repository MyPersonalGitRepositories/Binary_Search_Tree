package trees;

import exceptions.NullPointerException;
import exceptions.NoSuchElementException;

public interface MyTree<T>  {
    
    boolean isEmpty();
    
    int getSize();

    boolean contains(T elem) throws NullPointerException;

    void add(T elem) throws NullPointerException;

    void removeValue(T value) throws NullPointerException, NoSuchElementException;
}
