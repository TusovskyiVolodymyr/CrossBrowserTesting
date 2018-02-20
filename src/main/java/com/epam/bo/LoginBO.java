package com.epam.bo;

import com.epam.pages.LoginPO;

public class LoginBO {

    private LoginPO loginPO;

    public LoginBO() {
        this.loginPO = new LoginPO();
    }

    public void checkLocatorsSpeed() {
        loginPO.findByName();
        loginPO.findById();
        loginPO.findByCSS();
        loginPO.findByXPath();
        loginPO.findByXPathCashed();
    }
}
