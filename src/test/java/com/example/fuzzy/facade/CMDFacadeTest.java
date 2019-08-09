package com.example.fuzzy.facade;

import org.junit.Test;

public class CMDFacadeTest {

	CMDFacade facade = new CMDFacade();

	@Test
	public void exectSearch() {
		facade.exec("./application search {\"search\":\"Israel\"}");

	}
	
	@Test
	public void exectAdd() {
		facade.exec("./application add {\"name\":\"Israel Ivan\"}");

	}
	
	@Test
	public void exectList() {
		facade.exec("./application list");

	}

}
