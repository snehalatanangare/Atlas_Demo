package com.qk.m1cloud.api;

import java.io.File;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;

public class POSTUploadAPKMethod extends AbstractApiMethodV2 {
	
    public POSTUploadAPKMethod() {
        super(null, null);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        request.multiPart("file",new File(R.CONFIG.getProperties().getProperty("apk_path")));
    }
}
