package objectrepository.Social;

import org.openqa.selenium.By;

public class POM_ION {
	
	public static final By tasks=By.name("Tasks");
	public static final By workflows=By.name("Workflows");
	public static final By Add_workflow=By.id("com.infor.mingle:id/btnAdd");
	public static final By selectworkflow=By.xpath("//android.widget.TextView[contains(@text, 'WF_AllParameterswithout')]");
	public static final By selectwf1=By.xpath("//android.widget.TextView[contains(@text, 'mobileautomation')]");
	public static final By parametervalue=By.id("com.infor.mingle:id/tvValue");
	
	//Workflow Parameters
	public static final By workflowName=By.id("com.infor.mingle:id/tvWorkFlowInstanceName");
	public static final By DG=By.name("DG");
	public static final By DG_itemname=By.id("com.infor.mingle:id/tvItemName");
	
	public static final By hyplink=By.name("Hyperlink");
	public static final By hp_text=By.id("com.infor.mingle:id/etValue");
	
	public static final By DT=By.name("DateTime");
	public static final By timeheader=By.id("android:id/time_header");
	public static final By picktime=By.xpath("//android.widget.RadialTimePickerView$RadialPickerTouchHelper[@content-desc='3']");
	public static final By picketime1=By.xpath("//android.widget.RadialTimePickerView$RadialPickerTouchHelper[@index='3']");
	public static final By selectedDT=By.xpath("//android.view.View[contains(@content-desc, 'selected')]");
	
	public static final By str=By.name("String");
	public static final By str1=By.name("string");
	
	public static final By strtext=By.id("com.infor.mingle:id/etValue");
	
	public static final By Date=By.name("Date");
	
	public static final By boole=By.name("Boolean");
	public static final By boole_Off=By.name("OFF");
	public static final By bool_Switch=By.id("com.infor.mingle:id/boolSwitch");
	
	public static final By DC=By.name("Decimal");
	
	public static final By DC_Txt=By.xpath("//android.widget.TextView[@text='Decimal']/android.widget.EditText[@index='1']");
	
	public static final By code=By.name("Code");
	public static final By code_Approved=By.name("Approved");
	
	public static final By inte=By.name("Integer");
	public static final By usr=By.name("User");
	public static final By usr_item=By.id("com.infor.mingle:id/tvItemName");
	public static final By Attmnt=By.name("Attachments");
	public static final By Addnew=By.name("Add New");
	
	public static final By workflow_Start=By.id("com.infor.mingle:id/action_start");
	public static final By waitforinstance=By.id("com.infor.mingle:id/tvWorkFlowInstanceName");
	
	public static final By workflow_Filter=By.id("com.infor.mingle:id/action_filter");
	public static final By wf_allwfs=By.name("All Workflows");
	public static final By wf_runningwfs=By.name("Running Workflows");
	public static final By wf_cmpltdgwfs=By.name("Completed Workflows");
	public static final By wf_cancldgwfs=By.name("Canceled Workflows");
	public static final By wf_faildgwfs=By.name("Failed Workflows");
	public static final By wf_moreoptions=By.xpath("//android.widget.ImageView[@content-desc='More options']");
	public static final By remove_Wf=By.name("Remove Workflow");
	
	
	
	
	

}
