public class StoreNode {
	
	private int x;
	private int y;
	private int nodeIndex;
	private boolean passed;
	
	public StoreNode(int x,int y,int nodeIndex,boolean passed) {
		this.x = x;
		this.y = y;
		this.nodeIndex = nodeIndex;
		this.passed = passed;
	}
	
	public int getx() {
		return x;
	}
	
	public int gety() {
		return y;
	}
	public void setx(int x) {
		this.x=x;
	}
	public void sety(int y) {
		this.y=y;
	}
	public int getnodeIndex() {
		return nodeIndex;
	}
	
	public boolean getpassed() {
		return passed;
	}
	
	public void setpassed(boolean newpassed) {
		this.passed = newpassed;
	}
	
}