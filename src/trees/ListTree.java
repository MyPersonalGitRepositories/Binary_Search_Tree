package trees;

import exceptions.NullPointerException;

public class ListTree<T extends Comparable<T>> implements MyTree<T> {

    private static class Element<Q extends Comparable <Q>>{
        private Q value;
        private Element<Q> left;
        private Element<Q> right;
        
        public Element(Q value) {
            this.value = value;
        }

        public Q getValue() {
            return value;
        }
        
        @SuppressWarnings("unused")
        public boolean equals(Element<Q> el) {
            if (el == null) {
                return false;
            }
            
            if ((el.value == null) && (this.value == null)) {
                return true;
            }
            
            if ((el.value == null) || (this.value == null)) {
                return false;
            }
            
            return (el.value.equals(this.value));
        }


    }
    
    private Element<T> data;    
    private int size;
    
    public ListTree(final T rootElement) {
        data = new Element<>(rootElement);
        size = 1;
    }
    
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
    
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean contains(T value) throws NullPointerException {
        Element<T> current = data;

        if (value == null)throw new NullPointerException();

        while (current != null) {
            if ((current.value.compareTo(value)) < 0)
                current = current.right;
            else if ((current.value.compareTo(value)) > 0)
                current = current.left;
            else
                return true;
        }

        return false;
    }


    public Element<T> addRecursive(Element<T> current, T value){
        if (current == null)
            return new Element<>(value);

        if ((value.compareTo(current.value)) < 0 ) {
            current.left = addRecursive(current.left, value);
        } else if ((value.compareTo(current.value)) > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    @Override
    public void add(T value) throws NullPointerException {
        if (value == null)throw new NullPointerException();
        data = addRecursive(data,value);
    }

    public Element<T> getData() {        
        return data;
    }

    public void removeValue(final T value) throws NullPointerException {
        Element<T> element = getElementByValue(data, value);
        if (value == null || element == null)
          throw new NullPointerException();
        Element<T> father = fatherOfElement(data, new Element<T>(value));
        if (father == null) {
          if (data.left != null) {
            data = element.left;
            leftSonWithoutLeftSon(element.left).left = element.right;
          } else if (data.right != null) {
            data = element.right;
          } else {
            data = null;
          }
        } else {
          if (father.left == element) {
            if (element.left != null) {
              father.left = element.left;
              leftSonWithoutLeftSon(element.left).left = element.right;
            } else if (element.right !=null) {
              father.left = element.right;
            } else {
              father.left = null;
            }
          } else {
            if (element.left != null) {
              father.right = element.left;
              leftSonWithoutLeftSon(element.left).left = element.right;
            } else if (element.right !=null) {
              father.right = element.right;
            } else {
              father.right = null;
            }
          }
        }
        size--;
      }
    private Element<T> leftSonWithoutLeftSon(Element<T> head) {
        while (head.left != null) {
          head = head.left;
        }
        return head;
      }
    
    
   private Element<T> fatherOfElement(final Element<T> head, final Element<T> element) {
    		 if (head == null || head.getValue() == null) {
    		  return null;
    		 }

    		 if (head.left != null && head.left.equals(element)) {
    		  return head;
    		 }
    		 if (head.right != null && head.right.equals(element)) {
    	      return head;
             }

    Element<T> leftSearchResult = fatherOfElement(head.left, element);
    return (null != leftSearchResult ? leftSearchResult : fatherOfElement(head.right, element));
    }
    
    private Element<T> getElementByValue(final Element<T> head, final T value) {
        if (null == head || null == head.getValue()) {
            return null;
        }
        
        if (head.getValue().equals(value)) {
            return head;
        }
        
        Element<T> leftSearchResult = getElementByValue(head.left, value);
        return (null != leftSearchResult ? leftSearchResult : getElementByValue(head.right, value));
    }
    
    @Override
    public String toString() {
        return subtreeToString(data);
    }    
    
    private String subtreeToString(final Element<T> rootElement) {
        if (null == rootElement) {
            return "NULL";
        }
        return String.format("( %s ( %s, %s ))",
                (null == rootElement.getValue()) ? "NULL" : rootElement.getValue().toString(), 
                subtreeToString(rootElement.left), subtreeToString(rootElement.right));
    }

}
