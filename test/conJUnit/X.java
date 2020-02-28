package conJUnit;

public class X {

    private int x;

    public X() {
        this(0);
    }

    public X(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		X other = (X) obj;
//		if (x != other.x)
//			return false;
//		return true;
//	}
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        return result;
    }

}
