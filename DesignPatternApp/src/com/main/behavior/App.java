package com.main.behavior;

public class App {
	public static void main(String[] args) {
		Manager manager = new Manager(); 
		AssistantManager assistantManager = new AssistantManager();
		Executive executive = new Executive();
		
		//rules of forward handling 
		executive.forwardHandler(assistantManager); 
		assistantManager.forwardHandler(manager);
		
		executive.applyLoan("AERBVG", 650000);
	}
}
/*
 *  STACK
 *  Manager manager: 100X
 *  AssistantManager assistantManager: 200X
 *  Executive executive : 300X 
 *  
 *     HEAP
 * 100X: ManagerObj 
 * 200X: AssistantManagerObj
 * 300X: ExecutiveObj 
 * 400X: 
 * 
 * 
 * 
 */