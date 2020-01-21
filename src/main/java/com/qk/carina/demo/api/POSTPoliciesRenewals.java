package com.qk.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class POSTPoliciesRenewals extends AbstractApiMethodV2
{

	public POSTPoliciesRenewals()
	{
		super("api/Aegonlife/retail/_post/Policies_Renewals_Req.json", null, "api/Aegonlife/retail/PoliciesRenewals.properties");
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
	}
	
}
