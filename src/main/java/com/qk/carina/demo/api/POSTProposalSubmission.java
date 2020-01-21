package com.qk.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class POSTProposalSubmission extends AbstractApiMethodV2
{
	public POSTProposalSubmission() {
		super("com/aegonlife/api/preissuance/_post/ProposalSubmission_req.json", null, "com/aegonlife/api/preissuance/ProposalSubmission.properties");
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("headlessUrl"));
	}
}