package com.qk.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GETPaymentSearch extends AbstractApiMethodV2 {
	
    public GETPaymentSearch(String policyNumber) {
    	super(null, null);
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
		replaceUrlPlaceholder("policyNumber", policyNumber);
   }
}
