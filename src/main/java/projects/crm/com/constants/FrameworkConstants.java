package projects.crm.com.constants;

import projects.crm.com.helpers.Helpers;
import projects.crm.com.helpers.PropertiesHelper;
import projects.crm.com.utils.ReportUtils;

import java.io.File;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    static {
        PropertiesHelper.loadAllFiles();
        System.out.println("Data From FrameworkConstants: " + PropertiesHelper.getProperties());
    }

    public static final String PROJECT_PATH = Helpers.getCurrentDir();

    public static final String REPORT_TITLE = PropertiesHelper.getValue("REPORT_TITLE");
    public static final String EXTENT_REPORT_NAME = PropertiesHelper.getValue("EXTENT_REPORT_NAME");
    public static final String EXTENT_REPORT_FOLDER = PropertiesHelper.getValue("EXTENT_REPORT_FOLDER");

    public static final String OVERRIDE_REPORTS = PropertiesHelper.getValue("OVERRIDE_REPORTS");
    public static final String OPEN_REPORTS_AFTER_EXECUTION = PropertiesHelper.getValue("OPEN_REPORTS_AFTER_EXECUTION");
    public static final String SEND_EMAIL_TO_USERS = PropertiesHelper.getValue("SEND_EMAIL_TO_USERS");

    public static final int WAIT_DEFAULT = Integer.parseInt(PropertiesHelper.getValue("WAIT_DEFAULT"));
    public static final int WAIT_IMPLICIT = Integer.parseInt(PropertiesHelper.getValue("WAIT_IMPLICIT"));
    public static final int WAIT_EXPLICIT = Integer.parseInt(PropertiesHelper.getValue("WAIT_EXPLICIT"));
    public static final int WAIT_PAGE_LOADED = Integer.parseInt(PropertiesHelper.getValue("WAIT_PAGE_LOADED"));
    public static final int WAIT_SLEEP_STEP = Integer.parseInt(PropertiesHelper.getValue("WAIT_SLEEP_STEP"));
    public static final String ACTIVE_PAGE_LOADED = PropertiesHelper.getValue("ACTIVE_PAGE_LOADED");

    public static final String LOCATE = PropertiesHelper.getValue("LOCATE");
    public static final String SCREENSHOT_ALL_STEPS = PropertiesHelper.getValue("SCREENSHOT_ALL_STEPS");
    public static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_PATH + EXTENT_REPORT_FOLDER;
    public static final String EXTENT_REPORT_FILE_NAME = EXTENT_REPORT_NAME + ".html";
    public static String EXTENT_REPORT_FILE_PATH = EXTENT_REPORT_FOLDER_PATH + File.separator + EXTENT_REPORT_FILE_NAME;

    public static final String YES = "yes";
    public static final String NO = "no";


    public static String getExtentReportFilePath() {
        if (EXTENT_REPORT_FILE_PATH.isEmpty()) {
            EXTENT_REPORT_FILE_PATH = ReportUtils.createExtentReportPath();
        }
        return EXTENT_REPORT_FILE_PATH;
    }

}
