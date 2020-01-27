/*
 * 7.2 Call Center
 * 
 * Imagine you have a call center with three levels of employees: respondent, manager,
 * and director. An incoming telephone call must be first allocated to a respondent who is free. If the
 * respondent can't handle the call, he or she must escalate the call to a manager. If the manager is not
 * free or not able to handle it, ten the call should be escalated to a director. Design the classes and
 * data structures for this problem. Implement a method dispatchCall() which assigns a call to
 * the first available employee.
 */

package CallCenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CallCenter {
	private ArrayList<Employee> responders;
	private ArrayList<Employee> managers;
	private Employee director;
	private Queue<Caller> incomingCalls;

	public CallCenter(ArrayList<Employee> responders, ArrayList<Employee> managers, Employee director) {
		this.responders = responders;
		this.managers = managers;
		this.director = director;
		this.incomingCalls = new LinkedList<>();
	}

	public void dispatchCall(Caller caller) throws InterruptedException {
		this.incomingCalls.add(caller);
		
		Employee calee = getAvailableEmployer();
		calee.answer(this.incomingCalls.poll());
	}

	private Employee getAvailableEmployer() {
		for (Employee e : this.responders) {
			if (e.isAvailable()) {
				return e;
			}
		}

		for (Employee e : this.managers) {
			if (e.isAvailable()) {
				return e;
			}
		}

		return this.director;
	}
}
