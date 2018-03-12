package org.home.mazi.csroulette.repository;

import java.io.InputStream;

public enum ResourcesRepository {
    Instance;

    public InputStream getInputStreamForResourceName(String resourceName) {
        try {
            return ClassLoader.getSystemClassLoader().getResourceAsStream(resourceName);
        }
        catch(Exception ex) {
        }

        return null;
    }
}
