package com.ShopDemoQA.Infra;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class HelloWolrd {


	static Logger logger = LogManager.getLogger(HelloWolrd.class);
	
	public static void main(String[] args) {
	
		String projectPath = System.getProperty("user.dir");
		ReadWriteExcelFile wrExcel = new ReadWriteExcelFile(projectPath+"/dataFiles/TestData.xlsx","Register");
//		
		
		wrExcel.writeexcel(1, "Sumit Sandilaya", "Sumit Sandilaya" );
//		
//		for (int rowNum = 1; rowNum <2; rowNum++){
//			
//
//	}

	}
}
