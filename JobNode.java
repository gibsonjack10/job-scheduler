/**
 * File Header COMES HERE
 */
 
/**
 * JavaDoc Class Header COMES HERE
 *
 */
 
public class JobNode {
		
	// Class Fields
	private static int jobCount = 0; // number of jobs already created
	
	// Object Fields
	private int jobId; 			// unique job identifier
	private float arrivalTime;  // arrival time in seconds
	private int userId;			// identifier of the user that created the job
	private int priority; 		// job priority
	private int timeToLive; 	// job Time To Live in seconds
	private String description; // job description
	
	private JobNode next; // reference to the next job in the linked list
	
	// Constructor using fields
	/**
	 * Description of the constructor comes here
	 * @param arrivalTime
	 * @param userId
	 * @param priority
	 * @param ttl
	 * @param description
	 */
	public JobNode(float arrivalTime, int userId, int priority, 
			int ttl, String description) {
		this.arrivalTime = arrivalTime;
		this.userId = userId;
		this.priority = priority;
		this.timeToLive = ttl;
		this.description = description;
		jobCount++;
		jobId = jobCount;
		
	}
	
	// You can overload your class by other constructors
	
	// TODO Add Getters and Setters Methods as needed
	/**
	 * Gets the job ID
	 */
	public int getJobId() {
		return this.jobId;
	}
	
	/**
	 * Gets the arrival Time
	 */
	public float getArrival() {
		return this.arrivalTime;
	}
	
	/**
	 * gets the user ID
	 */
	public int getUserId() {
		return this.userId;
	}
	
	/**
	 * Gets the priority number
	 */
	public int getPriority() {
		return this.priority;
	}
	
	/**
	 * Gets the job time to live number
	 */
	public int getTTL() {
		return this.timeToLive;
	}
	
	/**
	 * Gets the description of the job
	 */
	public String getDescription() {
		return this.description;
	}
 
	/**
	 * returns the next JobNode
	 */
	public JobNode getNext() {
		return this.next;
	}
	
	/**
	 * sets the the next node for a previous jobNode
	 */
	public void setNext(JobNode newJob) {
		next = newJob;
	}
	
	/**
	 * This method returns a new reference to a copy of the current JobNode
	 * @return a new reference to a copy of this (instanceof JobNode)
	 */
	public JobNode copy() {
		JobNode copy = new JobNode(arrivalTime, userId,
				priority, timeToLive, description);
		jobId = jobCount;
		return copy;
	}
}
