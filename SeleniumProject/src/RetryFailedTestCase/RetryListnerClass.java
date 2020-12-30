package RetryFailedTestCase;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListnerClass implements IAnnotationTransformer {
	@Override
	public void transform(ITestAnnotation annotation, Class testclass, Constructor testconstructor, Method testmethod) {
		//IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		annotation.setRetryAnalyzer(RetryFailedTestCaseInSelenium.class);
	}
}
