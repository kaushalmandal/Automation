package coreFramework;

public class ScreenshotHtml {
	 public static String getSource(String imgPath) {
	    	return "<img class='report-img' data-featherlight='file:///" + imgPath + "' src='file:///" + imgPath + "' />";
	    }
}
