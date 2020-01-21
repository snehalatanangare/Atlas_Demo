package com.qk.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostUserCreationMethod extends AbstractApiMethodV2 {
    public PostUserCreationMethod() {
        super(null,null);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
