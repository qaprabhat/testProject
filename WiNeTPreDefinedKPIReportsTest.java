package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import common.BaseSetup;
import common.Sync;
import pages.WiNeTPreDefinedKPIReportsPage;

public class WiNeTPreDefinedKPIReportsTest extends BaseSetup{
	Sync sync;
	WiNeTPreDefinedKPIReportsPage preDefinedKpiReportPage;
	static Logger log = Logger.getLogger(WiNeTPreDefinedKPIReportsTest.class);

	@Test
	public void addNewProvisioningFailedReport() 
	{
		
		preDefinedKpiReportPage = new WiNeTPreDefinedKPIReportsPage(getDriver());
		preDefinedKpiReportPage.NavigateToViewApps();
		preDefinedKpiReportPage.navigateToPreDefinedKPIModule();
		//preDefinedKpiReportPage.navigateToReportBuilder();
		
		//preDefinedKpiReportPage.addNewProvisionedFaildReport();
		
	}

}
