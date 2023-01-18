import org.jetbrains.annotations.NotNull;

import java.util.AbstractList;
import java.util.NoSuchElementException;

public class CollectionArrayList<T> extends AbstractList<T> {
    int size;
    Object[] elements;

    @Override
    public T get(int index) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException();
        } else {
            return (T)elements[index];
        }
    }

    CollectionArrayList(T @NotNull [] initialElements) {
        elements = initialElements.clone();
        size = elements.length;
    }

    CollectionArrayList(int size) {
        elements = new Object[size];
        this.size = 0;
    }

    CollectionArrayList() {
        this(10);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T set(int index, T element) {
        if (index == size) {
            this.add(element);
            return null;
        } else {
            T temp = (T) elements[index];
            elements[index] = element;
            return temp;
        }
    }

    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            Object[] newElements = new Object[size * 2];
            for(int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        elements[size] = t;
        size++;
        return true;
    }

    public void add(int i, T t) {
        if (i == size) {
            this.add(t);
        } else {
            if (size == elements.length) {
                Object[] newElements = new Object[size * 2];
                for(int j = 0; j < size; j++) {
                    newElements[j] = elements[j];
                }
                elements = newElements;
            }
            for(int j = size; j > i; j--) {
                elements[j] = elements[j - 1];
            }
            elements[i] = t;
            size++;
        }
    }

    @Override
    public String toString() {
        return this.toString(",");
    }

    public String toString(String joinStr) {
        StringBuilder outString = new StringBuilder();
        outString.append("[");
        for (int i = 0; i < size; ++i) {
            outString.append(elements[i]);
            if (i != size - 1){
                outString.append(joinStr);
                outString.append(" ");
            }
        }
        outString.append("]");
        return outString.toString();
    }

    @Override
    public T remove(int i) {
        if (i >= size) {
            throw new NoSuchElementException();
        } else {
            T temp = (T) elements[i];
            for (int j = i; j < size - 1; ++j) {
                elements[j] = elements[j + 1];
            }
            return temp;
        }
    }
}
