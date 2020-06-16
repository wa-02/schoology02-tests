package org.example.schoology.account;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;

public final class Account {

    private static final String CONFIG_JSON_PATH = "config.json";
    private static Account instance = new Account();
    private DocumentContext jsonContext;

    private Account() {

        JSONObject jsonObject = JsonHelper.getJsonObject(CONFIG_JSON_PATH);
        jsonContext = JsonPath.parse(jsonObject);
    }

    public static Account getInstance() {
        return instance;
    }

    public String getValue(final String keyJsonPath) {
        return jsonContext.read(keyJsonPath);
    }

}
