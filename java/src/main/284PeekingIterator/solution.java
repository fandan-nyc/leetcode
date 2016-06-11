// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iter = null;
	private Integer curr = null;
	private boolean hasNext = false;
	
	private void helper(){
	    this.curr = (this.iter == null || !this.iter.hasNext()) ? null: this.iter.next();
	    this.hasNext = this.curr != null || (this.iter!= null &&this.iter.hasNext());

	}
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iter = iterator;
	    helper();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    return this.curr;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer tmp = curr;
	    helper();
	    return tmp;
	}

	@Override
	public boolean hasNext() {
	    return this.hasNext;
	    
	}
}
