package homework9;

public class fusionThread extends Thread{
	
	private boolean pause =false;
	private boolean checkPoint = false;
	public boolean isCheckPoint() {
		return checkPoint;
	}
	public void setCheckPoint(boolean checkPoint) {
		this.checkPoint = checkPoint;
	}
	public boolean isPause() {
		return pause;
	}
	public void setPause(boolean pause) {
		this.pause = pause;
	}
	
	
	
}
