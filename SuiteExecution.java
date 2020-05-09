package tests;



import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import common.ConfigManager;



public class SuiteExecution {
	
	
	static ConfigManager config=new ConfigManager();
	public static void main(String[] args) {
		try {

			System.out.println("inside main");
			TestNG runner=new TestNG();
			List<String> suitefiles=new ArrayList<String>();
			suitefiles.add("classes/resource/suit.xml");
			System.out.println("Suit Loaded");
			runner.setTestSuites(suitefiles);
			runner.run();
			System.out.println("Execution  Done.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
