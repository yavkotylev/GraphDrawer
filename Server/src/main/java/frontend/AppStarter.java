package frontend;

import frontend.controller.Controller;

public class AppStarter {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.startApp();
    }
}
