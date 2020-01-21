package com.qk.carina.demo.api;

import java.util.Properties;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class POSTGetToken extends AbstractApiMethodV2{

	public POSTGetToken() {
		super("api/Aegonlife/retail/_post/GetToken_Req.json", null, "api/Aegonlife/retail/GetToken.properties");
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("token_url"));
		// TODO Auto-generated constructor stub
	}
	
	
	
}

