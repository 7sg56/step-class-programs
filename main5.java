import java.util.*;

public class main5 {

    static class EmailInfo {
        String email;
        String username;
        String domain;
        String domainName;
        String extension;
        boolean isValid;

        EmailInfo(String email) {
            this.email = email;
            this.isValid = validateEmail(email);

            if (isValid) {
                int atPos = email.indexOf('@');
                username = email.substring(0, atPos);
                domain = email.substring(atPos + 1);

                int dotPos = domain.lastIndexOf('.');
                if (dotPos != -1 && dotPos < domain.length() - 1) {
                    domainName = domain.substring(0, dotPos);
                    extension = domain.substring(dotPos + 1);
                } else {
                    domainName = domain;
                    extension = "";
                }
            } else {
                username = domain = domainName = extension = "";
            }
        }

        // Validate email format
        private boolean validateEmail(String email) {
            int atIndex = email.indexOf('@');
            int lastAtIndex = email.lastIndexOf('@');

            // Exactly one '@'
            if (atIndex == -1 || atIndex != lastAtIndex) {
                return false;
            }

            String user = email.substring(0, atIndex);
            String dom = email.substring(atIndex + 1);

            // Username and domain not empty
            if (user.isEmpty() || dom.isEmpty()) {
                return false;
            }

            // At least one '.' after '@'
            int dotAfterAt = dom.indexOf('.');
            if (dotAfterAt == -1) {
                return false;
            }

            // domain name and extension should be non-empty (dot not at start or end)
            if (dom.startsWith(".") || dom.endsWith(".")) {
                return false;
            }

            return true;
        }
    }

    // Analyze statistics
    static class Stats {
        int validCount = 0;
        int invalidCount = 0;
        Map<String, Integer> domainFrequency = new HashMap<>();
        int totalUsernameLength = 0;

        void addEmailInfo(EmailInfo info) {
            if (info.isValid) {
                validCount++;
                totalUsernameLength += info.username.length();
                domainFrequency.put(info.domain, domainFrequency.getOrDefault(info.domain, 0) + 1);
            } else {
                invalidCount++;
            }
        }

        String mostCommonDomain() {
            String mostCommon = "N/A";
            int maxCount = 0;
            for (Map.Entry<String, Integer> entry : domainFrequency.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    mostCommon = entry.getKey();
                }
            }
            return mostCommon;
        }

        double averageUsernameLength() {
            return validCount == 0 ? 0 : (double) totalUsernameLength / validCount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<EmailInfo> emails = new ArrayList<>();
        Stats stats = new Stats();

        System.out.println("Enter email addresses (enter blank line to stop):");
        while (true) {
            String email = sc.nextLine().trim();
            if (email.isEmpty()) break;

            EmailInfo info = new EmailInfo(email);
            emails.add(info);
            stats.addEmailInfo(info);
        }

        // Display header
        System.out.printf("%-30s | %-15s | %-20s | %-15s | %-10s | %-8s\n",
                "Email", "Username", "Domain", "Domain Name", "Extension", "Valid");
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        for (EmailInfo info : emails) {
            System.out.printf("%-30s | %-15s | %-20s | %-15s | %-10s | %-8s\n",
                    info.email,
                    info.username,
                    info.domain,
                    info.domainName,
                    info.extension,
                    info.isValid ? "Yes" : "No");
        }

        System.out.println("\nStatistics:");
        System.out.println("Total Emails      : " + emails.size());
        System.out.println("Valid Emails      : " + stats.validCount);
        System.out.println("Invalid Emails    : " + stats.invalidCount);
        System.out.println("Most Common Domain: " + stats.mostCommonDomain());
        System.out.printf("Average Username Length: %.2f\n", stats.averageUsernameLength());

        sc.close();
    }
}
