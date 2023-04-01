package com.mdo.shared;

import io.github.cdimascio.dotenv.Dotenv;

public class DotenvManager {

    public String getEnvValue(String envValue) {
        Dotenv dotenv = Dotenv.configure().load();
        String dotEnvValue = dotenv.get(envValue);
        return dotEnvValue;
    }
}
