
public class JobLList implements WaitingListADT<JobNode> {

	private JobNode head;
	private int size;
	
	public JobLList() {
		this.head = null;
		this.size = 0;
	}
	
	@Override
	public void schedule(JobNode newJob) {
		if(isEmpty()) {
			head = newJob;
		} else if(!isEmpty() && newJob.getPriority() == 0) {
			JobNode last = head;
			while(last.getNext() != null) {
				last = last.getNext();
			}
			last = last.getNext();
			last = newJob;
		}
		
//		JobNode newNode = new JobNode(newJob.getArrival(), newJob.getUserId(),
//				newJob.getPriority(), newJob.getTTL(), newJob.getDescription());
//		if (isEmpty()) {
//			head = newNode;
//		}
//		if(newJob.getPriority() == 0) {
//			newNode.setNext(null);
//		} else {
//			while(newNode.getPriority() != 0) {
//				if(newNode.getNext() == null) {
//					newNode.setNext(null);
//				} else {
//					newNode.setNext(newNode);
//				}
//			}
//		}
//		
//		size++;
	}

	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public int clean(float cleaningTime) {
		JobNode currentNode = head;
		JobNode prevNode = head;
		int cleanedJobs = 0;
		while(currentNode != null) {
			if(currentNode.getArrival() + currentNode.getTTL() < cleaningTime) {
				if(currentNode == head) {
					head = head.getNext();
				} else {
					prevNode.setNext(currentNode.getNext());
				}
				size--;
				cleanedJobs++;
			}
			prevNode = currentNode;
			currentNode = currentNode.getNext();
			
		}
		return cleanedJobs;
	}

	@Override
	public void clear() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public WaitingListADT<JobNode> duplicate() {
		WaitingListADT<JobNode> newList = new JobLList();
		JobNode copy = head;
		while(copy != null) {
			newList.schedule(copy);
			copy = copy.getNext();
		}
		return newList;
	}
	
	public String toString() {
		System.out.println("Job list is empty: " + isEmpty());
		System.out.println("The size is: " + this.size + " job(s)");
		JobNode display = this.head;
		if(display != null) {
			while(display != null) {
				System.out.println("job #" + display.getJobId() + " : " + display.getDescription()
				+ " " + display.getUserId() + " " + display.getPriority());
				display = display.getNext();
			}
		}
		
		return "";
		
	}
	
}