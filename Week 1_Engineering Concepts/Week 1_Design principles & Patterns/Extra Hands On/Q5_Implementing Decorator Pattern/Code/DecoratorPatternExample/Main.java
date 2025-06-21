public class Main{
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();

        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        Notifier slackAndSmsNotifier = new SlackNotifierDecorator(smsNotifier);

        slackAndSmsNotifier.send("Your transaction is successful.");
    }
}
