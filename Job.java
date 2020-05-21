
public class Job {
	private final int id;
	private final float startTime;
	private final float finishTime;
	
	public Job(int id, float startTime, float finishTime) {
		this.id = id;
		this.startTime = startTime;
		this.finishTime = finishTime;
	}
	
	public int getId() {
		return id;
	}
	public float getStartTime() {
		return startTime;
	}
	public float getFinishTime() {
		return finishTime;
	}
	
	public String toString() {
		return "(" + id + ", " + startTime + ", " + finishTime + ")";
	}
}
