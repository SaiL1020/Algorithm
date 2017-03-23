import java.util.Iterator;

/**
 * Created by sail on 9/13/16.
 * Code one more line :)
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer top;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
        if (it.hasNext())
            top = it.next();
        else
            top = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return top;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int ans = top;
        if (it.hasNext())
            top = it.next();
        else
            top = null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        return top != null;
    }
}
