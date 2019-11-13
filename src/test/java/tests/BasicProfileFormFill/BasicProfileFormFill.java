package tests.BasicProfileFormFill;

import common.TestBase;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.demoProfileForm.DemoPage;
import utils.enums.Gender;
import utils.enums.Scripts;
import utils.Utility;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class BasicProfileFormFill extends TestBase {

    private static Logger log = Logger.getLogger(BasicProfileFormFill.class.getName());

    @Test
    public void verifyUploadDownloadDoc() throws IOException {
        DemoPage demoPage =new DemoPage(driver);
        demoPage.dismissPopup();
        log.info("Popup is dismissed");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(demoPage.isDemoPageOpen(), "Demo page is not open.");
        log.info("Test page is opened.");

        demoPage.sendFirstNameLastName();
        log.info("First name and last name are filled in.");

        demoPage.checkBox();
        log.info("Checkbox is checked.");

        softAssert.assertEquals(demoPage.getFullNameValue(),"Ion Popescu", "Full name not correct.");
        log.info("Full name is correct.");

        demoPage.checkGenderOption("male");
        softAssert.assertTrue(demoPage.isGenderButtonEnabled(Gender.MALE),"Gender cannot be selected.");
        log.info("Gender <male> is selected.");

        demoPage.selectAge();
        softAssert.assertEquals(demoPage.getAgeValue(), "23","Age cannot be typed in.");
        log.info("Age is filled in.");

        demoPage.selectBirthdate();
        softAssert.assertEquals(demoPage.getBirthDateValue(),"1973-12-03", "Birth date cannot be typed in.");
        log.info("Birth date is selected.");

        demoPage.selectId();
        softAssert.assertEquals(demoPage.getSelectedIdValue(),"Driving License","ID cannot be selected.");
        log.info("ID option is selected.");

        demoPage.selectCountry();
        softAssert.assertEquals(demoPage.getCountryValue(),"Rwanda","Country cannot be typed in.");
        log.info("Country is filled in.");

        demoPage.uploadFile(Scripts.FILE_TO_UPLOAD_JPG);
        softAssert.assertTrue(demoPage.getUploadedFileValue().endsWith("\\SoftwareTestingMaterial.jpg"),"File not uploaded.");
        log.info("File is uploaded");

        FileUtils.cleanDirectory(new File(TestBase.DOWNLOAD_PATH));
        demoPage.downloadFile();
        softAssert.assertFalse(Utility.isDirEmpty(DOWNLOAD_PATH),"File not downloaded.");
        log.info("File is downloaded.");

        softAssert.assertAll();
    }
}

