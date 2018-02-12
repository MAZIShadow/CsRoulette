package org.home.mazi.csroulette.repository;

public enum ResourcesRepository {
    Instance;

    public String getPathForResource(String resourceName) {
        try {
            return ClassLoader.getSystemClassLoader().getResource(resourceName).getFile();
        }
        catch(Exception ex) {
        }

        return "";
    }
}
