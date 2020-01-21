package com.qk.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class POSTProposalIssuance extends AbstractApiMethodV2
{

	public POSTProposalIssuance()
	{
		super("api/Aegonlife/retail/_post/Proposals_Issurance_Req.json", null, "api/Aegonlife/retail/ProposalIssurance.properties");
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
	}
	
}
