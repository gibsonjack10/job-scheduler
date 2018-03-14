
public class JobLList implements WaitingListADT<JobNode> {

	private JobNode head;
	private int size;
	
	public JobLList() {
		this.head = null;
		this.size = 0;
	}
	
	@Override
	public void schedule(JobNode newJob) {
		JobNode newNode = new JobNode(newJob.getArrival(), newJob.getUserId(),
				newJob.getPriority(), newJob.getTTL(), newJob.getDescription());
		if (isEmpty()) {
			head = newNode;
		}
		if(newJob.getPriority() == 0) {
			newNode.setNext(null);
		} else {
			while(newNode.getPriority() != 0) {
				if(newNode.getNext() == null) {
					newNode.setNext(null);
				} else {
					newNode.setNext(newNode);
				}
			}
		}
		
		size++;
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
		
		
	}

	@Override
	public WaitingListADT<JobNode> duplicate() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
