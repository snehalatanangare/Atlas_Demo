package com.qk.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class POSTProposalApplication extends AbstractApiMethodV2
{

	public POSTProposalApplication()
	{
		super("api/Aegonlife/retail/_post/Proposals_Application_Req.json", null, "api/Aegonlife/retail/ProposalApplicationIssuance.properties");
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
	}
	
}
