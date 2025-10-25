// File: NotificationService.java
// Anonymous Inner Class Problem: "Notification Service"

interface Notifier {
    void send(String message);
}

class Service {
    public void triggerAlert() {
        // TODO: Create Notifier instance using anonymous inner class and send an alert
        Notifier alertNotifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("🚨 ALERT: " + message);
                System.out.println("Alert sent at: " + java.time.LocalDateTime.now());
            }
        };
        
        // Send the alert
        alertNotifier.send("System maintenance required!");
    }
    
    public void sendWelcomeMessage() {
        // Another anonymous inner class for welcome messages
        Notifier welcomeNotifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("👋 WELCOME: " + message);
                System.out.println("Welcome message sent successfully!");
            }
        };
        
        welcomeNotifier.send("Welcome to our service!");
    }
    
    public void sendCustomNotification(String type, String message) {
        // Anonymous inner class with custom behavior based on type
        Notifier customNotifier = new Notifier() {
            @Override
            public void send(String message) {
                String prefix = "";
                switch (type.toLowerCase()) {
                    case "error":
                        prefix = "❌ ERROR";
                        break;
                    case "info":
                        prefix = "ℹ️ INFO";
                        break;
                    case "success":
                        prefix = "✅ SUCCESS";
                        break;
                    default:
                        prefix = "📢 NOTIFICATION";
                }
                
                System.out.println(prefix + ": " + message);
                System.out.println("Notification type: " + type);
                System.out.println("Timestamp: " + java.time.LocalDateTime.now());
            }
        };
        
        customNotifier.send(message);
    }
    
    public static void main(String[] args) {
        Service service = new Service();
        
        System.out.println("=== Notification Service ===");
        System.out.println();
        
        // Trigger alert using anonymous inner class
        System.out.println("1. Triggering Alert:");
        service.triggerAlert();
        System.out.println();
        
        // Send welcome message
        System.out.println("2. Sending Welcome Message:");
        service.sendWelcomeMessage();
        System.out.println();
        
        // Send custom notifications
        System.out.println("3. Sending Custom Notifications:");
        service.sendCustomNotification("error", "Database connection failed!");
        System.out.println();
        
        service.sendCustomNotification("info", "System update available");
        System.out.println();
        
        service.sendCustomNotification("success", "Payment processed successfully");
        System.out.println();
        
        // Demonstrate anonymous inner class with lambda-like behavior
        System.out.println("4. Anonymous Inner Class with Custom Logic:");
        Notifier timeBasedNotifier = new Notifier() {
            @Override
            public void send(String message) {
                int hour = java.time.LocalTime.now().getHour();
                String timeOfDay = (hour < 12) ? "Morning" : (hour < 18) ? "Afternoon" : "Evening";
                System.out.println("Good " + timeOfDay + "! " + message);
            }
        };
        
        timeBasedNotifier.send("Have a great day!");
    }
}
