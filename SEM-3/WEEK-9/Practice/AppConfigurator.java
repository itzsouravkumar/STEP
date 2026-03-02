package Practice;
public class AppConfigurator {
    public static void main(String[] args) {
        AppConfig.NetworkConfig netConfig = new AppConfig.NetworkConfig("localhost", 8080);
        netConfig.displayConfig();

        AppConfig app = new AppConfig("MyApp");
        netConfig.displayConfigWithApp(app);
    }
}

class AppConfig {
    private String appName;

    public AppConfig(String appName) {
        this.appName = appName;
    }

    public static class NetworkConfig {
        private String host;
        private int port;

        public NetworkConfig(String host, int port) {
            this.host = host;
            this.port = port;
        }

        public void displayConfig() {
            System.out.println("Host: " + host + ", Port: " + port);
        }

        public void displayConfigWithApp(AppConfig app) {
            System.out.println("App: " + app.appName + ", Host: " + host + ", Port: " + port);
        }
    }
}