// File: AppConfig.java
// Static Nested Class Problem: "App Configuration"

class AppConfig {
    private String appName;
    private static String version = "1.0.0";
    
    public AppConfig(String appName) {
        this.appName = appName;
    }
    
    // Static Nested Class
    public static class NetworkConfig {
        private String host;
        private int port;
        
        public NetworkConfig(String host, int port) {
            this.host = host;
            this.port = port;
        }
        
        // Display network config with optional access to app static members
        public void displayConfig() {
            System.out.println("Network Configuration:");
            System.out.println("Host: " + this.host);
            System.out.println("Port: " + this.port);
            System.out.println("App Version: " + version); // Access to static member
        }
        
        // Method to create a complete config string
        public String getConfigString() {
            return "Host: " + host + ", Port: " + port + ", Version: " + version;
        }
        
        // Getters
        public String getHost() {
            return host;
        }
        
        public int getPort() {
            return port;
        }
    }
    
    // Getter for app name
    public String getAppName() {
        return appName;
    }
    
    // Static getter for version
    public static String getVersion() {
        return version;
    }
}

class AppConfigurator {
    public static void main(String[] args) {
        // Create instance of NetworkConfig, print details
        AppConfig.NetworkConfig networkConfig = new AppConfig.NetworkConfig("localhost", 8080);
        
        System.out.println("=== App Configuration System ===");
        System.out.println();
        
        // Display network configuration
        networkConfig.displayConfig();
        System.out.println();
        
        // Show complete configuration string
        System.out.println("Complete Config: " + networkConfig.getConfigString());
        System.out.println();
        
        // Demonstrate static nested class can be instantiated without outer class instance
        AppConfig.NetworkConfig prodConfig = new AppConfig.NetworkConfig("prod-server.com", 443);
        AppConfig.NetworkConfig devConfig = new AppConfig.NetworkConfig("dev-server.com", 3000);
        
        System.out.println("=== Multiple Network Configurations ===");
        System.out.println("Production Config:");
        prodConfig.displayConfig();
        System.out.println();
        
        System.out.println("Development Config:");
        devConfig.displayConfig();
        System.out.println();
        
        // Demonstrate access to static members from nested class
        System.out.println("=== Static Member Access ===");
        System.out.println("App Version (from nested class): " + AppConfig.getVersion());
        System.out.println("Network configs share the same app version: " + AppConfig.getVersion());
        
        // Create outer class instance to show relationship
        AppConfig app = new AppConfig("MyApplication");
        System.out.println("\nOuter class app name: " + app.getAppName());
        System.out.println("Static version accessible from outer class: " + AppConfig.getVersion());
    }
}
