package j31.java.entity;

import java.io.Serializable;

public class PageForum implements Serializable {

	private int index=1;
	private int size=3;
	private int count;
	
	public int getMaxPage()
	{
		return count%size==0?count/size:count/size+1;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
