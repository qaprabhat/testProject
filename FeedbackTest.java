package tests;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import common.BaseSetup;
import common.Sync;

import pages.FeedbackPage;
import pages.ForesightConstant;
import pages.LayerMenuPage;

/**********************************************
 * 
 * Purpose of the class**************************************** This is class
 * contains Feedback module where we check different functionality.
 * 
 * Verify submit feedback functionality. Verify view feedback status
 * functionality. Verify include screenshot functionality. Verify description
 * funtionality with or without entering text and max character length of it.
 * Verify upload file size limit and file format of submit feedback. Verify
 * detailed information for feedback. Verify submit functionality without
 * comment. Verify back button of view feedback status window. Verify cancel
 * button of submit feedback window. Verify workorder workflow window. Verify
 * minimize functionality. Verify clear button in comment section.
 */
public class FeedbackTest extends BaseSetup {
	Sync sync;
	FeedbackPage feedbackPage;
	LayerMenuPage layerMenuPage;
	static Logger log = Logger.getLogger(FeedbackTest.class);
	int feedbackValuesCounter = 0;

	/**
	 * User should be logged into foresight Click on profile icon Click on feedback
	 * option Verify SUBMIT Feedback and View feedback Status option under Feedback
	 * category. Click on "Submit Feedback" option. Click on "Type" option. Click on
	 * "Category" option. Click on "Priority" option Click on "Description" field
	 * and add description Click in "Include screenshot" option Click on "Attach
	 * file" option. Click on "Cancel" Button"
	 */

	@Test(groups = {"UAT","SANITY" }, enabled = true, priority = 1, description = "To verify that user should be able to submit feedback fields functionality.")
	public void FB_01_verifySubmitFeedbackFieldsFunctionality() {
		try {
			log.info("***************************************FB_01***********************************");
			extentTest.setDescription("To verify that user should be able to submit feedback fields functionality.");
			feedbackPage = new FeedbackPage(getDriver());
			sync = new Sync(getDriver());

			feedbackPage.feedbackPreRequisite();
			feedbackPage.verifyFeedbackOption();
			feedbackPage.clickOnSubmitFeedback();
			feedbackPage.isSubmitFeedbackPageEnable();
			feedbackPage.selectProblem();
			feedbackPage.selectLayerList();
			feedbackPage.selectCritical();
			feedbackPage.setDescription();
			feedbackPage.clickOnIncludeScreenshot();
			feedbackPage.uploadFileForFeedback();
			feedbackPage.validateFileFormatFromUi();
			feedbackPage.clickOnCancelButton();

		} catch (Exception e) {

			log.error(ForesightConstant.TEST_CASE_FAIL_MESSAGE + e);
			logError(ForesightConstant.TEST_CASE_FAIL_MESSAGE);
			Assert.fail();	}
	}

	
	
	/**
	 * Negative. User should be logged into Foresight Click on "Profile" Icon at top
	 * right corner. Click on "Feedback " option. Click on "Submit Feedback" option.
	 * Click on "Type" option. Click on "Category" option. Click on "Priority"
	 * option Click on Description field but do not add any description upload file.
	 * check send button is enable or not add description and check the count of
	 * character Click on "Attach file" option Select file with size more than 2MB.
	 * attach file other than allowed format i.e. Png., Docx, Excel, PPT.
	 *
	 */

	 @Test(groups = {"UAT","SANITY" }, enabled = true, priority = 2, description ="To verify that user should be able to attach file size (upto 10 MB), file format(Png., Docx, Excel, PPT., PPTx) and description functionality.")
	public void FB_02_verifyAttachFileFormatAndDescriptionFunctionality() {
		try {
			log.info("***************************************FB_02**********************************");
			extentTest.setDescription("To verify that user should not be able to attach file size (upto 10 MB), file format(Png., Docx, Excel, PPT., PPTx) and description functionality.");
			feedbackPage = new FeedbackPage(getDriver());
			sync = new Sync(getDriver());
			feedbackPage.feedbackPreRequisite();
			feedbackPage.clickOnSubmitFeedback();
			feedbackPage.selectProblem();
			feedbackPage.selectLayerList();
			feedbackPage.selectCritical();
			
			feedbackPage.validateDescriptionCount();
			feedbackPage.getInvalidFileUploadMessage();
			feedbackPage.getInvalidFileUploadFormat();
			feedbackPage.uploadFileForFeedback();
			feedbackPage.validate();

		} catch (Exception e) {

			log.error(ForesightConstant.TEST_CASE_FAIL_MESSAGE + e);
			logError(ForesightConstant.TEST_CASE_FAIL_MESSAGE);
			Assert.fail();
		}
	}

	
	
	
	/**
	 * Three dots functionality is not there. User has already opened the Feedback
	 * window Click on “View Feedback Status” option Click on the 3 dots visible in
	 * from of the feedback" Click on the feedback workorder available under task
	 * section" click on the back button visible at the top left corner"
	 *
	 */
	@Test(groups = {"UAT","SANITY" }, enabled = true, priority = 3, description = "To verify that user should be able to view feedback status.")
	public void FB_03_verifyViewFeedbackStatusFunctionality() {
		try {
			log.info("***************************************FB_03***********************************");
			extentTest.setDescription("To verify that user should be able to view feedback status. ");
			feedbackPage = new FeedbackPage(getDriver());
			sync = new Sync(getDriver());
			feedbackPage.feedbackPreRequisite();
			feedbackPage.clickOnViewFeedbackStatus();
			feedbackPage.clickOnMoreOptionFirstRow();
			feedbackPage.validateViewFeedbackStatusFields();
			feedbackPage.validateDetailInformationForFeedback();
			feedbackPage.clickOnCloseTaskWindowButton();
			feedbackPage.clickOnBackButton();

		} catch (Exception e) {

			log.error(ForesightConstant.TEST_CASE_FAIL_MESSAGE + e);
			logError(ForesightConstant.TEST_CASE_FAIL_MESSAGE);
			Assert.fail();
		}
	}

	
	 @Test(groups = {"UAT","SANITY" }, enabled = true, priority = 4, description ="To verify that user should be able to submit comment without adding any comment, view workflow and minimize functionality.")
	public void FB_04_verifyCommentViewWorkflowAndMinimizeFunctionality() {
		try {
			log.info("***************************************FB_04***********************************");
			extentTest.setDescription("To verify that user should be able to submit comment without adding any comment, view workflow and minimize functionality.");
			feedbackPage = new FeedbackPage(getDriver());
			sync = new Sync(getDriver());
			feedbackPage.feedbackPreRequisite();
			feedbackPage.clickOnViewFeedbackStatus();
			feedbackPage.clickOnMoreOptionFirstRow();
			feedbackPage.clickOnCommentTab();
			feedbackPage.submitButtonEnable();
			feedbackPage.setComment();
			feedbackPage.clickOnClearComment();
			feedbackPage.isClearButtonEnable();
			feedbackPage.clickOnViewWorkflow();
			feedbackPage.isViewWorkflowWindowEnable();
			feedbackPage.clickOnMinimize();

		} catch (Exception e) {

			log.error(ForesightConstant.TEST_CASE_FAIL_MESSAGE + e);
			logError(ForesightConstant.TEST_CASE_FAIL_MESSAGE);
			Assert.fail();
		}

	}

	
}