package com.satconfluence.chatBot;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfluenceTroubleshoot {
	
	@Autowired
	ConfluencePageCreator createpage;
	
	public void troubleshootConfluence(String spacekey) throws IOException, InterruptedException
	
	{
		String x = "I can see high heap memory usage in the logs. Heap issues can cause performance problems and make it difficult to use Confluence effectively. Here are some steps you can take to address heap issues:  Check the current heap size: You can check the current heap size by going to the System Information page in the Confluence Administration Console. The heap size is listed under the Java Virtual Machine section. If the heap size is close to the maximum allowed, it could be causing issues.\n"
				+ "Increase the heap size: If the current heap size is too small, you can increase it by editing the JVM arguments in the setenv.sh or setenv.bat file, depending on your operating system. You can increase the heap size by adding the following argument to the file:\n"
				+ "-Xmx maximum heap size\n"
				+ "For example, to set the maximum heap size to 4 GB, you would add the following argument:\n"
				+ "-Xmx4g\n"
				+ "Save the changes and restart Confluence for the changes to take effect.\n"
				+ "Monitor heap usage: You can use Confluences built-in monitoring tools to monitor heap usage over time. This will help you identify trends and potential issues before they become a problem. To access the monitoring tools, go to the Monitoring page in the Confluence Administration Console.\n"
				+ "Review third-party apps: If you have installed third-party apps in Confluence, they may be contributing to the heap issues. Review the apps you have installed and consider disabling any that are not necessary.\n"
				+ "Optimize content: Large pages, images, and other content can contribute to heap issues. Optimize your content by compressing images, removing unnecessary content, and splitting large pages into smaller ones.\n"
				+ "Upgrade hardware: If you have tried all the above steps and are still experiencing heap issues, consider upgrading your hardware to provide more resources for Confluence.\n"
				+ "I hope these steps help you address your heap issues in Confluence. If you continue to experience problems, you may want to contact Atlassian support for additional assistance.";
		
		createpage.createConfluencePageUsingSpacekey("Analysis and summary of recent logs", "SUP", x);
		
	}

}
