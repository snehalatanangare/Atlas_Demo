package com.qaprosoft.carina.demo.utils;

import org.apache.log4j.Logger;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.zafira.listener.ZafiraEventRegistrar;

import compas.qualitykiosk.selenium_browser.Performance;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;

public class PerformanceStats extends AbstractPage {
	
	Logger LOGGER = Logger.getLogger(PerformanceStats.class);
	
	public PerformanceStats(WebDriver driver) {
		super(driver);
	}

	TestExecutionDetails testDetails;
	
	public long startTime, endTime;

	/*private static final String HOST = "http://192.168.209.129";
	private static final int PORT_ONE = 9300;
	private static final int PORT_TWO = 9200;
	private static final String SCHEME = "http";

	// private static RestHighLevelClient restHighLevelClient;
	private static ObjectMapper objectMapper = new ObjectMapper();

	private static final String INDEX = "api";
	private static final String TYPE = "_doc";

	private RestHighLevelClient restHighLevelClient;*/

	public void getPerformanceStats(String pageName) {

		WebDriver driver = getDriver();
		Performance getPerfStats = new Performance(driver);
		JSONArray PerfStats = getPerfStats.resource_data();
		try {
			System.out.println("******Performance Stats: " + addDetailsJSON(PerfStats, pageName));
		} catch (Exception e) {
			System.out.println("******Performance Stats Exception :-" + e.getMessage());
		}
	}

/*	@SuppressWarnings("unused")
	private static String captureHAR(WebDriver driver) {
		List<LogEntry> perfLogEntries = null;
		WebDriver drv = driver;
		if (drv instanceof EventFiringWebDriver)
			((EventFiringWebDriver) drv).getWrappedDriver();
		try {
			perfLogEntries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(perfLogEntries.size());
		List<String> list = new ArrayList<String>();
		System.out.println("Loggging started");

		for (LogEntry entry : perfLogEntries) {
			try {
				JSONObject message = new JSONObject(entry.getMessage());
				JSONObject devToolsMessage = message.getJSONObject("message");
				list.add(devToolsMessage.toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		System.out.println(list.toString());
		System.out.println("Loggging Ended");
		return list.toString();

	}*/

	
	public JSONObject addDetailsJSON(JSONArray perfStats,String PageName) throws Exception {
		JSONObject pageName = new JSONObject();
		try{
	//	int RunID = (int)ReportContext.getRootID();
		int ZafiraRunID = (int) ZafiraEventRegistrar.getTestRun().get().getId();
		LOGGER.info("ZafiraRunID: "+ZafiraRunID);
		//LOGGER.info("RunID: "+RunID);
		String SuiteName = TestExecutionDetails.getSuiteName();
		LOGGER.info("SuiteName: "+SuiteName);
		String TestCaseID = TestExecutionDetails.getTestName();
		LOGGER.info("TestCaseID: "+TestCaseID);
		pageName.put("performance details", perfStats);

		pushtoElastic(ZafiraRunID, SuiteName, TestCaseID, PageName, perfStats.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return pageName;
	}

	@SuppressWarnings("resource")
	public void pushtoElastic(int ZafiraRunID, String SuiteName, String TestCaseID, String PageName, String pagestat) throws IOException {

		String els_server = R.CONFIG.getProperties().getProperty("elastic_server_address");
		int els_port =Integer.parseInt(R.CONFIG.getProperties().getProperty("elastic_server_port"));
		
		/*TransportClient client = client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.209.129"), 9300));
				"192.168.2.17"), 9300)*/
		TransportClient client = client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new TransportAddress(InetAddress.getByName(els_server), els_port));

		BulkRequestBuilder bulkRequest = client.prepareBulk();

		bulkRequest.add(client.prepareIndex("early_pt", "_doc")
				.setSource(XContentFactory.jsonBuilder()
						.startObject().field("RunID", ZafiraRunID) //
						//.field("ZafiraRunID", ZafiraRunID)
						.field("SuiteName",SuiteName)
						.field("TestCaseID", TestCaseID)
						.field("PageName", PageName)
						.field("PageStat", pagestat) // Mention
						.field("PageResponseTime",calculateResponseTime())																							// Pagestat
																													// Variable
																													// Name
																													// instead
																													// of
																													// "PageStatJSON"
						.endObject()));

		BulkResponse bulkResponse = bulkRequest.get();
		if (bulkResponse.hasFailures()) {
			System.out.println(bulkResponse.buildFailureMessage());
		}
	}

	public void getResponseStartTime(long time) {
		startTime = time;
	}
	
	public void getResponseEndTime(long time) {
		endTime = time;
	}
	
	public long calculateResponseTime(){

		long milliseconds = endTime - startTime;
		long totalTime = (milliseconds / 1000) % 60;
		return totalTime;
	}
	
	public void beforeMethod(ITestContext ctx,Method method) {
	    try {
	        String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
	        testDetails.setSuiteName(suiteName);
	        String testMethodName = method.getName();
	        testDetails.setTestName(testMethodName);
	       // LOGGER.info("Suite Name: "+suiteName);
	       // LOGGER.info("Test Name: "+testMethodName);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}