package generics;

// NOTE comma separates multiple type variable declarations!!! 
// USE & for multiple constraints
public class Pair<E extends Colored & Sized, X> { 
	private E left;
	private E right;
	private X thing;

	// CANNOT make static reference to the class type,
	// because the type is associated with the reference variable, not
	// the class!!!
//	public static void blahblah(E thing) {
//	}
	
	public static <F extends Colored & Sized> boolean match(F a, F b) {
		return a.getColor().equals(b.getColor())
				&& a.getSize() == b.getSize(); 
	}
	
	public E getLeft() {
		return left;
	}

	public void setLeft(E left) {
		this.left = left;
	}

	public E getRight() {
		return right;
	}

	public void setRight(E right) {
		this.right = right;
	}

	public boolean isMatching() {
//		if (left instanceof Shoe)
		return left.getColor().equals(right.getColor())
				&& left.getSize() == right.getSize();
	}
	
	public Pair(E left, E right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Pair [left=" + left + ", right=" + right + "]";
	}

}
