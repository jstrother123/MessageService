package edu.softeng.messageservice.visitors;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class VisitorFactory {
	public static Visitor create(VisitorType vistorListing) {
		return registeredLookup.get(vistorListing).createOne();
	}
	
	public static Collection<Visitor> all() {
		LinkedList<Visitor> visitors = new LinkedList<Visitor>();
		
		for (Visitor visitor : registeredLookup.values()) {
			visitors.add(visitor.createOne());
		}
		
		return visitors;
	}
	
	public static void register(VisitorType visitorType, Visitor toRegister) {
		registeredLookup.put(visitorType, toRegister);
	}
	
	public static void clear() {
		registeredLookup.clear();
	}

	private static Map<VisitorType, Visitor> registeredLookup;
	
	static {
		registeredLookup = new HashMap<VisitorType, Visitor>();
	}
}
