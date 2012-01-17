package com.lge.agileJava;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.lge.agileJava.studentinfo.CourseSessionTest;
import com.lge.agileJava.studentinfo.DateUtilTest;
import com.lge.agileJava.studentinfo.StudentTest;
import com.lge.agileJava.report.RosterReporterTest;


@RunWith(Suite.class)
@Suite.SuiteClasses( {
	StudentTest.class,
	CourseSessionTest.class,
	RosterReporterTest.class,
	DateUtilTest.class
})

public class AllTests {

}
